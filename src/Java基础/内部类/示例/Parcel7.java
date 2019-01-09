package Java基础.内部类.示例;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: dc
 * Date: 2018-11-26
 * Time: 2:03 PM
 */
public class Parcel7 {

    public Contents contents() {
        return new Contents() {
            private int i = 11;
            public int value() { return i; }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
interface Contents{

}