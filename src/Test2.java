import personal.User;
import store.BuyGoods;
import store.Goods;

import java.io.*;
import java.util.Map;

/**
 *
 * 功能测试类2
 *
 * 实现本地文件形式的存储数据，使用序列化和反序列化的方法将对象存储到文件中，并可以将对象从文本中解析出来
 *
 * @author MiChong
 *
 *
 */

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {



        FileWriter fw = new FileWriter("src/file/regist.txt");

        //将对象使用序列化的形式写入到文件中
        ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("src/file/regist.txt"));
        User user = new User("michong","123456","米虫",21);
        User user2 = new User("qjzxzxd","123456","米虫",20);
        ops.writeObject(user);
        ops.writeObject(user2);
        ops.close();

        //将对象按照反序列化的形式读出来

        /*
         * 若文件中有若干个Object对象，你用ObjectInputStream中的readObject()去读，何时判读到结尾？
         * 方法之一：（常用的方法）将若干个对象（数量不定）都装入一个容器中（如：ArrayList之类），
         * 然后将容器这一个对象写入就行了。读取时，只要读取一个对象（即容器对象）就行了。
         *
         * 方法之二：（若不想用容器），则由于数量不定，正是用EOFException来判断结束。
         * 代码结构如下：(无论是readInt()读int，还是readObject()读对象)
         * try{
         *  while(true) {
         *   Object o=ois.radObject();
         *   处理已读出的对象o;
         *   }
         *  }
         *  catch(EOFException e){
         *  //已从流中读完。
         *  }
         *  finallly {
         * 流的关闭。 }
         */

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/file/regist.txt"));



        while (true){
            try {
                User u  = (User) ois.readObject();
                System.out.println(u.toString());
                if (u.getUserName().equals("michong")) break;
            }catch (EOFException e){
                break;
            }catch (NullPointerException e) {
                continue;
            }
        }


        ois.close();
        Map<Integer,Goods> goodsMap = null;
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("src/file/goods.txt"));
        while (true){

            try{

                goodsMap= (Map<Integer, Goods>) ois2.readObject();
                BuyGoods.BUY_GOODS.showGoods(goodsMap);
                break;
            }catch (EOFException E){

            }catch (NullPointerException e){

            }
        }


        //        Object o1 = ois.readObject();
//        System.out.println(o1);

//        ois.readObject();
//        System.out.println( ois.readObject());


    }
}
