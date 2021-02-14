package service;

import  bean.Lend;
import dao.BookDao;
import  dao.LendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface LendService {
    public boolean lendBook(long bookId,long readerId);
    public List<Lend> queryLendBook(final String searchWord);
    public ArrayList<Lend> myLendList(long readerId);
    public boolean deleteLend(long serNum) ;
    public boolean updateLend(Lend lend) ;
    /**
     * @Description :通过bookId和readerID还书
     * @Date 20:53 2020/12/29 0029
     * @Param * @param bookId  借阅书籍的唯一ID
     * @param readerId ：借阅者的唯一ID
     * @return boolean ：返回是否还书成功
     **/
    public boolean backBook(long bookId, long readerId);
    public boolean addLend(Lend lend) ;
}
