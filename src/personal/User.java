package personal;

import java.io.Serializable;

/**
 *
 * 用户类
 * @author MiChong
 *
 */

public class User  implements Serializable{

    private static final long serialVersionUID = 2308311270885377533L;

    private String userName;//用户名
    private String passWord;//用户密码
    private String otherName;//昵称
    private int age;//用户年龄
    private double money ;//使用金额
    private double account;//账户金额

    public User(){

    }

    public User(String userName, String passWord, String otherName, int age) {
        this.userName = userName;
        this.passWord = passWord;
        this.otherName = otherName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (Double.compare(user.money, money) != 0) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (passWord != null ? !passWord.equals(user.passWord) : user.passWord != null) return false;
        return otherName != null ? otherName.equals(user.otherName) : user.otherName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (otherName != null ? otherName.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", otherName='" + otherName + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
