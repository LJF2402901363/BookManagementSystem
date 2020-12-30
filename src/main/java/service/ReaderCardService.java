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

@Service
@Transactional
public class ReaderCardService {
    @Autowired
    private ReaderCardDao readerCardDao;
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean addReaderCard(ReaderInfo readerInfo, String password){
        ReaderCard readerCard = new ReaderCard();
        readerCard.setReaderId(readerInfo.getReaderId());
        readerCard.setUsername(readerInfo.getName());
        return  readerCardDao.addReaderCard(readerCard)>0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean updatePassword(long readerId, String password){
        return readerCardDao.resetPassword(readerId,password)>0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean deleteReaderCard(long readerId) {
        return readerCardDao.deleteReaderCard(readerId) > 0;
    }

    public List<ReaderCard> queryReaderCard(@Param("searchContent") String searchContent) {
        return this.readerCardDao.queryReaderCard(searchContent);
    }

    public boolean updateReadCard(ReaderCard readerCard) {
        return  this.readerCardDao.updateReadCard(readerCard) == 1;
    }

    public boolean deleteReaderInfo(Long readerId) {
        return  this.readerCardDao.deleteReaderCard(readerId) == 1;
    }
}
