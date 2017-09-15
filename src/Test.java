import doing.Login;
import doing.Regist;
import personal.MyGoods;
import personal.User;
import show.ShowPage;
import store.BuyGoods;
import store.Goods;
import store.ShoppingCart;
import utils.MyScanner;

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

    private static Map<String,User> users ;//用户对象，用户信息存储区
    private static String name;
    private static boolean isDoing = true;
    public static boolean isPage1 = true;
    private static boolean isPage2 = true;

    private static Map<Integer, Goods>goodsMap;
    private static Map<Integer, MyGoods> shoppingCart;

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



        //购物车初始化
        shoppingCart = new TreeMap<Integer, MyGoods>();
        shoppingCart.put(10101,new MyGoods(10101, "海尔冰箱", 3999.9, 10,"2017-09-15 15:09:00"));
        shoppingCart.put(10104,new MyGoods(10104, "美的空调", 4909.9, 8,"2017-09-15 16:09:00"));
    }

    public static void main(String[] args) {
        users = new HashMap<>();



        while (isDoing) {

            while (isPage1) {
            ShowPage.SHOW_PAGE.setShowPage();
                System.out.println("请输入菜单：");
                int n = MyScanner.MY_SCANNER.getInt();
                userDoFirstPage(n,users);
            }

            while (isPage2){

                //展示下一面板
                ShowPage.SHOW_PAGE.showPersonalPage();
                System.out.println("请输入菜单：");
//                int n = MyScanner.MY_SCANNER.getInt();
                int anInt = MyScanner.MY_SCANNER.getInt();
                userDoSecondPage(anInt);
            }


        }
    }




    //第一页面操作
    public static void userDoFirstPage(int num, Map<String,User> users){
        switch (num){
            case 1:
                System.out.println("请输入用户名：");
                String login_name = MyScanner.MY_SCANNER.getString();
                System.out.println("请输入密码：");
                String login_passwd = MyScanner.MY_SCANNER.getString();

                boolean login = Login.LOGIN.setLogin(users, login_name, login_passwd);

                while (!login){
                    System.out.println("请输入用户名：");
                    login_name = MyScanner.MY_SCANNER.getString();
                    System.out.println("请输入密码：");
                    login_passwd = MyScanner.MY_SCANNER.getString();
                    login = Login.LOGIN.setLogin(users, login_name, login_passwd);
                }

                //退出第一面板
                isPage1 = false;
                isPage2 = true;


                break;

            case 2:
                System.out.println("请输入用户名：");
                name = MyScanner.MY_SCANNER.getString();

                //判断用户名是否存在
                boolean checkName = Regist.REGIST.checkName(users, name);
                while (!checkName){

                    System.out.println("请输入用户名：");
                    name = MyScanner.MY_SCANNER.getString();
                    checkName = Regist.REGIST.checkName(users, name);
                }

                System.out.println("请输入密码：");
                String passwd =MyScanner.MY_SCANNER.getString();
                System.out.println("再次输入密码：");
                String passwdto =MyScanner.MY_SCANNER.getString();


                boolean loginPassWd = Regist.REGIST.getPassWd(passwd, passwdto);
                while (!loginPassWd){
                    System.out.println("请输入密码：");
                    passwd = MyScanner.MY_SCANNER.getString();
                    System.out.println("再次输入密码：");
                    passwdto = MyScanner.MY_SCANNER.getString();

                    loginPassWd = Regist.REGIST.getPassWd(passwd, passwdto);

                }


                System.out.println("输入年龄：");
                int age = MyScanner.MY_SCANNER.getInt();

                boolean isAge = Regist.REGIST.getAge(age);
                while (!isAge){
                    System.out.println("输入年龄：");
                    age = MyScanner.MY_SCANNER.getInt();
                    isAge = Regist.REGIST.getAge(age);
                }

                System.out.println("请输入昵称：");
                String otherName = MyScanner.MY_SCANNER.getString();

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

                BuyGoods.BUY_GOODS.showGoods(goodsMap);

                if (shoppingCart != null) {
                    BuyGoods.BUY_GOODS.buyGoods(goodsMap, shoppingCart);
                }else {
                    shoppingCart = new TreeMap<Integer, MyGoods>();
                    BuyGoods.BUY_GOODS.buyGoods(goodsMap, shoppingCart);
                }

                boolean isBuying = true;
                while (isBuying) {
                    System.out.println("是否继续购买？Y/N");
                    String exitOrNot = MyScanner.MY_SCANNER.getString();
                    if (exitOrNot.equals("Y") || exitOrNot.equals("y")) {
                        BuyGoods.BUY_GOODS.showGoods(goodsMap);
                        BuyGoods.BUY_GOODS.buyGoods(goodsMap,shoppingCart);
                    } else {

                        isBuying = false;
                    }
                }
                break;

            case 2:

                boolean isCheck = true;
                while (isCheck) {


                    ShoppingCart.SHOPPING_CART.Checkout(shoppingCart);
                    System.out.println("是否付款？Y/N");

                    String exitOrNot = MyScanner.MY_SCANNER.getString();
                    if (exitOrNot.equals("Y") || exitOrNot.equals("y")) {

                        ShoppingCart.SHOPPING_CART.goChecking(shoppingCart);
                        shoppingCart = null;

                    } else {

//                        ShowPage.SHOW_PAGE.showPersonalPage();
                        isCheck = false;
                    }
                }
                break;

            case 3:
                System.out.println("*************个人信息************");
                System.out.println("登录名："+users.get(name).getUserName());
                System.out.println("年龄："+users.get(name).getAge());
                System.out.println("昵称："+users.get(name).getOtherName());
                System.out.println("*************个人信息************");

                break;

            case 4:
                isPage2 = false;
                isPage1 = true;
                break;

        }

    }

}
