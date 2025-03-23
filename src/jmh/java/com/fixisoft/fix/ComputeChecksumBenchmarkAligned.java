package com.fixisoft.fix;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(jvmArgsPrepend = {"-XX:+UnlockExperimentalVMOptions", "-XX:-UseJVMCICompiler"})
public class ComputeChecksumBenchmarkAligned {

    @Param({"16", "256", "65536", "268435456"})
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
