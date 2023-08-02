package org.example.empty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data       // 相当于@Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
public class Borrow {
    Integer id;     // 借阅ID
    Student student;    // 学生对象
    Book book;    // 书籍对象
    Date date;      // 借阅日期
}
