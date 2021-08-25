package vn.nacl.core.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import vn.nacl.core.dao.UserDao;
import vn.nacl.core.daoimpl.UserDaoImpl;
import vn.nacl.core.peristence.entity.UserEntity;

public class LoginTest {
    private final Logger logger= Logger.getLogger(this.getClass());
    @Test
    public void checkIsUserExist(){
        UserDao userDao=new UserDaoImpl();
        String name= "lqtrung";
        String password="123456";
        UserEntity entity=userDao.findUserByUsernameAndPassword(name,password);
        if(entity!=null){
            logger.error("success");
        }else {
            logger.error("fail");
        }
    }
    @Test
    public void checkFindRoleByUser(){
        UserDao userDao=new UserDaoImpl();
        String name= "lqtrung";
        String password="123456";
        UserEntity entity=userDao.findUserByUsernameAndPassword(name,password);
        logger.error(entity.getRole().getRoleId()+ " - "+ entity.getRole().getName());
    }
}
