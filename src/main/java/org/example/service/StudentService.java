package org.example.service;

import org.example.empty.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    public Student getStudentInfo(Integer num);    // 获取单个Student信息
    public List<Student> getStudentAllInfo();       // 获取所有Student信息
}
