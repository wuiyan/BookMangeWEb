import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.example.empty.Student;
import org.example.mapper.BookManageMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class Test {

    @org.junit.jupiter.api.Test
    void Test1(){
        Student student = new Student();
        student.setName("张三");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(student);
        System.out.println(jsonArray.toJSONString());
//        System.out.println(JSON.parseObject(jsonObject.toJSONString(), Student.class));
//        System.out.println(JSON.toJavaObject(jsonObject,Student.class));
    }
}
