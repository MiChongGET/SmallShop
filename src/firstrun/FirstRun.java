package firstrun;

import personal.MyGoods;
import store.Goods;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public enum FirstRun {

    FIRST_RUN;

    private static Map<Integer, Goods> goodsMap;
    private static Map<Integer, MyGoods> shoppingCart;


    public  Map<Integer, Goods> getGoodsMap() throws IOException{

        File f1 = new File("src/file/goods.txt");
        if (!f1.exists()){
            f1.createNewFile();
        }

        if (f1.length() == 0){

            //仓库初始化,使用自然排序以key为关键字排序
            goodsMap = new HashMap<>();
            goodsMap.put(10101, new Goods(10101, "海尔冰箱", 3999.9, 50));
            goodsMap.put(10102, new Goods(10102, "格力冰箱", 2888.8, 30));
            goodsMap.put(10103, new Goods(10103, "TCL冰箱", 1999.8, 100));
            goodsMap.put(10104, new Goods(10104, "美的冰箱", 4999.9, 60));
            goodsMap.put(10201, new Goods(10201, "海尔空调", 3099.9, 50));
            goodsMap.put(10202, new Goods(10202, "格力空调", 2808.8, 40));
            goodsMap.put(10203, new Goods(10203, "TCL空调", 1099.8, 120));
            goodsMap.put(10204, new Goods(10204, "美的空调", 4909.9, 655));

            //将数据写入到文件中
            ObjectOutputStream ops = null;
            ops = new ObjectOutputStream(new FileOutputStream("src/file/goods.txt"));
            ops.writeObject(goodsMap);
            ops.flush();
            ops.close();

        }else{

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("src/file/goods.txt"));
            while (true){

                try{

                    goodsMap= (Map<Integer, Goods>) ois2.readObject();
//                    BuyGoods.BUY_GOODS.showGoods(goodsMap);
                    break;
                }catch (EOFException E){

                }catch (NullPointerException e){

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }

        return goodsMap;
    }



    public  Map<Integer, MyGoods> getShoppingCart() throws IOException {

        File f1 = new File("src/file/shoppingCart.txt");
        if (!f1.exists()){
            f1.createNewFile();
        }

        if (f1.length() == 0){

            //购物车初始化
            shoppingCart = new HashMap<>();
            shoppingCart.put(10101, new MyGoods(10101, "海尔冰箱", 3999.9, 10, "2017-09-15 15:09:00"));
            shoppingCart.put(10104, new MyGoods(10104, "美的空调", 4909.9, 8, "2017-09-15 16:09:00"));

            //将数据写入到文件中
            ObjectOutputStream ops = null;
            ops = new ObjectOutputStream(new FileOutputStream("src/file/shoppingCart.txt"));
            ops.writeObject(shoppingCart);
            ops.flush();
            ops.close();

        }
        else {
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("src/file/shoppingCart.txt"));
            while (true){

                try{

                    shoppingCart= (Map<Integer, MyGoods>) ois2.readObject();
//                    BuyGoods.BUY_GOODS.showGoods(goodsMap);
                    break;
                }catch (EOFException E){

                }catch (NullPointerException e){

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return shoppingCart;
    }
}
