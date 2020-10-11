public abstract class Shape3D extends Shape {
    public abstract double getVolume();
}

class Cube extends Shape3D{
    private final double side;
    Cube(double side){
        this.side = side;
    }
    @Override
    public String getName(){
        return "cube";
    }
    @Override
    public double getArea(){
        double cubeSurfaceArea;
        cubeSurfaceArea = 6 * (side * side);
        return cubeSurfaceArea;
    }
    @Override
    public double getVolume(){
        double cVolume;
        cVolume = side * side * side;
        return cVolume;
    }
}

class Pyramid extends Shape3D{
    private final double length;
    private final double width;
    private final double height;
    Pyramid(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public String getName(){
        return "pyramid";
    }
    @Override
    public double getArea(){
        double pyramidSurfaceArea;
        pyramidSurfaceArea = (length * width) + (length * Math.sqrt((width / 2) * (width / 2) + height
                * height)) + (width * Math.sqrt(((length / 2) * (length / 2)) + height * height));
        return pyramidSurfaceArea;
    }
    @Override
    public double getVolume(){
        double pVolume;
        pVolume = (length * width * height) / 3;
        return pVolume;
    }
}

class Sphere extends Shape3D{
    private final double radius;
    Sphere(double radius){
        this.radius = radius;
    }
    @Override
    public String getName(){
        return "sphere";
    }
    @Override
    public double getArea(){
        double sphereSurfaceArea;
        sphereSurfaceArea = 4 * Math.PI * (radius * radius);
        return sphereSurfaceArea;
    }
    @Override
    public double getVolume(){
        double sVolume;
        sVolume = (4 * Math.PI * (radius * radius * radius)) / 3;
        return sVolume;
    }
}