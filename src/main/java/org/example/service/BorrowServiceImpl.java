package org.example.service;

import org.example.empty.Borrow;
import org.example.mapper.BookManageMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Component
public class BorrowServiceImpl implements BorrowService{
    @Resource
    private BookManageMapper bookManageMapper;
    @Override
    public Borrow getBorrowInfo(int id) {
        return bookManageMapper.getBorrowInfo(id);
    }

    @Override
    public List<Borrow> getBorrowAllInfo() {
        return bookManageMapper.getBorrowAllInfo();
    }

    @Override
    public int insertBorrowInfo(int sid, int bid, Date date) {
        return bookManageMapper.insertBorrowInfo(sid,bid,date);
    }

    @Override
    public int deleteBorrowInfo(int id) {
        return bookManageMapper.deleteBorrowInfo(id);
    }
}
