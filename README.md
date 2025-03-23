# simd-bench
Benchmark of SIMD methods applied to FIX messaging

Benchmark                                       (size)   Mode  Cnt          Score         Error  Units
ComputeChecksumBenchmark.compute                    15  thrpt    5  155243301,737 ±  353850,599  ops/s
ComputeChecksumBenchmark.compute                   255  thrpt    5    7898976,460 ±   24360,965  ops/s
ComputeChecksumBenchmark.compute                 65535  thrpt    5      29621,311 ±      24,184  ops/s
ComputeChecksumBenchmark.compute             268435455  thrpt    5          7,015 ±       0,005  ops/s
ComputeChecksumBenchmark.computeSIMD                15  thrpt    5  156552031,861 ±  324167,926  ops/s
ComputeChecksumBenchmark.computeSIMD               255  thrpt    5   30952120,252 ± 1936584,795  ops/s
ComputeChecksumBenchmark.computeSIMD             65535  thrpt    5     199426,550 ±   27409,794  ops/s
ComputeChecksumBenchmark.computeSIMD         268435455  thrpt    5         37,759 ±       0,700  ops/s
ComputeChecksumBenchmarkAligned.compute             16  thrpt    5  149475592,980 ±  248661,072  ops/s
ComputeChecksumBenchmarkAligned.compute            256  thrpt    5    7871322,535 ±   20645,430  ops/s
ComputeChecksumBenchmarkAligned.compute          65536  thrpt    5      29612,308 ±      79,314  ops/s
ComputeChecksumBenchmarkAligned.compute      268435456  thrpt    5          7,017 ±       0,016  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD         16  thrpt    5  149655581,230 ±  281394,544  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD        256  thrpt    5   48119892,528 ± 3460746,862  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD      65536  thrpt    5     205547,848 ±    6257,626  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD  268435456  thrpt    5         37,545 ±       1,073  ops/s
ParseChecksumBenchmark.parse                       N/A  thrpt    5   39808986,168 ±  109744,627  ops/s
ParseChecksumBenchmark.parseSIMD                   N/A  thrpt    5   60427728,078 ±  479402,248  ops/s
ParseIntegerBenchmark.parse                        N/A  thrpt    5   39870853,913 ±  209115,236  ops/s
ParseIntegerBenchmark.parseSIMD                    N/A  thrpt    5   57359122,502 ±  186756,645  ops/s

