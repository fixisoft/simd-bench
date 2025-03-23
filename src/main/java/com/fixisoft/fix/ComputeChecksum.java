package com.fixisoft.fix;

import jdk.incubator.vector.ByteVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

public final class ComputeChecksum {

    private static final VectorSpecies<Byte> SPECIES = ByteVector.SPECIES_PREFERRED;

    public static byte compute(final byte[] bytes) {
        byte sum = 0;
        for (int i = 0, bytesLength = bytes.length; i < bytesLength; i++)
            sum += bytes[i];
        return sum;
    }

    public static byte computeSIMD(final byte[] bytes) {
        byte sum = 0;
        int i = 0;
        final int upperBound = SPECIES.loopBound(bytes.length);
        for (; i < upperBound; i += SPECIES.length()) {
            sum += ByteVector.fromArray(SPECIES, bytes, i).reduceLanes(VectorOperators.ADD);
        }
        for (; i < bytes.length; i++)  // Cleanup loop
            sum += bytes[i];
        return sum;
    }

}
