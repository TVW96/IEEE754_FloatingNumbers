# Write code to convert a decimal number to IEE754

## Steps to convert decimal to IEEE 754 32-bit single precision floating-point number:

1. Sign Bit (1-bit):
   
   - `0` if the number is positive. 
   - `1` if the number is negative. 
2. Convert absolute value to binary:

   - Split decimal number into integer and fractional parts.
   - Convert integer into binary.
   - Convert fractional into binary. 
3. Normalize the Binary:
   
   - Normalize the binay to fit the form `1.xxxxx * 2^n`.
   - Adjust exponent according to normalization process.
4. Calculate the Exponent:
   
   - The *biased* exponent is compute dby adding 127 to the actual exponent and converted to an 8-bit binary string using `String.format()`.
5. Mantissa:
   
   - The mantissa is our fractional parts left over from the normalized binary number.
   - Pad or truncate to 23 bits as required by IEEE 754 standard. 
6. IEEE 754 String Representation:
   
   - Conversion successful, add strings
      - The sign bit + the 8 Bit exponent + the 23 bit mantissa = 32 bit IEEE 754 floating-point number.

## Arithmetic Operations
// First operation:
```
Result of 0.1 + 0.2: 0.3
IEEE 754 (Single Precision) representation of 0.1 + 0.2: 0 - 01111101 - 01100110011001100110100
```
// Second operation:
```
Result of 1.0 / 3.0: 0.33333334
IEEE 754 (Single Precision) representation of 1.0 / 3.0: 0 - 01111101 - 10101010101010101010110
```

After converting the binary result of the first operation back to decimal you notice that the number is not as expected 0.3 but a much longer decimal number instead.
#### Expected Result: We expect 0.1 + 0.2 to equal 0.3.
#### Actual Result: The actual result is 0.30000001192092896.
The same issue occurs for the second operation, which is not an exact representation of 1/3.
#### Expected Result: We expect 1.0 / 3.0 to equal 0.3333333... (repeating indefinitely).
#### Actual Result: The result is 0.3333333432674408
Floating point numbers in computers are represented in binary, and not all decimal fractions can be represented exactly in binary. The result is an approximation, with the IEEE 754 format capturing as much precision as possible within it's 23 bit mantissa.
