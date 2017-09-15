package store;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public enum  BuyGoods {

    SHOPPING_CART;


    Scanner scanner = new Scanner(System.in);
    public void showGoods(Map<Integer,Goods> goodsMap){
        System.out.println("商品编号        商品名称        商品价格        商品库存");

        Set<Integer> id = goodsMap.keySet();
        for (Integer no :id) {
            Goods goods = goodsMap.get(no);

            System.out.println(goods.getNo()+"          "+goods.getName()+"        "+
                    goods.getPrice()+"            "+goods.getNumber());
        }

    }

    public void buyGoods(Map<Integer,Goods> goodsMap){
        System.out.println("请输入商品编号");
        int no = scanner.nextInt();

        boolean isKey = goodsMap.containsKey(no);

        while (!isKey){
            System.out.println("商品不存在！！！");
            System.out.println("请输入商品编号");
            no = scanner.nextInt();
            isKey = goodsMap.containsKey(no);
        }

        System.out.println("请输入购买数目");
        int buyNum = scanner.nextInt();

//        while (){
//
//        }

        Set<Integer> key = goodsMap.keySet();
        for (Integer id :key) {
            Goods goods = goodsMap.get(id);
        }


    }


}
