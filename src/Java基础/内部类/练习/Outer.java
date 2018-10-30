package Java基础.内部类.练习;

/**
 * 创建一个Outer类，其包含一个内部类Inner,
 * 在Outer类中添加一个方法返回Inner类的引用，
 * 在Main方法中，创建并且初始化Inner类的引用。
 */
public class Outer {

    Outer(){
        System.out.println("Outer()");
    }

    class Inner{
        Inner(){
            System.out.println("Inner()");
        }
    }

    public Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        Inner in = out.getInner();
    }

}
