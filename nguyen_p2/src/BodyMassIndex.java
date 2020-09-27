public class BodyMassIndex {
    private double height;
    private double weight;
    private double score;
    public static final String underweight = "underweight";
    public static final String normal = "Normal weight";
    public static final String overweight = "Overweight";
    public static final String obese = "Obesity";

    public double getHeight(){
        return this.height;
    }

    public double getWeight(){
        return this.weight;
    }

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double bmiScore(){
        this.score = 703 * weight / height * height;
        return score;
    }
    public String bmiCategory(){
        if(score < 18.5){
            return underweight;
        }
        else if(18.5 <= score && score <= 24.9){
            return normal;
        }
        else if(25 <= score && score <= 29.9){
            return overweight;
        }
        else{
            return obese;
        }
    }
}