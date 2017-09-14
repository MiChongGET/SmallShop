package show;

/**
 *
 * 操作面板
 *
 * @author MiChong
 *
 */

public enum  ShowPage {

    SHOW_PAGE;

    public void setShowPage(){

        System.out.println("******************电器商城********************");

        System.out.println("               1、用户登录");
        System.out.println("               2、用户注册");
        System.out.println("               3、退出系统");

        System.out.println("******************电器商城********************");

    }


    public void showPersonalPage(){

        System.out.println("******************电器商城********************");

        System.out.println("               1、商品购买");
        System.out.println("               2、我的购物车");
        System.out.println("               3、个人信息");
        System.out.println("               4、注销");

        System.out.println("******************电器商城********************");

    }
}
