package vn.nacl.core.service.impl;

import vn.nacl.core.dao.UserDao;
import vn.nacl.core.daoimpl.UserDaoImpl;
import vn.nacl.core.dto.UserDTO;
import vn.nacl.core.peristence.entity.UserEntity;
import vn.nacl.core.service.UserService;
import vn.nacl.core.utils.UserBeanUtil;

public class UserServiceImpl implements UserService {

    @Override
    public UserDTO isUserExist(UserDTO dto) {
        UserDao userDao=new UserDaoImpl();
        UserEntity entity= userDao.findUserByUsernameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    @Override
    public UserDTO findRoleByUser(UserDTO dto) {
        UserDao userDao=new UserDaoImpl();
        UserEntity entity= userDao.findUserByUsernameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }
}
