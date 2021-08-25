package vn.nacl.core.dao;

import vn.nacl.core.data.dao.GenericDao;
import vn.nacl.core.peristence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    UserEntity findUserByUsernameAndPassword(String name, String password);
}
