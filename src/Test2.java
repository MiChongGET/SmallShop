import personal.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 *
 * 功能测试类2
 *
 * 实现本地文件形式的存储数据，使用序列化和反序列化的方法将对象存储到文件中，并可以将对象从文本中解析出来
 *
 * @author MiChong
 *
 *
 */

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        FileWriter fw = new FileWriter("regist.txt");

        //将对象使用序列化的形式写入到文件中
        ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("regist.txt"));
        User user = new User("michong","123456","米虫",21);
        ops.writeObject(user);
        ops.close();

        //将对象按照反序列化的形式读出来
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("regist.txt"));
        Object o = ois.readObject();
        System.out.println(o.toString());

    }
}
