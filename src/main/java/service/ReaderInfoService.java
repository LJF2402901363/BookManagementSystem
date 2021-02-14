package service;

import  bean.ReaderInfo;
import dao.ReaderInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public interface ReaderInfoService {
    public boolean deleteReaderInfo(long readerId);
    public ReaderInfo getReaderInfo(long readerId);
    public boolean editReaderInfo(ReaderInfo readerInfo);
    public boolean editReaderCard(ReaderInfo readerInfo);
    public long addReaderInfo(ReaderInfo readerInfo);
    public List<Reader> queryReader(String searchContent);
}
