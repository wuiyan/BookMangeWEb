package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.empty.Book;
import org.example.empty.Borrow;
import org.example.empty.Student;

import java.util.Date;
import java.util.List;

@Mapper
public interface BookManageMapper {
    @Select("select * from student where sid = #{sid}")
    @Results({
            @Result(property = "sid",column = "sid"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
    })
    Student getStudentInfo(int sid);

    @Select("select * from student")
    @Results({
            @Result(property = "sid",column = "sid"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
    })
    List<Student> getStudentAllInfo();

    @Select("select * from book where bid = #{bid}")
    @Results({
            @Result(property = "bid",column = "bid"),
            @Result(property = "title",column = "title"),
            @Result(property = "desc",column = "desc"),
            @Result(property = "price",column = "price"),
    })
    Book getBookInfo(int bid);

    @Select("select * from book")
    @Results({
            @Result(property = "bid",column = "bid"),
            @Result(property = "title",column = "title"),
            @Result(property = "desc",column = "desc"),
            @Result(property = "price",column = "price"),
    })
    List<Book> getBookAllInfo();

    @Update("UPDATE book SET title = #{title},`desc` = #{desc},price=#{price} WHERE bid = #{bid}")
    int updateBookInfo(@Param("title")String title,@Param("desc")String desc,@Param("price")double price,@Param("bid")int bid);

    @Delete("Delete from  book  WHERE bid = #{bid}")
    int deleteBookInfo(@Param("bid")int bid);

    @Insert("INSERT INTO book(`bid`, `title`, `desc`, `price`) VALUES (NULL, #{title}, #{desc}, #{price})")
    int insertBookInfo(@Param("title")String title,@Param("desc")String desc,@Param("price")double price);

    @Select("select * from borrow where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "student",column = "sid",one = @One(select = "getStudentInfo")),
            @Result(property = "book",column = "bid",one = @One(select = "getBookInfo")),
            @Result(property = "date",column = "date")
    })
    Borrow getBorrowInfo(int id);


    @Select("select * from borrow")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "student",column = "sid",one = @One(select = "getStudentInfo")),
            @Result(property = "book",column = "bid",one = @One(select = "getBookInfo")),
            @Result(property = "date",column = "date")
    })
    List<Borrow> getBorrowAllInfo();

    @Insert("INSERT INTO borrow(`id`, `sid`, `bid`, `date`) VALUES (NULL, #{sid}, #{bid}, #{date})")
    int insertBorrowInfo(@Param("sid")int sid, @Param("bid")int bid, @Param("date")Date date);

    @Delete("delete from borrow where id = #{id}")
    int deleteBorrowInfo(int id);
}
