package com.f1distributedsystem.f1clientapp.utilities;

import io.netty.buffer.ByteBuf;

import java.math.BigInteger;
import java.nio.charset.Charset;

public class Utils {
    public static BigInteger toUnsignedBigInteger(long i) {
        if (i >= 0L)
            return BigInteger.valueOf(i);
        else {
            int upper = (int) (i >>> 32);
            int lower = (int) i;

            // return (upper << 32) + lower
            return (BigInteger.valueOf(Integer.toUnsignedLong(upper))).shiftLeft(32).
                    add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
        }
    }

    public static String readString(ByteBuf buffer, int maxLength) {
        int result = buffer.bytesBefore(maxLength, (byte) 0);
        // if the string is not null terminated, just read all the characters
        result = result == -1 ? maxLength : result;
        ByteBuf b = buffer.readBytes(result);
        String s = b.toString(Charset.forName("UTF-8"));
        b.release();
        buffer.skipBytes(maxLength - result);
        return s;
    }
}
