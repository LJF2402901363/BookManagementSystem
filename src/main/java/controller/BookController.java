package controller;

import bean.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BookService;
import service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
//@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LendService lendService;

    private Date getDate(String pubstr) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(pubstr);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }


    @RequestMapping("/book/findAll.do")
    @ResponseBody
    public String findAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<Book> list = bookService.queryBook(searchContent);
            PageInfo<Book> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }

    }




    @RequestMapping("/addbook.html")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        boolean fla = this.bookService.addBook(book);
        Map<String,String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (fla){
            map.put("msg","添加成功");
            map.put("status","1");
        }else {
            map.put("msg","添加失败");
            map.put("status","0");
        }
        String msg = "";
        try {
            msg = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return msg;
    }


    @RequestMapping("/updatebook.html")
    @ResponseBody
    public String  bookEdit( @RequestBody Book book) {
        boolean editBook = this.bookService.editBook(book);
        Map<String,String>  map = new HashMap<>();
        if (editBook){
            map.put("msg","更新成功!");
            map.put("status","1");

        }else {
            map.put("msg","更新失败!");
            map.put("status","0");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = "";
        try {
            msg = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping("/deletebook.html")
    @ResponseBody
    public  String bookEditDo(@RequestParam(value = "bookId") Long bookId) {
        boolean fla = this.bookService.deleteBook(bookId);
        Map<String,String>  map = new HashMap<>();
        if (fla){
            map.put("msg","删除成功!");
            map.put("status","1");

        }else {
            map.put("msg","删除失败!");
            map.put("status","0");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = "";
        try {
            msg = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return msg;
    }


    @RequestMapping("toAdmin_books")
    public ModelAndView admin_header() {
        return new ModelAndView("admin_books");
    }


}
