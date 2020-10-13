public class Pyramid extends Shape3D {
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
