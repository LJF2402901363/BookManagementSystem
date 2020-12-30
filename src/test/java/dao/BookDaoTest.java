package dao;

import bean.Book;
import bean.ReaderInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Classname:ReaderDaoTest
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2020-12-28 10:09
 * @Version: 1.0
 **/

public class BookDaoTest {

    private ApplicationContext applicationContext;
    private BookDao readerInfoDao =null;
    @BeforeEach
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContexConfig.xml");
        readerInfoDao = applicationContext.getBean(BookDao.class);
    }
    @Test
    public void testGet(){
        Book book = readerInfoDao.getBook(1);
        System.out.println(book);

    }
    @Test
    public void testInsert(){
       Book book = new Book();
       book.setAuthor("张三");
       book.setClassId(9);
       book.setPublish("北京十月文艺出版社");
       book.setPubdate(new Date());
       book.setIsbn("jsdjjgd");
       book.setPrice(new BigDecimal(58));
       book.setBookId(10);
       book.setLanguage("中文");
       book.setName("围城");
        int addBook = readerInfoDao.addBook(book);
        System.out.println(addBook);

    }
    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setBookId(15);
        book.setAuthor("李四");
        book.setClassId(9);
        book.setPublish("北京十月文艺出版社");
        book.setPubdate(new Date());
        book.setIsbn("jsdjjgd");
        book.setPrice(new BigDecimal(58));
        book.setBookId(10);
        book.setLanguage("中文");
        book.setName("围城");
        int addBook = readerInfoDao.editBook(book);
        System.out.println(addBook);

    }
    @Test
    public  void testDelete(){
        int deleteBook = readerInfoDao.deleteBook(15);
        System.out.println(deleteBook);
    }
    @Test
    public  void testgetBook(){
        Book deleteBook = readerInfoDao.getBook(14);
        System.out.println(deleteBook);
    }

}
