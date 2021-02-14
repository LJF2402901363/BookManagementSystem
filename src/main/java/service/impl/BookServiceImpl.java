package service.impl;

import bean.Book;
import bean.Lend;
import dao.BookDao;
import dao.LendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl  implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private LendDao lendDao;
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public ArrayList<Book> queryBook(String searchWord) {
        return bookDao.queryBook(searchWord);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public boolean matchBook(String searchWord) {
        return bookDao.matchBook(searchWord) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean addBook(Book book) {
        return bookDao.addBook(book) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public Book getBook(Long bookId) {
        return bookDao.getBook(bookId);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean editBook(Book book) {
        return bookDao.editBook(book) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean deleteBook(Long bookId) {
        return bookDao.deleteBook(bookId) > 0;
    }

    public List<Lend> queryLendBook(String searchContent) {
        return this.lendDao.queryLendBook(searchContent);
    }

    public List<Lend> queryLendBookByReaderId(String searchContent, Long readerId) {
       return this.lendDao.queryLendBookByReaderId(searchContent,readerId);
    }

    public List<Lend> queryBackBookByReaderId(String searchContent, Long readerId) {
        return this.lendDao.queryBackBookByReaderId(searchContent,readerId);
    }

    public List<Lend> queryLendAndBackBookByReaderId(String searchContent, Long readerId) {
        return this.lendDao.queryLendAndBackBookByReaderId(searchContent,readerId);
    }
}
