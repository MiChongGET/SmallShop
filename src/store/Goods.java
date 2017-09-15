package store;

/**
 *
 * 商品类
 * @author MiChong
 *
 *
 */
public class Goods {
    private int no;//编号
    private String name;//商品名称
    private double price;//商品价格
    private int number;//商品数量

            //初始化数据方法
    public  Goods(int iNo, String sName, double dPrice, int iNumber) {
        no = iNo;
        name = sName;
        price = dPrice;
        number = iNumber;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }




    // 按格式输出
    public void showGoods() {
        System.out.println(no + "\t\t" + name
                + (name.getBytes().length > 10 ? "\t" : "\t\t") + price
                + "\t\t" + number);
    }
}