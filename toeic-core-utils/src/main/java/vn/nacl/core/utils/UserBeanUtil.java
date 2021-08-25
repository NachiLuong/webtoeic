package vn.nacl.core.utils;

import vn.nacl.core.dto.UserDTO;
import vn.nacl.core.peristence.entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO entity2Dto(UserEntity entity){
        UserDTO dto=new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setPassword(entity.getPassword());
        dto.setCreatedate(entity.getCreatedate());
        dto.setName(entity.getName());
        dto.setFullname(entity.getFullname());
        dto.setRoleDTO(RoleBeanUtil.entity2Dto(entity.getRole()));
        return dto;
    }
    public static UserEntity dto2Entity(UserDTO dto){
        UserEntity entity=new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setPassword(dto.getPassword());
        entity.setCreatedate(dto.getCreatedate());
        entity.setName(dto.getName());
        entity.setFullname(dto.getFullname());
        entity.setRole(RoleBeanUtil.dto2Entity(dto.getRoleDTO()));
        return entity;
    }
}
