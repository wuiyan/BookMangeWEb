package org.example.service;

import org.example.empty.Book;
import org.example.empty.Student;
import org.example.mapper.BookManageMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BookServiceImpl implements BookService{
    @Resource
    private BookManageMapper bookManageMapper;

    @Override
    public Book getBookInfo(int bid) {
        return bookManageMapper.getBookInfo(bid);
    }

    @Override
    public List<Book> getBookAllInfo() {
        return bookManageMapper.getBookAllInfo();
    }

    @Override
    public int updateBookInfo(String title, String desc, double price, int bid) {
        return bookManageMapper.updateBookInfo(title, desc,price,bid);
    }

    @Override
    public int deleteBookInfo(int bid) {
        return bookManageMapper.deleteBookInfo(bid);
    }

    @Override
    public int insertBookInfo(String title, String desc, double price) {
        return bookManageMapper.insertBookInfo(title, desc, price);
    }
}
