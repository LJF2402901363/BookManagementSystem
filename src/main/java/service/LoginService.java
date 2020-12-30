package service;

import  bean.ReaderCard;
import  dao.AdminDao;
import  dao.ReaderCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    private ReaderCardDao readerCardDao;
    @Autowired
    private AdminDao adminDao;

    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public boolean hasMatchReader(long readerId,String password){
        return  readerCardDao.getIdMatchCount(readerId, password)>0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public String getAdminUsername(long adminId) {
        return adminDao.getUsername(adminId);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public ReaderCard findReaderCardByReaderId(long readerId){
        return readerCardDao.findReaderByReaderId(readerId);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public boolean hasMatchAdmin(long adminId,String password){
        return adminDao.getMatchCount(adminId, password) == 1;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean adminRePassword(long adminId, String newPassword){
        return adminDao.resetPassword(adminId,newPassword)>0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public String getAdminPassword(long adminId){
        return adminDao.getPassword(adminId);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public boolean readerRePassword(long readerId, String newPassword) {
        return readerCardDao.resetPassword(readerId, newPassword) > 0;
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public String getReaderPassword(long readerId) {
        return readerCardDao.getPassword(readerId);
    }


}
