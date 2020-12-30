package dao;

import bean.Admin;
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

public class AdminDaoTest {

    private ApplicationContext applicationContext;
    private AdminDao readerInfoDao =null;
    @BeforeEach
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContexConfig.xml");
        readerInfoDao = applicationContext.getBean(AdminDao.class);
    }
    @Test
    public void testGet(){
        int matchCount = readerInfoDao.getMatchCount(123456, "123456");
        System.out.println(matchCount);

    }
    @Test
    public void testMatchCount(){
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setUsername("root");
        admin.setPassword("root");
        int matchCount = readerInfoDao.getMatchCount(123456,"123456");
        System.out.println(matchCount);

    }
    @Test
    public void testgetPassword(){
        String password = readerInfoDao.getPassword(123456);
        System.out.println(password);

    }
    @Test
    public  void testgetUsername(){
        String username = readerInfoDao.getUsername(123456);
        System.out.println(username);
    }

}
