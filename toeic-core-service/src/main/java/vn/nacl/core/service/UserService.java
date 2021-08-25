package vn.nacl.core.service;

import vn.nacl.core.dto.UserDTO;

public interface UserService {
    UserDTO isUserExist(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);
}
