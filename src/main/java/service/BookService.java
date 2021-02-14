package service;

import bean.Book;
import bean.Lend;
import dao.BookDao;
import dao.LendDao;
import dao.ReaderCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    public ArrayList<Book> queryBook(String searchWord);
    public boolean matchBook(String searchWord);
    public boolean addBook(Book book);
    public Book getBook(Long bookId);
    public boolean editBook(Book book);
    public boolean deleteBook(Long bookId);

    public List<Lend> queryLendBook(String searchContent);

    public List<Lend> queryLendBookByReaderId(String searchContent, Long readerId);

    public List<Lend> queryBackBookByReaderId(String searchContent, Long readerId) ;

    public List<Lend> queryLendAndBackBookByReaderId(String searchContent, Long readerId);
}
