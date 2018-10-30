package Java基础.内部类.示例;

/**
 * 类的定义：创建可以返回内部类引用的例子
 * 类的内容：外部类_包裹类；内部类_内容类，目的地类，两个返回内部类引用方法
 * User: Tenyson
 * Date: 2018-10-28
 * Time: 9:44 PM
 */
public class Parcel2 {

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
    public Destination to(String s){
        return new Destination(s);
    }
    public Contents contents(){
        return new Contents();
    }
    //在parcel中使用其内部类，就像是用其他的类一样
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLable());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("ShangHai");
        Parcel2 q = new Parcel2();
        //在non-static的方法内定义内部类的引用
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("BeiJing");
    }
}
