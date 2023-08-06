package org.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.example.empty.Book;
import org.example.empty.Borrow;
import org.example.empty.Student;
import org.example.service.BookService;
import org.example.service.BorrowService;
import org.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
public class MainController {
    @RequestMapping(value = {"/"},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String index(){
        return "欢迎来到我的图书管理系统！";
    }

    @Resource
    private StudentService studentService;

    /**
     * @RequestMapping 接收传入路径的参数是一个数组，可以同时接入多个路径，在路径中使用{}来实现传参数
     * restful风格的url传值只能保持一一对应的关系，缺少某一字段就无法正常访问。
     * @PathVariable 注解用于从url中获取参数，使用时最好指定相应的value值，
     * required参数用于表示当前参数是否必须入参，默认为真
     */
    @RequestMapping(value = {"/student/info/{sid}"},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String info(@PathVariable(value = "sid") Integer sid){
        System.out.println(sid);
        Student student = studentService.getStudentInfo(sid);
        return student.toString();
    }

    @RequestMapping(value = {"/student/info"},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String studentAllInfo(){
        List<Student> studentList = studentService.getStudentAllInfo();
        System.out.println(studentList);
        System.out.println(JSON.toJSONString(studentList));
        return JSON.toJSONString(studentList);
    }
    @Resource
    private BookService bookService;    // 引入bookService对象
    @RequestMapping(value = "/book/info/{bid}",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String BookInfo(@PathVariable(value = "bid") Integer bid){
       Book bookInfo = bookService.getBookInfo(bid);
       return bookInfo.toString();
    }

    @RequestMapping(value = "/book/info",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String AllBookInfo(){
       List<Book> bookList = bookService.getBookAllInfo();
        return JSON.toJSONString(bookList);
    }
    @RequestMapping(value = "/book/info",produces = "application/json;charset=UTF-8",method = RequestMethod.PUT)
    @ResponseBody
    public String updateBookInfo(@RequestBody String bookInfo){
        System.out.println(bookInfo);
        Book book = JSON.parseObject(bookInfo, Book.class);
        System.out.println(book.toString());
        return String.valueOf(bookService.updateBookInfo(book.getTitle(),book.getDesc(),book.getPrice(),book.getBid()));
    }

    @RequestMapping(value = "/book/info/{bid}",produces = "application/json;charset=UTF-8",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBookInfo(@PathVariable(value = "bid")Integer bid){
        System.out.println(bid);
        return String.valueOf(bookService.deleteBookInfo(bid));
    }

    @RequestMapping(value = "/book/info",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String insertBookInfo(@RequestBody String bookInfo){
        System.out.println(bookInfo);
        Book book = JSON.parseObject(bookInfo, Book.class);
        System.out.println(book.toString());
        return String.valueOf(bookService.insertBookInfo(book.getTitle(),book.getDesc(),book.getPrice()));
    }


    @Resource
    private BorrowService borrowService;    // 引入borrowService对象
    @RequestMapping(value = "/borrow/info/{id}",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String BorrowInfo(@PathVariable(value = "id") Integer id){
        Borrow borrow = borrowService.getBorrowInfo(id);
        return borrow.toString();
    }

    @RequestMapping(value = "/borrow/info",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String AllBorrowInfo(){
        List<Borrow> borrowList = borrowService.getBorrowAllInfo();
        return JSON.toJSONStringWithDateFormat(borrowList,"yyyy-MM-dd", SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/borrow/info",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String insertBorrowInfo(@RequestBody String borrowInfo){
        System.out.println(borrowInfo);
        JSONObject jsonObject = JSONObject.parseObject(borrowInfo);
//        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.getString("sid"));
        System.out.println(jsonObject.getString("date"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date datetime = dateFormat.parse(jsonObject.getString("date"));
            return String.valueOf(borrowService.insertBorrowInfo(Integer.parseInt(jsonObject.getString("sid")),Integer.parseInt(jsonObject.getString("bid")),datetime));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(value = "/borrow/info/{id}",produces = "application/json;charset=UTF-8",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBorrowInfo(@PathVariable(value = "id")Integer id){
        System.out.println(id);
        return String.valueOf(borrowService.deleteBorrowInfo(id));
    }


}
