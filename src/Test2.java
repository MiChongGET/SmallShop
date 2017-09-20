import personal.User;
import store.BuyGoods;
import store.Goods;
import utils.MyObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

        MyObject object = new MyObject();
        List<User> regist = new ArrayList<>();

        FileWriter fw = new FileWriter("src/file/regist.txt");

        //将对象使用序列化的形式写入到文件中
        ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("src/file/regist.txt",true));
        User user = new User("michong","123456","米虫",21);
        User user2 = new User("qjzxzxd","123456","米虫",20);


//
//        ops.writeObject(user);
 //       ops.writeObject(user2);
//

        regist.add(user);
        regist.add(user2);

//        ops.writeObject(regist);
        object.Write(regist,"src/file/regist.txt");

        ops.close();

        User u = null;

//        User read1 = object.Read(u, "src/file/regist.txt");
//        System.out.println(read1);

//        object.WriteUser(user,"src/file/regist.txt",true);
//        object.Write(user,"src/file/regist.txt",true);


        List<User> userList = new ArrayList<>();



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
         *   MyObject o=ois.radObject();
         *   处理已读出的对象o;
         *   }
         *  }
         *  catch(EOFException e){
         *  //已从流中读完。
         *  }
         *  finallly {
         * 流的关闭。 }
         */

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/file/regist.txt"));
//
//        List<User> list ;
//        while (true){
//            try {
//                list= (List<User>) ois.readObject();
//                System.out.println(list.toString());
//            }catch (EOFException e){
//                break;
//            }catch (NullPointerException e) {
//                continue;
//            }
//        }


//        ois.close();
        Map<Integer,Goods> goodsMap = null;
//        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("src/file/goods.txt"));
//        while (true){
//
//            try{
//
//                goodsMap= (Map<Integer, Goods>) ois2.readObject();
//                BuyGoods.BUY_GOODS.showGoods(goodsMap);
//                break;
//            }catch (EOFException E){
//
//            }catch (NullPointerException e){
//
//            }
//        }



        Map<Integer, Goods> read = object.Read(goodsMap, "src/file/goods.txt");
        BuyGoods.BUY_GOODS.showGoods(read);

        List<User> users = object.Read(userList, "src/file/regist.txt");
//        System.out.println(users.toString());

        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){

            User user1 = iterator.next();
            System.out.println(user1.toString());
        }




    }
}
