package org.example.empty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       // 相当于@Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
public class Student {
    Integer sid;    // 学号
    String name;    // 姓名
    String sex;     // 性别
    Integer age;    // 年龄
}
