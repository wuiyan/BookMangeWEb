package org.example.empty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data       // 相当于@Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
public class Book {
    Integer bid;    // 书籍ID
    String title;   // 书籍名称
    String desc;    // 书籍描述
    Double price;    // 书籍价格
}
