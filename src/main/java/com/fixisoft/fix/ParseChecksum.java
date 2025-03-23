package com.fixisoft.fix;

import io.netty.buffer.ByteBuf;

import static java.nio.charset.StandardCharsets.US_ASCII;

public final class ParseChecksum {

    public static byte parse(final ByteBuf byteBuf) {
        final String string = new String(new byte[]{byteBuf.readByte(), byteBuf.readByte(), byteBuf.readByte()}, US_ASCII);
        return (byte) Integer.parseInt(string);
    }

    public static byte parseSIMD(final ByteBuf byteBuf) {
        return ChecksumsEnum.checkSumWordValueOf(byteBuf.readInt());
    }
}
