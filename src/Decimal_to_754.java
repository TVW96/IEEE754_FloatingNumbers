public class Decimal_to_754 {

    public static String decimalTo754(float num) {
        String result = "";
        // Step 1 - Sign bit
        int signBit = (num < 0) ? 1 : 0;
        if (num < 0) {
            num = Math.abs(num);
        }

        // Step 2: Convert the number to binary and normalize
        int intPart = (int) num; // Integer
        float fracPart = num - intPart; // Fractional

        // Convert Integer value to binary
        String intPartBinary = Integer.toBinaryString(intPart);

        //Convert Fractional value to binary
        StringBuilder fracPartBinary = new StringBuilder();
        while (fracPart > 0 && fracPartBinary.length() < 23 + 10) {
            fracPart *= 2;
            if (fracPart >= 1) {
                fracPart -= 1;
                fracPartBinary.append(1);
            } else {
                fracPartBinary.append(0);
            }
        }

        // Combine Integer and Fractional binary parts, normalize.
        String normalized;
        int exponent;
        // look for first 1 value in Integer part of Binary
        if(!intPartBinary.equals("0")) {
            normalized = intPartBinary + fracPartBinary.toString();
            exponent = intPartBinary.length() - 1;
        } else {
            // For numbers < 1, find the first 1 in the fracBin for normalization
            int firstOneIndex = fracPartBinary.indexOf("1");
            exponent = -(firstOneIndex + 1);
            normalized = fracPartBinary.substring(firstOneIndex + 1);
        }

        // Step 3: Compute biased exponent
        exponent += 127; // Add bias of 127 for single precision
        String exponentBin = String.format("%8s", Integer.toBinaryString(exponent)).replace(' ', '0'); // 8-bit exponent

        // Step 4: Get the mantissa (23 bits)
        String mantissa = normalized.substring(1); // Remove leading 1
        if (mantissa.length() > 23) {
            mantissa = mantissa.substring(0, 23);
        } else {
            mantissa = String.format("%-23s", mantissa).replace(' ', '0'); // Pad to 23 bits
        }

        // Step 5: Combine the sign, exponent, and mantissa
        return signBit + " - " + exponentBin + " - " + mantissa;
    }

    public static void main(String[] args) {
        // First operation: 0.1 + 0.2
        float result1 = 0.1f + 0.2f;
        String ieee754Result1 = decimalTo754(result1);
        System.out.println("Result of 0.1 + 0.2: " + result1);
        System.out.println("IEEE 754 (Single Precision) representation of 0.1 + 0.2: " + ieee754Result1);

        // Second operation: 1.0 / 3.0
        float result2 = 1.0f / 3.0f;
        String ieee754Result2 = decimalTo754(result2);
        System.out.println("Result of 1.0 / 3.0: " + result2);
        System.out.println("IEEE 754 (Single Precision) representation of 1.0 / 3.0: " + ieee754Result2);
    }
}
