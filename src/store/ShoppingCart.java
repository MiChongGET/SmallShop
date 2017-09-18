package store;

import personal.MyGoods;
import show.ShowPage;
import utils.MyScanner;

import java.util.*;

/**
 * 购物车类
 *
 * Created by Administrator on 2017/9/15 0015.
 */
public enum  ShoppingCart {

    SHOPPING_CART;


    //购物车查看，统计购物车的商品
    double totalPrice = 0;//商品总价格
    public void Checkout(Map<Integer, MyGoods> shoppingCart){

        ShowPage.SHOW_PAGE.showShoppingCart();


        //重新整理数据，按照时间从现在往之前排序
        if (shoppingCart != null) {
            List<Map.Entry<Integer, MyGoods>> list = new ArrayList<Map.Entry<Integer, MyGoods>>(shoppingCart.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, MyGoods>>() {
                @Override
                public int compare(Map.Entry<Integer, MyGoods> o1, Map.Entry<Integer, MyGoods> o2) {
                    return -(o1.getValue().getTime().compareTo(o2.getValue().getTime()));
                }
            });

            for (Map.Entry<Integer, MyGoods> e : list) {

                System.out.println(e.getValue().getNo() + "          " + e.getValue().getName() + "        " +
                        e.getValue().getPrice() + "            " + e.getValue().getBuyNumber() + "        " +
                        e.getValue().getTime());

                totalPrice = totalPrice + (e.getValue().getBuyNumber() * e.getValue().getPrice());
            }

        }
        if (shoppingCart != null) {
            System.out.println("商品的总价格为：" + totalPrice);
        }else {
            System.out.println("购物车没有商品！");
        }
    }


    //确认付款
    public void goChecking(Map<Integer, MyGoods> shoppingCart){

        System.out.println("请输入付款金额：");
        double money = MyScanner.MY_SCANNER.getDouble();

        if (money - totalPrice >0){
            System.out.println("找零："+(money - totalPrice));

            shoppingCart = null;

        }else {

            System.out.println("你的金额不足！请重新支付");
        }


    }

}
