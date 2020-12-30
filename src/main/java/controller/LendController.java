package controller;

import bean.Book;
import bean.Lend;
import bean.ReaderCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import service.BookService;
import service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LendController {
    @Autowired
    private LendService lendService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/deleteLendBok")
    @ResponseBody
    public Map<String,String> deleteLend(@RequestParam("serNum") Long serNum) {
        boolean fla = this.lendService.deleteLend(serNum);
        Map<String,String> map = new HashMap<>();
        if (fla){
            map.put("msg","删除成功");
            map.put("status","1");
        }else {
            map.put("msg","删除失败");
            map.put("status","0");
        }

        return map;
    }
    @RequestMapping("/toAdmin_Lends")
    public String toAdmin_Lends(){
        return "admin_lends";
    }

    @RequestMapping("/lend/findBackAll.do")
    @ResponseBody
    public String findBackAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent,@RequestParam("readerId")Long readerId) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<Lend> list = bookService.queryBackBookByReaderId(searchContent,readerId);
            PageInfo<Lend> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }

    }
    @RequestMapping("/lend/findLendAll.do")
    @ResponseBody
    public String findLendAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent,@RequestParam("readerId")Long readerId) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<Lend> list = bookService.queryLendBookByReaderId(searchContent,readerId);
            PageInfo<Lend> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }

    }

    @RequestMapping("/lend/findLendAndBackAll.do")
    @ResponseBody
    public String findLendAndBackAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent,@RequestParam("readerId")Long readerId) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<Lend> list = bookService.queryLendAndBackBookByReaderId(searchContent,readerId);
            PageInfo<Lend> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }

    }
    @RequestMapping("/lend/findAll.do")
    @ResponseBody
    public String findAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<Lend> list = lendService.queryLendBook(searchContent);
            PageInfo<Lend> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }

    }
    @ResponseBody
    @RequestMapping("/updateLendBook")
  public   Map<String,String> updateLend(@RequestBody Lend lend){
       boolean fla =  this.lendService.updateLend(lend);
        Map<String,String> map = new HashMap<>();
        if (fla){
            map.put("msg","更新成功");
            map.put("status","1");
        }else {
            map.put("msg","更新失败");
            map.put("status","0");
        }

        return map;
  }
    @RequestMapping("/toReaderLendBookManagement")
    public String toReaderLendBookManagement() {
        return "reader_books";
    }
  @RequestMapping("/toReaderLenBook")
  public String toReaderLenBook() {
      return "reader_lendbooks";
  }
    @RequestMapping("/toReaderBackBook")
    public String toReaderBackBook() {
        return "reader_backbooks";
    }
    @RequestMapping("/toReaderLenAndBackBook")
    public String toReaderLenAndBackBook() {
        return "reader_lendAndBackbooks";
    }

    @RequestMapping("/lendbook.html")
    @ResponseBody
    public Map<String,String>  lendbook(@RequestParam("readerId")Long readerId,@RequestParam("bookId")Long bookId) {
        Map<String,String> map = new HashMap<>();
        String msg ="";
        if (lendService.lendBook(bookId, readerId)) {
            Lend lend = new Lend();
            lend.setBookId(bookId);
            lend.setReaderId(readerId);
            lend.setLendDate(new Date());
          boolean fla =    lendService.addLend(lend);

            if (fla){
                map.put("msg","结束成功");
                map.put("status","1");
            }else {
                map.put("msg","借书成功");
                map.put("status","1");
            }

        }else {
            map.put("msg","借书失败");
            map.put("status","0");
        }

        return map;
    }

    @RequestMapping("/backBook")
    @ResponseBody
    public Map<String,String> bookReturn(@Param("bookId")Long bookId,@Param("readerId") Long readerId) {
        boolean fla = this.lendService.backBook(bookId, readerId);
        Map<String,String> map = new HashMap<>();
        if (fla){
            map.put("msg","还书成功");
            map.put("status","1");
        }else {
            map.put("msg","还书失败");
            map.put("status","0");
        }

        return map;
    }
}
