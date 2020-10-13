public class Circle extends Shape2D {
    private final double radius;
    Circle(double radius){
        this.radius = radius;
    }
    @Override
    public String getName(){
        return "circle";
    }
    @Override
    public double getArea(){
        double cArea;
        cArea = Math.PI * radius * radius;
        return cArea;
    }
}
