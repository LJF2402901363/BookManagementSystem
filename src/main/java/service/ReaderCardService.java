package service;

import bean.ReaderCard;
import  bean.ReaderInfo;
import  dao.ReaderCardDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReaderCardService  {
    public boolean addReaderCard(ReaderInfo readerInfo, String password);
    public boolean updatePassword(long readerId, String password);
    public boolean deleteReaderCard(long readerId);

    public List<ReaderCard> queryReaderCard(@Param("searchContent") String searchContent) ;

    public boolean updateReadCard(ReaderCard readerCard);

    public boolean deleteReaderInfo(Long readerId);
}
