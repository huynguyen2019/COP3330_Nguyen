public class Square extends Shape2D {
    private final double side;
    Square(double side){
        this.side = side;
    }
    @Override
    public String getName(){
        return "square";
    }
    @Override
    public double getArea(){
        double sArea;
        sArea = side * side;
        return sArea;
    }
}
