package vn.nacl.core.data.daoimpl;

import javassist.tools.rmi.ObjectNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.nacl.core.common.constant.CoreConstant;
import vn.nacl.core.common.utils.HibernateUtil;
import vn.nacl.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T>
{
    private Class<T> persistenceClass;

    public AbstractDao()
    {
        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }

    @Override
    public List<T> findAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<T> list = new ArrayList<T>();
        Transaction transaction= null;
        try {
            transaction =session.beginTransaction();

            //HQL
            StringBuilder sql= new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            //
            Query query=session.createQuery(sql.toString());
            list= query.list()  ;
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            System.out.println("Transectione is Null: " + e);
            throw e;
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public T update(T entity)
    {
        Session session= HibernateUtil.getSessionFactory().openSession();
        T result=null;
        Transaction transaction= session.beginTransaction();
        try
        {
            Object object= session.merge(entity);
            result = (T) object;
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }

    @Override
    public void save(T entity)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        try
        {
            session.persist(entity);
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }

    }

    @Override
    public T findByID(ID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        T result=null;
        try{
            result = (T) session.get(persistenceClass, id);
            if(result==null) {
                throw new ObjectNotFoundException("Not found" +id, null);
            }
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    //public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit)
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit)

    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        List<T> list = new ArrayList<T>();
        Object total=0;
        String[] params= new String[property.size()];
        Object[] values=new String[property.size()];
        int i=0;
        for(Map.Entry item:property.entrySet()){
            params[i]= (String) item.getKey();
            values[i]= item.getValue();
            i++;
        }
        try
        {
            StringBuilder sql= new StringBuilder("from ");
            sql.append(getPersistenceClassName());
            if(property.size()>0){
                for(int i1=0; i1<params.length; i1++){
                    if(i1==0)  sql.append(" where ").append(params[i1]).append("= :"+params[i1]+"");
                    else sql.append(" and ").append(params[i1]).append("= :"+params[i1]+"");
                }
            }
            if(sortDirection!=null && sortExpression!=null)
            {
                sql.append(" order by ").append(sortExpression);
                sql.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query query1 = session.createQuery(sql.toString());
            if(property.size()>0){
                for(int i1=0; i1<params.length; i1++){
                    query1.setParameter(params[i1], values[i1]);
                }
            }
            if(offset !=null && offset>=0){
                query1.setFirstResult(offset);
            }
            if(limit!=null && limit>0){
                query1.setMaxResults(limit);
            }
            list= query1.list();
            //
            StringBuilder sql1= new StringBuilder("select count(*) from ");
            sql1.append(getPersistenceClassName());
            if(property.size()>0){
                for(int k=0; k<params.length; k++){
                    if(k==0)  sql1.append(" where ").append(params[k]).append("= :"+params[k]+"");
                    else sql1.append(" and ").append(params[k]).append("= :"+params[k]+"");
                }
            }
            Query query2 = session.createQuery(sql1.toString());
            if(property.size()>0){
                for(int k1=0; k1<params.length; k1++){
                    query2.setParameter(params[k1], values[k1]);
                }
            }
            total= query2.list().get(0);
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return new Object[]{total,list};
    }

    @Override
    public Integer delete(List<ID> ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Integer count=0;
        try{
            for (ID item:ids){
                T t= (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return count;
    }
}
