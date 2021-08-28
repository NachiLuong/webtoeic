package vn.nacl.core.service.impl;

import vn.nacl.core.dao.UserDao;
import vn.nacl.core.daoimpl.UserDaoImpl;
import vn.nacl.core.dto.UserDTO;
import vn.nacl.core.peristence.entity.UserEntity;
import vn.nacl.core.service.UserService;
import vn.nacl.core.utils.UserBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        UserDao userDao=new UserDaoImpl();
        Object[] objects=userDao.findByProperty(property,sortExpression,sortDirection,offset,limit);
        List<UserDTO> userDTOs= new ArrayList<UserDTO>();
        for (UserEntity item: (List<UserEntity>)objects[1]){
            UserDTO userDTO=UserBeanUtil.entity2Dto(item);
            userDTOs.add(userDTO);
        }
        objects[1]=userDTOs;
        return objects;
    }
}
