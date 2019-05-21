# Base-Conversion
This program gathers input from the console as a string, then determines the base of the input. It then converts binary/octal/decimal/hexadecimal values to BigInteger for storage. It can then convert to any of the other base types as required.

## Sample Output
![sample console output](https://github.com/zspatter/base-conversion/blob/master/sample_output.png)

## What I Learned
* Interfaces in Java
* What abstract classes are and how to use them
* How to store data as a common type that can be shared between classes (BigInteger)
* How to use a static `Factory` class to build various `<<interface>>` objects
* How to convert between bases one byte at a time
* Two's complement
* UML notation
* Data structures and data management in Java
* StringBuilder class

## Challenges
* Original internal representation was binary bytes, but this caused issues due to Java's interger types being signed
* To overcome issues with signed representation, I looked into using a wider type to prevent overflow, but this created great challenges when joining the individual bytes back together
* Case sensitivity caused the system to be unstable (this has been addressed and fixed)
* Design choices led to potential for null pointers (this has been addessed with null checks)

## Tasks
- [x] Finish the decimal base class implementation (last base class)
- [x] Follow up on issue with returning unsigned binary bytes
- [x] Investigate alternative common data storage options such as BigInteger
- [ ] Add support for hex strings with spaces between individual bytes (2 digits) as input
