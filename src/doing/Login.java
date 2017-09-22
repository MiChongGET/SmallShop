package doing;

import personal.User;
import utils.MyObject;

import java.io.IOException;
import java.util.Map;

/**
 *
 * 登录功能模块
 *
 *
 * @author MiChong
 *
 */

public enum Login {

    LOGIN;

    public User userInfo ;

    public boolean setLogin(Map<String,User> users, String name,String passwd) throws IOException {


        //读取文件中的用户信息
        Map<String, User> read = MyObject.MY_OBJECT.Read(users, "src/file/regist.txt");

        if (read.containsKey(name)){

            if (passwd.equals(read.get(name).getPassWord())) {
                System.out.println("登录成功！   你好:"+read.get(name).getOtherName());
                userInfo = read.get(name);

                return true;
            }
            else {
                System.out.println("密码错误，重新登录！！！");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                return false;
            }
        }else {
            System.out.println("用户名不存在！！！");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!");
            return false;
        }

    }

}
