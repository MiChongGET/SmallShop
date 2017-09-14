package doing;

import personal.User;

import java.util.Map;
import java.util.Set;

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


}
