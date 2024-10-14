public class Overflow {
    public static void main(String[] args) {
        byte maxByte = 127;
        byte overflowedValue = (byte) (maxByte + 1); // This will overflow
        System.out.println("Original max byte: " + maxByte);
        System.out.println("Overflowed value: " + overflowedValue); // Output: -128
    }
}
