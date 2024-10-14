public class InfinityAndNaN {

    public static void main(String[] args) {
        // Generate positive infinity
        float positiveInfinity = 1.0f / 0.0f;

        // Generate negative infinity
        float negativeInfinity = -1.0f / 0.0f;

        // Generate NaN
        float nanValue = 0.0f / 0.0f;

        // Output the generated values
        System.out.println("Positive Infinity: " + positiveInfinity);
        System.out.println("Negative Infinity: " + negativeInfinity);
        System.out.println("NaN: " + nanValue);

        // Verify properties
        System.out.println("Is positive infinity finite? " + Float.isInfinite(positiveInfinity) + " (Expected: true)");
        System.out.println("Is negative infinity finite? " + Float.isInfinite(negativeInfinity) + " (Expected: true)");
        System.out.println("Is NaN finite? " + Float.isNaN(nanValue) + " (Expected: true)");

        // Checking NaN property (NaN is not equal to itself)
        System.out.println("Is NaN equal to NaN? " + (nanValue == nanValue) + " (Expected: false)");
        System.out.println("Is NaN not equal to NaN? " + (nanValue != nanValue) + " (Expected: true)");
    }
}
