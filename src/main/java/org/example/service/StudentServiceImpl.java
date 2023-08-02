package org.example.service;

import org.example.empty.Student;
import org.example.mapper.BookManageMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{
    @Resource   // 使用注解将mapper注入到此处，此mapper是由Mybatis根据上述配置自动实现的。
    private BookManageMapper bookManageMapper;
    @Override
    public Student getStudentInfo(Integer num) {
        return bookManageMapper.getStudentInfo(num);   // 返回根据mapper从数据库中映射出的对象
    }

    @Override
    public List<Student> getStudentAllInfo() {
        return bookManageMapper.getStudentAllInfo();
    }
}
