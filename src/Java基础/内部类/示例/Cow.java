package Java基础.内部类.示例;

/**
 * 类的定义：一个简单的内部类例子
 * 类的重点：非静态内部类访问外部类成员变量
 * User: Tenyson
 * Date: 2018-10-29
 * Time: 10:26 AM
 */
public class Cow {

    private double weight;

    public Cow(){}

    public Cow(double weight){
        this.weight = weight;
    }

    //定义一个非静态内部类
    public class Cowleg{

        private double length;

        private String color;

        public Cowleg(){}

        public Cowleg(double length,String color){
            this.length = length;
            this.color = color;
        }

        public void info(){

            System.out.println("当前牛腿的颜色是：" + color + "，高：" + length);

            //直接访问外部类的私有成员：weight
            System.out.println("本牛腿所在奶牛重：" + weight);
        }
    }

    public void test(){
        //访问非静态内部类和其他类的使用基本没什么区别
        Cowleg c1 = new Cowleg(1.12, "黑白相间");
        c1.info();
    }

    public static void main(String[] args) {
        Cow cow = new Cow(378.9);
        cow.test();
    }
}
