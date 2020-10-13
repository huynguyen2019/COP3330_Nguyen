public class Sphere extends Shape3D {
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
