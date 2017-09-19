package personal;

import java.io.Serializable;

/**
 * Created by MiChong on 2017/9/15 0015.
 *
 * 购物车商品类
 *
 * @author MiChong
 *
 */
public class MyGoods implements Serializable{

    private static final long serialVersionUID = 2L;//必须定义一个常量

    private int no;//编号
    private String name;//商品名称
    private double price;//商品价格
    private int buyNumber;//商品数量
    private String time;//加入购物车的时间

    public MyGoods(int no, String name, double price, int buyNumber, String time) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.buyNumber = buyNumber;
        this.time = time;
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

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyGoods myGoods = (MyGoods) o;

        return this.no == myGoods.getNo();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = no;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + buyNumber;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
