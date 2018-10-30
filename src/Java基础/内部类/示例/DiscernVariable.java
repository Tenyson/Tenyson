package Java基础.内部类.示例;

/**
 * 类的定义：一个简单的内部类例子
 * 类的作用：识别外部类、内部类的变量
 * User: Tenyson
 * Date: 2018-10-29
 * Time: 11:38 AM
 */
public class DiscernVariable {

    private String prop = "外部类的实例变量";

    private class Inner{

        private String prop = "内部类的实例变量";

        public void info(){
            String prop = "局部变量";
            //外部类类名.this.varName 访问外部类实例变量
            System.out.println("外部类的实例变量值：" + DiscernVariable.this.prop);
            //通过this.varName 访问内部类实例变量
            System.out.println("内部类的实例变量值：" + this.prop);
            //直接访问局部变量
            System.out.println("局部变量的值：" + prop);
        }
    }

    public void test(){
        Inner in = new Inner();
        in.info();
    }

    public static void main(String[] args) {
        new DiscernVariable().test();
    }

}
