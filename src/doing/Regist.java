package doing;

import personal.User;
import utils.MyObject;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * 注册模块
 * @author MiChong
 *
 *
 *
 */

public enum Regist {

    REGIST;

    public boolean getPassWd(String passwd,String passwdto){

        if (passwd.length() <6){
            System.out.println("你的密码小于6位数字");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!");
            return false;
        }
        if(!(passwd.equals(passwdto))){
            System.out.println("两次密码输入不一致");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!");
            return false;
        }

        return true;

    }


    public boolean getAge(int age){

        if (age < 0  || age >100) {
            System.out.println("你的年龄必须是0-100之间");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!");
            return false;
        }
        return true;

    }

    public boolean checkName(Map<String,User> users,String name){

        Set<String> names = users.keySet();

        for (String s:names) {

            if (s.equals(name)) {

                System.out.println("用户名已经存在！！！");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                return false;
            }
        }

        return true;
    }

    public void writeUser(User user) throws IOException {


        Map<String,User> map = new HashMap<>();

        //判断文件是否存在并且是否为空
        File f = new File("src/file/regist.txt");
        if (f.exists() && f.length() >0) {
            map = MyObject.MY_OBJECT.Read(map, "src/file/regist.txt");
        }
        map.put(user.getUserName(),user);
        MyObject.MY_OBJECT.Write(map,"src/file/regist.txt");


    }

}
