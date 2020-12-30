package controller;

import bean.ReaderCard;
import bean.ReaderInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LoginService;
import service.ReaderCardService;
import service.ReaderInfoService;

import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReaderCardController {
    @Autowired
    private ReaderCardService readerInfoService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ReaderCardService readerCardService;


    @RequestMapping("/deleteReaderCard")
    @ResponseBody
    public String readerDelete(@RequestParam("readerId") Long readerId) {
        boolean fla = this.readerInfoService.deleteReaderInfo(readerId);
        Map<String,String> map = new HashMap<>();
        if (fla){
            map.put("msg","删除成功");
            map.put("status","1");
        }else {
            map.put("msg","删除失败");
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

    @RequestMapping("/readCard/findAll.do")
    @ResponseBody
    public String findAll(@RequestParam("start") int start, @RequestParam("length") int pageSize, @RequestParam("search[value]") String searchContent) throws Exception {
        //计算当前页面
        int pageNum = start / pageSize + 1;
        String jsonData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        PageHelper.startPage(pageNum, pageSize, true);
        try {
            List<ReaderCard> list = readerInfoService.queryReaderCard(searchContent);
            PageInfo<ReaderCard> pageInfo = new PageInfo<>(list);
            jsonData = objectMapper.writeValueAsString(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonData = objectMapper.writeValueAsString(new PageInfo<>());
        } finally {
            return jsonData;
        }
    }

    @RequestMapping("/updateReaderCard")
    @ResponseBody
    public String readerInfoEdit(@RequestBody ReaderCard readerInfo) {
        boolean fla = this.readerInfoService.updateReadCard(readerInfo);
        Map<String,String> map = new HashMap<>();
        if (fla){
            map.put("msg","更新成功");
            map.put("status","1");
        }else {
            map.put("msg","更新失败");
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
    @RequestMapping("/toAdmin_readerCards")
  public String toAdmin_readerCards(){
        return "admin_readerCards";
  }
}
