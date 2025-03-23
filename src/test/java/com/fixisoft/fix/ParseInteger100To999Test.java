package com.fixisoft.fix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseInteger100To999Test {

    @Test
    public void testSimple() {
        ByteBuf buf = Unpooled.wrappedBuffer(("123\u0001").getBytes(StandardCharsets.US_ASCII));
        assertEquals(123, ParseInteger100To999.parse(buf));
        assertEquals(123, ParseInteger100To999.parseSIMD(buf.resetReaderIndex()));
    }

    @Test
    public void testAll() {
        for(int i =100;i<=999;i++) {
            ByteBuf buf = Unpooled.wrappedBuffer((i+"\u0001").getBytes(StandardCharsets.US_ASCII));
            assertEquals(i, ParseInteger100To999.parse(buf));
            assertEquals(i, ParseInteger100To999.parseSIMD(buf.resetReaderIndex()));
        }
    }
}
