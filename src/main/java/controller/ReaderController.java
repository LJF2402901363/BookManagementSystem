package controller;

import bean.Book;
import bean.ReaderCard;
import bean.ReaderInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;
import service.LoginService;
import service.ReaderCardService;
import service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ReaderController {
    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ReaderCardService readerCardService;

    private ReaderInfo getReaderInfo(long readerId, String name, String sex, String birth, String address, String phone) {
        ReaderInfo readerInfo = new ReaderInfo();
        Date date = new Date();
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        readerInfo.setAddress(address);
        readerInfo.setName(name);
        readerInfo.setReaderId(readerId);
        readerInfo.setPhone(phone);
        readerInfo.setSex(sex);
        readerInfo.setBirth(date);
        return readerInfo;
    }

    @RequestMapping("/toAdmin_readers")
    public String allBooks() {

        return "admin_readers";
    }

    @RequestMapping("/deleteReader")
    @ResponseBody
    public Map<String,String> readerDelete(@RequestParam("readerId") Long readerId) {
        boolean fla = this.readerInfoService.deleteReaderInfo(readerId);
        Map<String,String> map = new HashMap<>();
        if (fla  ){
            map.put("msg","删除成功");
            map.put("status","1");
        }else {
            map.put("msg","删除失败");
            map.put("status","0");
        }
        return map;

    }

    @RequestMapping("/reader/findAll.do")
    @ResponseBody
    public String findAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<Reader> list = readerInfoService.queryReader(searchContent);
            PageInfo<Reader> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }
    }

    @RequestMapping("/updateReader")
    @ResponseBody
    public Map<String,String>  readerInfoEdit(@RequestBody ReaderInfo readerInfo) {
        boolean fla = this.readerInfoService.editReaderInfo(readerInfo);
        Map<String,String> map = new HashMap<>();
        if (fla  ){
            map.put("msg","更新成功");
            map.put("status","1");
        }else {
            map.put("msg","更新失败");
            map.put("status","0");
        }
        return map;
    }

    @RequestMapping("/addReader.html")
    @ResponseBody
    public  Map<String,String> addReader(@RequestBody ReaderInfo readerInfo) {
        long fla = this.readerInfoService.addReaderInfo(readerInfo);
        Map<String,String> map = new HashMap<>();
        if (fla   > 0){
            map.put("msg","添加成功");
            map.put("status","1");
        }else {
            map.put("msg","添加失败");
            map.put("status","0");
        }
        return map;
    }
}
