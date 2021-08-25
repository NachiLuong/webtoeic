package vn.nacl.core.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vn.nacl.core.dao.ListenGuideLineDao;
import vn.nacl.core.daoimpl.ListenGuidelineDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class ListenGuidelineTest {
    ListenGuideLineDao listenGuideLineDao;
    @BeforeTest
    public void initData(){
        listenGuideLineDao=new ListenGuidelineDaoImpl();
    }
    @Test
    public void testFindByPropertis(){
        //ListenGuideLineDao listenGuideLineDao=new ListenGuidelineDaoImpl();
       // Object result= listenGuideLineDao.findByProperty(null,null,null,null, 2 ,2);
    }
    @Test
    public void checkApiFindByProperty(){
        Map<String,Object> property= new HashMap<String,Object>();
        property.put("title", "Bai 3");
        property.put("content", "Noi dung bai 3");
        Object[] objects=listenGuideLineDao.findByProperty(property,null,null,null,null);
    }
}
