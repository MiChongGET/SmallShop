package doing;

import personal.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public boolean setLogin(Map<String,User> users, String name,String passwd){

        List<String> names = new ArrayList<>();
        Set<String> user = users.keySet();

        for (String s:user) {
            names.add(s);
        }

        if (names.contains(name)){

            if (passwd.equals(users.get(name).getPassWord())) {
                System.out.println("登录成功！   你好:"+users.get(name).getOtherName());

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
