package service.impl;

import bean.Lend;
import dao.BookDao;
import dao.LendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.LendService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LendServiceImpl implements LendService {
    @Autowired
    private LendDao lendDao;
    @Autowired
    private BookDao bookDao;
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean lendBook(long bookId,long readerId){
        return lendDao.lendBookOne(bookId,readerId)>0 && lendDao.lendBookTwo(bookId)>0;
    }
    public List<Lend> queryLendBook(final String searchWord) {
        return lendDao.queryLendBook(searchWord);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = true)
    public ArrayList<Lend> myLendList(long readerId){
        return lendDao.myLendList(readerId);
    }
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean deleteLend(long serNum) {
        return lendDao.deleteLend(serNum) == 1;
    }

    public boolean updateLend(Lend lend) {
         return  this.lendDao.updateLend(lend) == 1;
    }
    /**
     * @Description :通过bookId和readerID还书
     * @Date 20:53 2020/12/29 0029
     * @Param * @param bookId  借阅书籍的唯一ID
     * @param readerId ：借阅者的唯一ID
     * @return boolean ：返回是否还书成功
     **/
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false)
    public boolean backBook(long bookId, long readerId){

        //首先更新lend_list表中的还书日期，如果更新了一条数据则还书成功，否则还书失败
        int result = this.lendDao.backBook(bookId,readerId);
        if (result == 1){
            //还书成功
            int fla = bookDao.returnBookAddNum(bookId);
            if (fla == 1){
                //更新书籍数量+1成功
                return  true;
            }
        }
        return false;
    }
    public boolean addLend(Lend lend) {
         return  this.lendDao.addLend(lend);
    }
}
