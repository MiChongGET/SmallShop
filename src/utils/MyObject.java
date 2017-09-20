package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 对象流工具类
 *
 * @author MiChong
 *
 *
 *
 */


public class MyObject {


    public <T>T Read(T t,String fileName) throws IOException {


        InputStream is = new FileInputStream(fileName);

        ObjectInputStream ois = new ObjectInputStream(is);

        Object o = null;

        while(true){

            try {
               o =  ois.readObject();
            }catch (EOFException E){
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        ois.close();
        //强制转化成Map<Integer,Goods>类型的对象。
        t= (T)o;

        return t;

    }

    public <T>T Write(T t,String fileName,boolean b) throws IOException{

        OutputStream os = new FileOutputStream(fileName,b);

        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(t);

        oos.close();

        return t;

    }


    //读取用户注册用户的集合
    public <T>T ReadUser(T t,String fileName) throws IOException{

        InputStream is = new FileInputStream(fileName);


        List list = new ArrayList<>();

        while(true){

            try {
                ObjectInputStream ois = new ObjectInputStream(is);

                //强制转化成Map<Integer,Goods>类型的对象。
                list.add(ois.readObject());

            }catch (EOFException E){
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        t = (T)list;
        return t;
    }

    public <T>T WriteUser(T t,String fileName,boolean b) throws IOException{

        OutputStream os = new FileOutputStream(fileName,b);

        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(t);

        return t;

    }

}
