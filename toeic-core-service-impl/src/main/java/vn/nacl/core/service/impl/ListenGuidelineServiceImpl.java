package vn.nacl.core.service.impl;

import vn.nacl.core.dao.ListenGuideLineDao;
import vn.nacl.core.daoimpl.ListenGuidelineDaoImpl;
import vn.nacl.core.service.ListenGuidelineService;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuideLineDao listenGuideLineDTO= new ListenGuidelineDaoImpl();
//    @Override
//    public Object[] findListenGuidelineByProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
//        List<ListenGuideLineDTO> result=new ArrayList<ListenGuideLineDTO>();
//        Object[] objects=listenGuideLineDTO.findByProperty(property, value,sortExpression,sortDirection,offset,limit);
//        for (ListenGuideLineEntity item: (List<ListenGuideLineEntity>)objects[1]){
//            ListenGuideLineDTO dto= ListenGuidelineBeanUtil.entity2Dto(item);
//            result.add(dto);
//        }
//        objects[1]=result;
//        return objects;
//    }
}
