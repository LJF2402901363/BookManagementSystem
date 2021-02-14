package service;

import  bean.ReaderCard;
import  dao.AdminDao;
import  dao.ReaderCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface LoginService {
    public boolean hasMatchReader(long readerId,String password);
    public String getAdminUsername(long adminId);
    public ReaderCard findReaderCardByReaderId(long readerId);
    public boolean hasMatchAdmin(long adminId,String password);
    public boolean adminRePassword(long adminId, String newPassword);
    public String getAdminPassword(long adminId);
    public boolean readerRePassword(long readerId, String newPassword);
    public String getReaderPassword(long readerId);


}
