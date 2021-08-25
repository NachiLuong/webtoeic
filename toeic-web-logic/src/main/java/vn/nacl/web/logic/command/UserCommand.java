package vn.nacl.web.logic.command;

import vn.nacl.core.dto.UserDTO;
import vn.nacl.core.web.command.AsbtractCommand;

public class UserCommand extends AsbtractCommand<UserDTO> {

    public UserCommand(){
        this.pojo = new  UserDTO();
    }

}
