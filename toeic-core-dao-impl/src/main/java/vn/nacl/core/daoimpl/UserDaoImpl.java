package vn.nacl.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.nacl.core.common.utils.HibernateUtil;
import vn.nacl.core.dao.UserDao;
import vn.nacl.core.data.daoimpl.AbstractDao;
import vn.nacl.core.peristence.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {
    @Override
    public UserEntity findUserByUsernameAndPassword(String name, String password) {
        UserEntity entity=new UserEntity();
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();

        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query=session.createQuery(sql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            entity= (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return entity;

    }
}
