import doing.Login;
import doing.Regist;
import personal.User;
import show.ShowPage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 功能测试类
 *
 * @author MiChong
 *
 *
 */


public class Test {
    private static Scanner scanner;
    private static Map<String,User> users ;
    private static boolean isDoing = true;
    public static boolean isPage1 = true;
    private static boolean isPage2 = true;


    public static void main(String[] args) {
        scanner  = new Scanner(System.in);
        users = new HashMap<>();

        ShowPage.SHOW_PAGE.setShowPage();

        while (isDoing) {
            while (isPage1) {
                System.out.println("请输入菜单：");
                int n = scanner.nextInt();
                userDoFirstPage(n,users);
            }

            while (isPage2){
                System.out.println("请输入菜单：");
                int n = scanner.nextInt();
                userDoSecondPage(n);
            }


        }
    }




    //第一页面操作
    public static void userDoFirstPage(int num, Map<String,User> users){
        switch (num){
            case 1:
                System.out.println("请输入用户名：");
                String login_name = scanner.next();
                System.out.println("请输入密码：");
                String login_passwd = scanner.next();

                boolean login = Login.LOGIN.setLogin(users, login_name, login_passwd);

                while (!login){
                    System.out.println("请输入用户名：");
                    login_name = scanner.next();
                    System.out.println("请输入密码：");
                    login_passwd = scanner.next();
                    login = Login.LOGIN.setLogin(users, login_name, login_passwd);
                }

                //退出第一面板
                isPage1 = false;
                isPage2 = true;

                //展示下一面板
                ShowPage.SHOW_PAGE.showPersonalPage();



                break;

            case 2:
                System.out.println("请输入用户名：");
                String name = scanner.next();

                //判断用户名是否存在
                boolean checkName = Regist.REGIST.checkName(users, name);
                while (!checkName){

                    System.out.println("请输入用户名：");
                    name = scanner.next();
                    checkName = Regist.REGIST.checkName(users, name);
                }

                System.out.println("请输入密码：");
                String passwd = scanner.next();
                System.out.println("再次输入密码：");
                String passwdto = scanner.next();


                boolean loginPassWd = Regist.REGIST.getPassWd(passwd, passwdto);
                while (!loginPassWd){
                    System.out.println("请输入密码：");
                    passwd = scanner.next();
                    System.out.println("再次输入密码：");
                    passwdto = scanner.next();

                    loginPassWd = Regist.REGIST.getPassWd(passwd, passwdto);

                }


                System.out.println("输入年龄：");
                int age = scanner.nextInt();

                boolean isAge = Regist.REGIST.getAge(age);
                while (!isAge){
                    System.out.println("输入年龄：");
                    age = scanner.nextInt();
                    isAge = Regist.REGIST.getAge(age);
                }

                System.out.println("请输入昵称：");
                String otherName = scanner.next();

                //使用Map存储用户信息，键是用户名，值是User对象
                users.put(name,new User(name,passwd,otherName,age));
                // System.out.println(users);

                System.out.println("恭喜你注册成功！！！");
                ShowPage.SHOW_PAGE.setShowPage();
                break;


            case 3:
                System.out.println("###########正在退出.......###########");
                System.exit(0);
                break;


        }

    }


    //第二页面操作
    public static void userDoSecondPage(int num){

        switch (num){

            case 1:
                System.out.println("商品购买");

                break;

            case 2:
                System.out.println("我的购物车");
                break;

            case 3:
                System.out.println("个人信息");
                break;

            case 4:
                isPage2 = false;
                isPage1 = true;
                ShowPage.SHOW_PAGE.setShowPage();
                break;

        }

    }

}
