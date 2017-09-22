package store;

import personal.MyGoods;
import personal.User;
import show.ShowPage;
import utils.MyObject;
import utils.MyScanner;
import utils.TimeUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * 商品购买
 * @author MiChong
 *
 *
 */
public enum  BuyGoods {

    BUY_GOODS;
    public void showGoods(Map<Integer,Goods> goodsMap){

        ShowPage.SHOW_PAGE.showBuyGoods();

        Set<Integer> id = goodsMap.keySet();
        for (Integer no :id) {
            Goods goods = goodsMap.get(no);

            System.out.println(goods.getNo()+"          "+goods.getName()+"        "+
                    goods.getPrice()+"            "+goods.getNumber());
        }

    }

    public void buyGoods(Map<Integer,Goods> goodsMap,
                         Map<Integer, MyGoods> shoppingCart,
                         Map<String,Map<Integer, MyGoods>> userShoopingCart,
                         User userInfo) throws IOException {

        System.out.println("请输入商品编号");
        int no = MyScanner.MY_SCANNER.getInt();


        boolean isKey = goodsMap.containsKey(no);

        while (!isKey){
            System.out.println("商品不存在！！！");
            System.out.println("请输入商品编号");
            no = MyScanner.MY_SCANNER.getInt();
            isKey = goodsMap.containsKey(no);
        }

        //商品数目处理
        boolean isBuy = false;
        int num = goodsMap.get(no).getNumber();//商品数目
        int buyNum = 0;//加入购物车的数目
        String goodsName = goodsMap.get(no).getName();//获取商品名称
        double goodsPrice = goodsMap.get(no).getPrice();//获取商品的价格

        //将最新的商品列表写入到文件中


        while (!isBuy){
            System.out.println("请输入购买数目");
             buyNum = MyScanner.MY_SCANNER.getInt();
            if(buyNum <= 0){
                System.out.println("数目不能为负数或者0！！！");
                continue;//终结，重新选择
            }
            if (buyNum > num){
                System.out.println("库存不足，请重新选择！");
                continue;
            }

            //扣除选择的数目
            goodsMap.get(no).setNumber((num - buyNum));


            MyObject.MY_OBJECT.Write(goodsMap,"src/file/goods.txt");

            isBuy = true;

        }


        /**
         *   private int no;//编号
             private String name;//商品名称
             private double price;//商品价格
             private int buyNumber;//商品数量
             private String time;//加入购物车的时间
             private double money ;//花费的金钱
         *
         *
         */
        Map<Integer, MyGoods> myGoodsMap = new HashMap<>();
        myGoodsMap = shoppingCart;
            if (shoppingCart.containsKey(no)) {
                int buyNumber = myGoodsMap.get(no).getBuyNumber();
                myGoodsMap.get(no).setBuyNumber((buyNumber + buyNum));//添加商品数目
                myGoodsMap.get(no).setTime(TimeUtils.TIME_UTILS.getTime());//更新购物时间
                userShoopingCart.put(userInfo.getUserName(),myGoodsMap);
                MyObject.MY_OBJECT.Write(userShoopingCart, "src/file/shoppingCart.txt");


            } else {

                myGoodsMap.put(no, new MyGoods(no, goodsName, goodsPrice, buyNum, TimeUtils.TIME_UTILS.getTime()));
                //实现每个用户对应一个唯一的购物车
                if (userShoopingCart.containsKey(userInfo.getUserName())){

                    userShoopingCart.put(userInfo.getUserName(),myGoodsMap);
                    MyObject.MY_OBJECT.Write(userShoopingCart, "src/file/shoppingCart.txt");
                }
                else {
                    userShoopingCart.put(userInfo.getUserName(), myGoodsMap);
                    MyObject.MY_OBJECT.Write(userShoopingCart, "src/file/shoppingCart.txt");
                }


            }

        }

}
