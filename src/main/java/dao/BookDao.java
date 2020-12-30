package dao;

import bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BookDao {


    public int matchBook(@Param("searchWord") final String searchWord);

    public ArrayList<Book> queryBook(@Param("searchWord")final String searchWord);

    public int addBook(@Param("book")final Book book);

    public Book getBook(@Param("bookId")final long bookId);

    public int editBook(@Param("book")final Book book);

    public int deleteBook(@Param("bookId")final long bookId);

    List<Book> queryLendBook(@Param("searchContent")String searchContent);
    /**
     * @Description :还书，该书的数量加1
     * @Date 21:12 2020/12/29 0029
     * @Param * @param bookId ：
     * @return int
     **/
    public int returnBookAddNum(@Param("bookId")final long bookId);
}
