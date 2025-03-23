package com.fixisoft.fix;

import com.google.common.base.Strings;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.netty.buffer.Unpooled.wrappedBuffer;
import static java.nio.charset.StandardCharsets.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseChecksumTest {

    @Test
    public void generateChecksums() {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.fixisoft.fix;\n" + "import io.netty.util.AsciiString;\n"
                + "import java.nio.charset.StandardCharsets;\n"
                + "import static com.google.common.base.Ascii.SOH;\n"
                + "import static io.netty.buffer.Unpooled.wrappedBuffer;\n"
                + "import static io.netty.util.AsciiString.of;\n\n" + "public enum ChecksumsEnum {\n\n");

        for (int i = 0; i < 255; i++) {
            String string = Strings.padStart(Integer.toString(i), 3, '0');
            sb.append("CHECKSUM_" + i + "(AsciiString.cached(\"" + string + "\"),wrappedBuffer((\"" + string + "\"+SOH).getBytes(StandardCharsets.US_ASCII)).readInt(),(byte) " + i + "),");
            sb.append("\n");
        }
        String string = Strings.padStart(Integer.toString(255), 3, '0');
        sb.append("CHECKSUM_" + 255 + "(AsciiString.cached(\"" + string + "\"),wrappedBuffer((\"" + string + "\"+SOH).getBytes(StandardCharsets.US_ASCII)).readInt(),(byte) " + 255 + ");");
        sb.append("\n");
        sb.append("public final byte checksum;\n" + "public final AsciiString value;\n" + "public final int word;\n" + "ChecksumsEnum(final AsciiString value, final int word, final byte checksum) {\n" + "this.value = value;\n" + "this.word = word;\n" + "this.checksum = checksum;\n" + "}\n");
        sb.append("public static byte checkSumWordValueOf(final int word) {\n");
        sb.append("switch(word) {\n");
        for (int i = 0; i < 256; i++) {
            string = Strings.padStart(Integer.toString(i), 3, '0');
            final int word = wrappedBuffer((string + "\u0001").getBytes(US_ASCII)).readInt();
            sb.append("case " + word + ": ").append("\n");
            sb.append("return CHECKSUM_" + i + ".checksum;").append("\n");
        }
        sb.append("default: ").append("\n");
        sb.append("throw new IllegalStateException(\"word \" + word + \" is not valid\");\n").append("\n");
        sb.append("}\n");
        sb.append("}\n");
        sb.append("}\n");
        System.out.println(sb);
    }

    @Test
    public void testRandom() {
        final ByteBuf buf = Unpooled.wrappedBuffer(Generators.randomChecksum().getBytes(US_ASCII));
        assertEquals(ParseChecksum.parse(buf), ParseChecksum.parseSIMD(buf.resetReaderIndex()));
    }

    @Test
    public void testSimple() {
        ByteBuf buf = Unpooled.wrappedBuffer("123\u0001".getBytes(US_ASCII));
        assertEquals(123, ParseChecksum.parse(buf));
        assertEquals(123, ParseChecksum.parseSIMD(buf.resetReaderIndex()));

        buf = Unpooled.wrappedBuffer("060\u0001".getBytes(US_ASCII));
        assertEquals(60, ParseChecksum.parse(buf));
        assertEquals(60, ParseChecksum.parseSIMD(buf.resetReaderIndex()));
    }
}
