package Java基础.内部类.示例;
/**
 * 类的定义：创建一个简单的内部类,
 * 类的内容：外部类_包裹类；内部类_内容类，目的地类
 * User: Tenyson
 * Date: 2018-10-28
 * Time: 6:57 PM
 */
public class Parcel1 {

    class Contents{
        private int i = 11;
        public int value(){return i;}
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLable(){return label;}
    }

    //在parcel中使用其内部类，就像是用其他的类一样
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLable());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("ShangHai");
    }

}