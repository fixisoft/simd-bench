package com.fixisoft.fix;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(jvmArgsPrepend = {"-XX:+UnlockExperimentalVMOptions", "-XX:-UseJVMCICompiler"})
public class ComputeChecksumBenchmark {

    //a length of 2^n-1 is a worst-case for vectorized computation
    @Param({"15", "255", "65535", "268435455"})
    private int size;

    private byte[] bytes;

    @Setup(Level.Iteration)
    public void beforeIteration() {
        this.bytes = Generators.randomByteArray(size);
    }

    @Benchmark
    public void compute(final Blackhole bh) {
        bh.consume(ComputeChecksum.compute(bytes));
    }

    @Benchmark
    public void computeSIMD(final Blackhole bh) {
        bh.consume(ComputeChecksum.computeSIMD(bytes));
    }

}
