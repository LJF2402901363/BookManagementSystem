package dao;
import bean.ReaderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ReaderInfoDao {



    public ReaderInfo findReaderInfoByReaderId(@Param("reader_id")final long reader_id) ;

    public int deleteReaderInfo(@Param("reader_id")final long reader_id) ;

    public int editReaderInfo(@Param("readerInfo") final ReaderInfo readerInfo);

    public int editReaderCard(@Param("readerInfo")final ReaderInfo readerInfo) ;

    public  long addReaderInfo(@Param("readerInfo")final ReaderInfo readerInfo) ;

    List<Reader> queryReader(String searchContent);
}
