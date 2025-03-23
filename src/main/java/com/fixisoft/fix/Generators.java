package com.fixisoft.fix;

import com.google.common.base.Strings;

import java.util.Random;

public class Generators {

    public static final String SOH = "\u0001";

    public static byte[] randomByteArray(final int length) {
        byte[] byteArray = new byte[length];
        Random random = new Random();
        for (var i = 0; i < length; i++)
            byteArray[i] = (byte) random.nextInt();
        return byteArray;
    }

    public static String randomChecksum() {
        return randomPaddedInt(255, 3);
    }

    public static String randomPaddedInt(final int upperBound, final int paddingLen) {
        Random random = new Random();
        return Strings.padStart(Integer.toString(random.nextInt(0, upperBound)), paddingLen, '0') + SOH;
    }

}
