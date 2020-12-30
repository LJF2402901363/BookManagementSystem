package dao;

import bean.ReaderCard;
import bean.ReaderInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Classname:ReaderDaoTest
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2020-12-28 10:09
 * @Version: 1.0
 **/

public class ReaderCardDaoTest {

    private ApplicationContext applicationContext;
    private ReaderCardDao readerInfoDao =null;
    @BeforeEach
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContexConfig.xml");
        readerInfoDao = applicationContext.getBean(ReaderCardDao.class);
    }
    @Test
    public void testGet(){
        ReaderCard readerByReaderId = readerInfoDao.findReaderByReaderId(10000);
        System.out.println(readerByReaderId);

    }
    @Test
    public void testgetIdMatchCount(){
        int idMatchCount = readerInfoDao.getIdMatchCount(10000, "123456");
        System.out.println(idMatchCount);

    }
    @Test
    public void testUpdate(){
        int resetPassword = readerInfoDao.resetPassword(10000, "12345");
        System.out.println(resetPassword);

    }

    @Test
    public  void testDelete(){
        int i = readerInfoDao.deleteReaderCard(10000);
        System.out.println(i);
    }

    @Test
    public  void testAdd(){
        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderId(1);
        readerInfo.setName("陌意随影");
        readerInfo.setAddress("广西");
        readerInfo.setBirth(new Date());
        readerInfo.setSex("男");
        readerInfo.setPhone("123452455");
        ReaderCard readerCard = new ReaderCard();
        readerCard.setReaderId(readerInfo.getReaderId());
        readerCard.setUsername(readerInfo.getName());
        readerCard.setPassword("12345");
        int i = readerInfoDao.addReaderCard(readerCard);
        System.out.println(i);
    }
}
