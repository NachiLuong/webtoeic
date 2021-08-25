package vn.nacl.core.utils;

import vn.nacl.core.dto.ListenGuideLineDTO;
import vn.nacl.core.peristence.entity.ListenGuideLineEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuideLineDTO entity2Dto(ListenGuideLineEntity entity){
        ListenGuideLineDTO dto=new ListenGuideLineDTO();
        dto.setCreateDate(entity.getCreateDate());
        dto.setContent(entity.getContent());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setListenguidelineId(entity.getListenguidelineId());
        dto.setModifieDate(entity.getModifieDate());
        return dto;
    }
    public static ListenGuideLineEntity dto2Entity(ListenGuideLineDTO dto){
        ListenGuideLineEntity entity=new ListenGuideLineEntity();
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
        entity.setCreateDate(dto.getCreateDate());
        entity.setImage(dto.getImage());
        entity.setListenguidelineId(dto.getListenguidelineId());
        entity.setModifieDate(dto.getModifieDate());
        return entity;
    }
}
