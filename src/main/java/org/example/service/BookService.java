package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.empty.Book;
import org.example.empty.Student;
import org.springframework.stereotype.Component;

import java.util.List;


public interface BookService {
    Book getBookInfo(int bid);  // 获取单个书籍信息
    List<Book> getBookAllInfo();    // 获取全部书籍信息

    // 更新书籍信息
    int updateBookInfo(@Param("title")String title, @Param("desc")String desc, @Param("price")double price, @Param("bid")int bid);
    // 删除一条书籍信息
    int deleteBookInfo(@Param("bid")int bid);
    // 插入一条书籍信息
    int insertBookInfo(@Param("title")String title,@Param("desc")String desc,@Param("price")double price);


}
