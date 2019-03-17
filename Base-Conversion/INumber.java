public interface INumber
{
    String toString();

    void fromString(String userString);

    byte[] toBytes();

    void fromNumber(INumber number);

    void fromBytes(byte[] data);
}
