package dao;

import bean.Lend;
import bean.ReaderCard;
import bean.ReaderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReaderCardDao {

    public int getIdMatchCount(@Param("reader_id") final long reader_id,@Param("password") final String password) ;

    public ReaderCard findReaderByReaderId(final long reader_id) ;
    public int resetPassword(@Param("reader_id") final long reader_id, @Param("password")final String newPassword) ;

    public int addReaderCard(@Param("readerCard")final ReaderCard readerCard) ;

    public String getPassword(@Param("reader_id")final long reader_id) ;

    public int deleteReaderCard(@Param("reader_id")final long reader_id) ;

    List<ReaderCard> queryReaderCard(@Param("searchContent")String searchContent);
    int updateReadCard(@Param("readerCard")ReaderCard readerCard);
}
