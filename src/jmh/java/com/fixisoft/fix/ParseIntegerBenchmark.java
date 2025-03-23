package com.fixisoft.fix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import static java.nio.charset.StandardCharsets.US_ASCII;

@State(Scope.Benchmark)
public class ParseIntegerBenchmark {

    private ByteBuf byteBuf;

    @TearDown(Level.Invocation)
    public void afterInvocation() {
        byteBuf.resetReaderIndex();
    }

    @TearDown(Level.Trial)
    public void afterIteration() {
        byteBuf.release();
    }

    @Setup(Level.Trial)
    public void beforeIteration() {
        byteBuf = Unpooled.directBuffer();
        byteBuf.writeCharSequence(Generators.randomPaddedInt(999, 3), US_ASCII);
    }

    @Benchmark
    public void parse(final Blackhole bh) {
        bh.consume(ParseInteger100To999.parse(byteBuf));
    }

    @Benchmark
    public void parseSIMD(final Blackhole bh) {
        bh.consume(ParseInteger100To999.parseSIMD(byteBuf));
    }

}
