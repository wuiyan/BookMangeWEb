package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.empty.Borrow;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public interface BorrowService {
    Borrow getBorrowInfo(int id);
    List<Borrow> getBorrowAllInfo();
    // 插入一条借阅信息
    int insertBorrowInfo(@Param("sid")int sid, @Param("bid")int bid, @Param("date") Date date);

    int deleteBorrowInfo(int id);
}
