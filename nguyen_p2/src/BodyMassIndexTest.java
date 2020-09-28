import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest {
    @Test
    void NormalBMI(){
        BodyMassIndex a = new BodyMassIndex(69, 144);
        assertEquals(21.3, a.bmiScore());
        assertEquals("Normal weight", a.bmiCategory());
    }
    @Test
    void youNeedtoEatMore(){
        BodyMassIndex a = new BodyMassIndex(80, 132);
        assertEquals(14.5, a.bmiScore());
        assertEquals("Underweight", a.bmiCategory());
    }
    @Test
    void heavy(){
        BodyMassIndex a = new BodyMassIndex(72, 200);
        assertEquals(27.1, a.bmiScore());
        assertEquals("Overweight", a.bmiCategory());
    }
    @Test
    void livingOnFastFood(){
        BodyMassIndex a = new BodyMassIndex(60, 250);
        assertEquals(48.8, a.bmiScore());
        assertEquals("Obesity", a.bmiCategory());
    }
}
