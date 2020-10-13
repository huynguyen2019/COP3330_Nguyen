public class Triangle extends Shape2D {
    private final double base;
    private final double height;
    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    @Override
    public String getName(){
        return "triangle";
    }
    @Override
    public double getArea(){
        double tArea;
        tArea = (base * height) / 2;
        return tArea;
    }
}
