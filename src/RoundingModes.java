import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingModes {
    public static void main(String[] args) {
        BigDecimal number1 = new BigDecimal("2.5");
        BigDecimal number2 = new BigDecimal("3.5");
        BigDecimal number3 = new BigDecimal("2.4");
        BigDecimal number4 = new BigDecimal("3.6");

        // Rounding examples with different modes
        System.out.println("Rounding 2.5:");
        System.out.println("UP: " + number1.setScale(0, RoundingMode.UP));
        System.out.println("DOWN: " + number1.setScale(0, RoundingMode.DOWN));
        System.out.println("CEILING: " + number1.setScale(0, RoundingMode.CEILING));
        System.out.println("FLOOR: " + number1.setScale(0, RoundingMode.FLOOR));
        System.out.println("HALF_UP: " + number1.setScale(0, RoundingMode.HALF_UP));
        System.out.println("HALF_DOWN: " + number1.setScale(0, RoundingMode.HALF_DOWN));
        System.out.println("HALF_EVEN: " + number1.setScale(0, RoundingMode.HALF_EVEN));

        System.out.println("\nRounding 3.5:");
        System.out.println("UP: " + number2.setScale(0, RoundingMode.UP));
        System.out.println("DOWN: " + number2.setScale(0, RoundingMode.DOWN));
        System.out.println("CEILING: " + number2.setScale(0, RoundingMode.CEILING));
        System.out.println("FLOOR: " + number2.setScale(0, RoundingMode.FLOOR));
        System.out.println("HALF_UP: " + number2.setScale(0, RoundingMode.HALF_UP));
        System.out.println("HALF_DOWN: " + number2.setScale(0, RoundingMode.HALF_DOWN));
        System.out.println("HALF_EVEN: " + number2.setScale(0, RoundingMode.HALF_EVEN));

        System.out.println("\nRounding 2.4:");
        System.out.println("UP: " + number3.setScale(0, RoundingMode.UP));
        System.out.println("DOWN: " + number3.setScale(0, RoundingMode.DOWN));
        System.out.println("CEILING: " + number3.setScale(0, RoundingMode.CEILING));
        System.out.println("FLOOR: " + number3.setScale(0, RoundingMode.FLOOR));
        System.out.println("HALF_UP: " + number3.setScale(0, RoundingMode.HALF_UP));
        System.out.println("HALF_DOWN: " + number3.setScale(0, RoundingMode.HALF_DOWN));
        System.out.println("HALF_EVEN: " + number3.setScale(0, RoundingMode.HALF_EVEN));

        System.out.println("\nRounding 3.6:");
        System.out.println("UP: " + number4.setScale(0, RoundingMode.UP));
        System.out.println("DOWN: " + number4.setScale(0, RoundingMode.DOWN));
        System.out.println("CEILING: " + number4.setScale(0, RoundingMode.CEILING));
        System.out.println("FLOOR: " + number4.setScale(0, RoundingMode.FLOOR));
        System.out.println("HALF_UP: " + number4.setScale(0, RoundingMode.HALF_UP));
        System.out.println("HALF_DOWN: " + number4.setScale(0, RoundingMode.HALF_DOWN));
        System.out.println("HALF_EVEN: " + number4.setScale(0, RoundingMode.HALF_EVEN));
    }
}
