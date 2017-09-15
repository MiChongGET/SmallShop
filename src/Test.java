import doing.Login;
import doing.Regist;
import personal.User;
import show.ShowPage;
import store.BuyGoods;
import store.Goods;
import store.ShoppingCart;

import java.util.*;

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

    private static Map<Integer, Goods>goodsMap;

    //静态初始化
    static {

        //仓库初始化,使用自然排序以key为关键字排序
         goodsMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2);
            }
        });
        goodsMap.put(10101, new Goods(10101, "海尔冰箱", 3999.9, 50));
        goodsMap.put(10102, new Goods(10102, "格力冰箱", 2888.8, 30));
        goodsMap.put(10103, new Goods(10103, "TCL冰箱", 1999.8, 100));
        goodsMap.put(10104, new Goods(10104, "美的冰箱", 4999.9, 60));
        goodsMap.put(10201, new Goods(10201, "海尔空调", 3099.9, 50));
        goodsMap.put(10202, new Goods(10202, "格力空调", 2808.8, 40));
        goodsMap.put(10203, new Goods(10203, "TCL空调", 1099.8, 120));
        goodsMap.put(10204, new Goods(10204, "美的空调", 4909.9, 655));
    }

    public static void main(String[] args) {
        scanner  = new Scanner(System.in);
        users = new HashMap<>();



        while (isDoing) {

//            while (isPage1) {
//            ShowPage.SHOW_PAGE.setShowPage();
//                System.out.println("请输入菜单：");
//                int n = scanner.nextInt();
//                userDoFirstPage(n,users);
//            }

            while (isPage2){

                //展示下一面板
                ShowPage.SHOW_PAGE.showPersonalPage();
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

                BuyGoods.SHOPPING_CART.showGoods(goodsMap);

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
                break;

        }

    }

}
