package com.fixisoft.fix;

import io.netty.buffer.ByteBuf;

import static io.netty.buffer.Unpooled.wrappedBuffer;
import static java.nio.charset.StandardCharsets.US_ASCII;

public final class ParseInteger100To999 {

    private static final int[] LOOKUP_INT_SOH;

    private static final int START_LOOKUP_INT_SOH;

    static {
        START_LOOKUP_INT_SOH = wrappedBuffer("100\u0001".getBytes()).readInt();
        final int last = wrappedBuffer("999\u0001".getBytes()).readInt();
        LOOKUP_INT_SOH = new int[last - START_LOOKUP_INT_SOH + 1];
        for (int i = 100; i <= 999; i++) {
            final int key = wrappedBuffer((i + "\u0001").getBytes()).readInt();
            LOOKUP_INT_SOH[key - START_LOOKUP_INT_SOH] = i;
        }
    }

    public static int parse(final ByteBuf byteBuf) {
        final String string = new String(new byte[]{byteBuf.readByte(), byteBuf.readByte(), byteBuf.readByte()}, US_ASCII);
        return Integer.parseInt(string);
    }

    public static int parseSIMD(final ByteBuf byteBuf) {
        return LOOKUP_INT_SOH[byteBuf.readInt() - START_LOOKUP_INT_SOH];
    }
}
