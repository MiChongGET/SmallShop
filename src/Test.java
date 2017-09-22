import doing.Login;
import doing.Regist;
import firstrun.FirstRun;
import personal.MyGoods;
import personal.User;
import show.ShowPage;
import store.BuyGoods;
import store.Goods;
import store.ShoppingCart;
import utils.MyObject;
import utils.MyScanner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 功能测试类
 *
 * @author MiChong
 *
 *
 */


public class Test  {

    private static Map<String,User> users ;//用户对象，用户信息存储区
    private static User userInfo;
    private static String name;
    private static boolean isDoing = true;
    public static boolean isPage1 = true;
    private static boolean isPage2 = true;

    private static Map<Integer, Goods> goodsMap;
    private static Map<Integer, MyGoods> shoppingCart ;

    private static Map<String,Map<Integer, MyGoods>> userShoopingCart;
    static {
        try {
            goodsMap = FirstRun.FIRST_RUN.getGoodsMap();
//            shoppingCart = FirstRun.FIRST_RUN.getShoppingCart();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        users = new HashMap<>();
        userShoopingCart = new HashMap<>();


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
    public static void userDoFirstPage(int num, Map<String,User> users) throws IOException {
        switch (num){
            case 1:
                boolean login  = false;

                while (!login){
                    System.out.println("请输入用户名：");
                    String login_name = MyScanner.MY_SCANNER.getString();
                    System.out.println("请输入密码：");
                    String login_passwd = MyScanner.MY_SCANNER.getString();
                    login = Login.LOGIN.setLogin(users, login_name, login_passwd);
                }

                //获取用户的登录信息
                userInfo = Login.LOGIN.userInfo;

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

                //用户注册信息写入到文件
                Regist.REGIST.writeUser(new User(name,passwd,otherName,age));
                System.out.println("恭喜你注册成功！！！");
                break;


            case 3:
                System.out.println("###########正在退出.......###########");
                System.exit(0);
                break;

        }
    }


    //第二页面操作
    public static void userDoSecondPage(int num) throws IOException{

        switch (num){

            case 1://商品列表

                BuyGoods.BUY_GOODS.showGoods(goodsMap);

                if (shoppingCart != null) {
                    BuyGoods.BUY_GOODS.buyGoods(goodsMap, shoppingCart,userShoopingCart,userInfo);
                }else {
                    shoppingCart = new HashMap<>();
                    BuyGoods.BUY_GOODS.buyGoods(goodsMap, shoppingCart,userShoopingCart,userInfo);
                }

                boolean isBuying = true;
                while (isBuying) {
                    System.out.println("是否继续购买？Y/N");
                    String exitOrNot = MyScanner.MY_SCANNER.getString();
                    if (exitOrNot.equals("Y") || exitOrNot.equals("y")) {
                        BuyGoods.BUY_GOODS.showGoods(goodsMap);
                        BuyGoods.BUY_GOODS.buyGoods(goodsMap,shoppingCart,userShoopingCart,userInfo);
                    } else {

                        isBuying = false;
                    }
                }
                break;



            case 2://购物车列表
                boolean isCheck = true;
                while (isCheck) {

                    userShoopingCart = MyObject.MY_OBJECT.Read(userShoopingCart,"src/file/shoppingCart.txt");
                    shoppingCart = userShoopingCart.get(userInfo.getUserName());

                    ShoppingCart.SHOPPING_CART.Checkout(shoppingCart);
                    System.out.println("是否付款？Y/N");

                    String exitOrNot = MyScanner.MY_SCANNER.getString();
                    if (exitOrNot.equals("Y") || exitOrNot.equals("y")) {

                        ShoppingCart.SHOPPING_CART.goChecking(shoppingCart,userInfo,userShoopingCart);
                        shoppingCart = null;

                    } else {

//                        ShowPage.SHOW_PAGE.showPersonalPage();
                        isCheck = false;
                    }
                }


//                System.out.println(userShoopingCart.toString());
                break;

            case 3:


                System.out.println("*************个人信息************");
                System.out.println("登录名："+userInfo.getUserName());
                System.out.println("年龄："+userInfo.getAge());
                System.out.println("昵称："+userInfo.getOtherName());
                System.out.println("总共花费："+userInfo.getMoney());
                System.out.println("*************个人信息************");

                break;

            case 4:
                isPage2 = false;
                isPage1 = true;
                break;

        }

    }

}
