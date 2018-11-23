package Java基础.内部类.示例;

/**
 * Description: Nesting a inner class within a method.
 */
public class Parcel5 {

        //This is a method nested in class
        public Destination destination(String s){

            //Nesting a inner class within a method
            class PDestination implements Destination{

                private String label;
                //a Constructor
                private PDestination(String whereTo){
                    label = whereTo;
                }

                public String readLabel(){ return label;}
            }

            return new PDestination(s);
        }

        public static void main(String[] args) {
            Parcel5 p = new Parcel5();
            Destination d = p.destination("Shanghai");
        }
}
