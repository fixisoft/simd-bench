package com.fixisoft.fix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeChecksumTest {

    @Test
    public void scalarVsSIMD() {
        byte[] bytes = Generators.randomByteArray(8192);
        assertEquals(ComputeChecksum.compute(bytes), ComputeChecksum.computeSIMD(bytes), 0.0001f);
    }
}
