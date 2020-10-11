public abstract class Shape2D extends Shape{

}

class Square extends Shape2D{
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

class Triangle extends Shape2D{
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

class Circle extends Shape2D{
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