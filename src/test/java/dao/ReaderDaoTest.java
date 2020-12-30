package dao;

import bean.ReaderInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Classname:ReaderDaoTest
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2020-12-28 10:09
 * @Version: 1.0
 **/

public class ReaderDaoTest {

    private ApplicationContext applicationContext;
    private ReaderInfoDao readerInfoDao =null;
    private ReaderCardDao readerCardDao;
    @BeforeEach
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContexConfig.xml");
        readerInfoDao = applicationContext.getBean(ReaderInfoDao.class);
        readerCardDao = applicationContext.getBean(ReaderCardDao.class);
    }
    @Test
    public void testGet(){
        ReaderInfo readerInfoByReaderId = readerInfoDao.findReaderInfoByReaderId(10000);

        int result =readerCardDao.getIdMatchCount(10000,"123456");
        System.out.println(readerInfoByReaderId);
        System.out.println(result);

    }
    @Test
    public void testInsert(){
        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderId(1);
        readerInfo.setName("陌意随影");
        readerInfo.setAddress("广西");
        readerInfo.setBirth(new Date());
        readerInfo.setSex("男");
        readerInfo.setPhone("123452455");
        long result = readerInfoDao.addReaderInfo(readerInfo);
        System.out.println(result);

    }
    @Test
    public void testUpdate(){
        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderId(1006);
        readerInfo.setName("陌意随影");
        readerInfo.setAddress("山东");
        readerInfo.setBirth(new Date());
        readerInfo.setSex("男");
        readerInfo.setPhone("123452455");
        long result = readerInfoDao.addReaderInfo(readerInfo);
        System.out.println(result);

    }
    @Test
    public  void testDelete(){
        int readerInfo = readerInfoDao.deleteReaderInfo(10006);
        System.out.println(readerInfo);
    }
    @Test
    public void test(){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = new HashMap<>();
        map.put("msg","a");
        map.put("status","1");
        try {
            String s = objectMapper.writeValueAsString(map);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
