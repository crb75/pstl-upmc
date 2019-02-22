package puck.gui.item.arrow;



public class Util {
    public static double lerp(double min,double max,double a,double b,double x){
        return ((b-a)*(x-min))/(max-min)+a;
    }

    public static double distance(double x1,double y1,double x2,double y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}
