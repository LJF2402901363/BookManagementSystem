package service.impl;

import bean.ReaderInfo;
import dao.ReaderInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.ReaderInfoService;

import java.io.Reader;
import java.util.List;

@Service
@Transactional
public class ReaderInfoServiceImpl  implements ReaderInfoService {
    @Autowired
    private ReaderInfoDao readerInfoDao;
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean deleteReaderInfo(long readerId) {
        return readerInfoDao.deleteReaderInfo(readerId) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public ReaderInfo getReaderInfo(long readerId) {
        return readerInfoDao.findReaderInfoByReaderId(readerId);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean editReaderInfo(ReaderInfo readerInfo) {
        return readerInfoDao.editReaderInfo(readerInfo) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean editReaderCard(ReaderInfo readerInfo) {
        return readerInfoDao.editReaderCard(readerInfo) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public long addReaderInfo(ReaderInfo readerInfo) {
        return readerInfoDao.addReaderInfo(readerInfo);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public List<Reader> queryReader(String searchContent) {
        return this.readerInfoDao.queryReader(searchContent);
    }
}
