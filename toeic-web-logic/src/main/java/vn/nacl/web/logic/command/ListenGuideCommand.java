package vn.nacl.web.logic.command;

import vn.nacl.core.dto.ListenGuideLineDTO;
import vn.nacl.core.web.command.AsbtractCommand;

public class ListenGuideCommand extends AsbtractCommand<ListenGuideLineDTO> {
    public ListenGuideCommand(){
        this.pojo=new ListenGuideLineDTO();
    }

}
