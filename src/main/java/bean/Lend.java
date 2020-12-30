package bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Lend implements Serializable {
    public Lend() {
    }

    private long ser_num;
    private long book_id;
    private long reader_id;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date lend_date;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date back_date;
    private ReaderInfo readerInfo;
   private Book book;

    public long getSerNum() {
        return ser_num;
    }

    public void setSerNum(long ser_num) {
        this.ser_num = ser_num;
    }

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long book_id) {
        this.book_id = book_id;
    }

    public long getReaderId() {
        return reader_id;
    }

    public void setReaderId(long reader_id) {
        this.reader_id = reader_id;
    }

    public Date getLendDate() {
        return lend_date;
    }

    public void setLendDate(Date lend_date) {
        this.lend_date = lend_date;
    }

    public Date getBackDate() {
        return back_date;
    }

    public void setBackDate(Date back_date) {
        this.back_date = back_date;
    }

    public ReaderInfo getReaderInfo() {
        return readerInfo;
    }

    public void setReaderInfo(ReaderInfo readerInfo) {
        this.readerInfo = readerInfo;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "ser_num=" + ser_num +
                ", book_id=" + book_id +
                ", reader_id=" + reader_id +
                ", lend_date=" + lend_date +
                ", back_date=" + back_date +
                ", readerInfo=" + readerInfo +
                ", book=" + book +
                '}';
    }
}
