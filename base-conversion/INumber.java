import java.math.BigInteger;

public interface INumber
{
    String toString();

    void fromString(String userString);

    BigInteger toBigInt();

    void fromNumber(INumber iNumber);

    void fromBigInt(BigInteger data);
}
