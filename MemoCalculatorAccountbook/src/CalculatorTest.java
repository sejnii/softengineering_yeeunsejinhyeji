import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

     @Test
      public void testAdd() {
         CalculatorMain calculatorMain = new CalculatorMain();
         assertTrue(calculatorMain.add(3,4) == 7);

      }
      
      @Test
      public void testFtoc(){
         ConvertTemperature contemp = new ConvertTemperature();
         assertTrue(contemp.ftoc(5)==-15);
      }

}