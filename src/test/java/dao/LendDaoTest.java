package dao;

import bean.Admin;
import bean.Lend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Classname:ReaderDaoTest
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2020-12-28 10:09
 * @Version: 1.0
 **/

public class LendDaoTest {

    private ApplicationContext applicationContext;
    private LendDao readerInfoDao =null;
    @BeforeEach
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContexConfig.xml");
        readerInfoDao = applicationContext.getBean(LendDao.class);
    }
    @Test
    public void testGet(){
        Lend lend = readerInfoDao.queryLendBookById(1L);
        List<Lend> lends = readerInfoDao.queryLendBook("");
        lends.forEach(System.out::println);
        System.out.println(lend);
    }
    @Test
    public void testMatchCount(){

    }
    @Test
    public void testgetLendBook(){
    int flag = readerInfoDao.backBook(1L,10000L);
    }
    @Test
    public  void testgetUsername(){
        List<Lend> lends = readerInfoDao.queryLendBookByReaderId("", 10000L);
        lends.forEach(System.out::println);
    }

}
