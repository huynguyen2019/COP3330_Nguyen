public class Cube extends Shape3D {
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
