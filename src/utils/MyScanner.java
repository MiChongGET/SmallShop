package utils;

import java.util.Scanner;

/**
 *
 * Scanner工具类   自定义Scanner类，防止出现输入类型和接收类型不匹配而出现的异常，导致奔溃使得程序结束
 * @author MiChong
 *
 *
 */
public enum  MyScanner  {

    MY_SCANNER;

    private static  Scanner input  = new Scanner(System.in);
    private static int temp = 0;
    private static String s = "";
    private static double d = 0;

    //获取输入的数字
    public int  getInt(){
        while (true){
            try {
                temp = input.nextInt();
                break;
            }catch (Exception e){
                input = new Scanner(System.in);
                System.out.println("输入类型不匹配！重新输入");
            }
        }

        return temp;
    }


    //获取输入的字符
    public String  getString(){
        while (true){
            try {
                s = input.next();
                break;
            }catch (Exception e){
                input = new Scanner(System.in);
                System.out.println("输入类型不匹配！重新输入");
            }
        }
        return s;
    }

    //获取输入的double类型
    public double  getDouble(){
        while (true){
            try {
                d = input.nextDouble();
                break;
            }catch (Exception e){
                input = new Scanner(System.in);
                System.out.println("输入类型不匹配！重新输入");
            }
        }
        return d;
    }
}
