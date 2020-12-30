package dao;

import bean.Lend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Mapper
public interface LendDao {



    public int lendBookOne(@Param("bookId")final long bookId,@Param("readerId") final long readerId);

    public int lendBookTwo(@Param("bookId")final long bookId);
    public List<Lend> queryLendBook(@Param("searchWord") final String searchWord);
    public Lend queryLendBookById(@Param("serNum") final Long serNum);
    public ArrayList<Lend> myLendList(@Param("readerId")final long readerId) ;

    public int deleteLend(@Param("serNum")final long serNum);

    int updateLend(@Param("lend")Lend lend);

    boolean addLend(@Param("lend") Lend lend);

    List<Lend> queryLendBookByReaderId(@Param("searchWord")String searchWord, @Param("readerId")Long readerId);

    List<Lend> queryBackBookByReaderId(@Param("searchWord")String searchWord, @Param("readerId")Long readerId);

    List<Lend> queryLendAndBackBookByReaderId(@Param("searchWord")String searchWord, @Param("readerId")Long readerId);
    /**
     * @Description :通过bookId和readerID还书
     * @Date 20:53 2020/12/29 0029
     * @Param * @param bookId  借阅书籍的唯一ID
     * @param readerId ：借阅者的唯一ID
     * @return boolean ：返回是否还书成功
     **/
    int backBook(@Param("bookId")long bookId, @Param("readerId")long readerId);
}
