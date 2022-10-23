package eu.msdhn.tef.item09;

public record Point(int x , int y) {

    public static void main(String ...args){

        Point p = new Point(1,2);

        System.out.println(p.x() + p.y());

    }

}
