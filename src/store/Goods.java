package store;

/**
 *
 * 商品类
 * @author MiChong
 *
 *
 */
public class Goods {
    int no;//编号
    String name;//商品名称
    double price;//商品价格
    int number;//商品数量

            //初始化数据方法
    public void setData(int iNo, String sName, double dPrice, int iNumber) {
        no = iNo;
        name = sName;
        price = dPrice;
        number = iNumber;
    }


    // 按格式输出
    public void showGoods() {
        System.out.println(no + "\t\t" + name
                + (name.getBytes().length > 10 ? "\t" : "\t\t") + price
                + "\t\t" + number);
    }
}