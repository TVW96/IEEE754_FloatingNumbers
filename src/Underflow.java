public class Underflow {
    public static void main(String[] args) {
        int minInt = Integer.MIN_VALUE;
        int underflowedValue = minInt - 1; // This will underflow
        System.out.println("Original min int: " + minInt);
        System.out.println("Underflowed value: " + underflowedValue); // Output: 2147483647
    }
}

