package vn.nacl.core.testng;
import org.testng.annotations.Test;
import vn.nacl.core.dao.RoleDao;
import vn.nacl.core.daoimpl.RoleDaoImpl;
import vn.nacl.core.peristence.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public class TesyRole {
    @Test
    public void checkFindAll(){
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }
    @Test
    public void checkUpdate(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("Hahaha ");
        roleDao.update(roleEntity);
    }
    @Test
    public void checkSave(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setRoleId(3);
        roleEntity.setName("Huhuhu");
        roleDao.save(roleEntity);
    }
    @Test
    public  void checkFindByID(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity= roleDao.findByID(1);
    }
//    @Test
//    public  void checkFindByProperty(){
//        RoleDao roleDao = new RoleDaoImpl();
//        String proterty=null;
//        Object value=null;
//        String sortEx=null;
//        String sortDirec= null;
//        Object[] objects=roleDao.findByProperty(proterty,value,sortEx,sortDirec);
//    }
    @Test
    public void checkDelete(){
        List<Integer> list= new ArrayList<>();
        list.add(3);
        RoleDao roleDao = new RoleDaoImpl();
        Integer count= roleDao.delete(list);
    }
}
