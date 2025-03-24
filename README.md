# simd-bench
Benchmark of SIMD methods applied to FIX messaging.

It's a benchmark only repo. Please run the following command 
to run the jmh micro benchmarks

```gradle clean jmh```

Result on AMD Ryzen 9 7950X3D 16-Core Processor

```Benchmark                                       (size)   Mode  Cnt          Score         Error  Units
Benchmark                                       (size)   Mode  Cnt          Score         Error  Units
ComputeChecksumBenchmark.compute                    15  thrpt    5  202646373.701 ±  588157.803  ops/s
ComputeChecksumBenchmark.compute                   255  thrpt    5   10436071.876 ±   47568.190  ops/s
ComputeChecksumBenchmark.compute                 65535  thrpt    5      39426.243 ±     203.193  ops/s
ComputeChecksumBenchmark.compute             268435455  thrpt    5          9.598 ±       0.025  ops/s
ComputeChecksumBenchmark.computeSIMD                15  thrpt    5  209644460.252 ± 1524059.107  ops/s
ComputeChecksumBenchmark.computeSIMD               255  thrpt    5   37044461.554 ±  652261.622  ops/s
ComputeChecksumBenchmark.computeSIMD             65535  thrpt    5     578369.531 ±   37797.254  ops/s
ComputeChecksumBenchmark.computeSIMD         268435455  thrpt    5        127.396 ±       4.026  ops/s
ComputeChecksumBenchmarkAligned.compute             16  thrpt    5  187593478.438 ± 1423617.766  ops/s
ComputeChecksumBenchmarkAligned.compute            256  thrpt    5   10404328.415 ±   52244.004  ops/s
ComputeChecksumBenchmarkAligned.compute          65536  thrpt    5      39328.886 ±     192.061  ops/s
ComputeChecksumBenchmarkAligned.compute      268435456  thrpt    5          9.566 ±       0.023  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD         16  thrpt    5  194805176.332 ±  622468.761  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD        256  thrpt    5  180036320.282 ± 4096121.699  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD      65536  thrpt    5     579628.965 ±   29084.499  ops/s
ComputeChecksumBenchmarkAligned.computeSIMD  268435456  thrpt    5        117.187 ±       9.275  ops/s
ParseChecksumBenchmark.parse                       N/A  thrpt    5   44262238.349 ±   74237.618  ops/s
ParseChecksumBenchmark.parseSIMD                   N/A  thrpt    5   58508556.117 ±  111406.428  ops/s
ParseIntegerBenchmark.parse                        N/A  thrpt    5   44239970.730 ±  120627.067  ops/s
ParseIntegerBenchmark.parseSIMD                    N/A  thrpt    5   57889344.462 ±  155435.081  ops/s
```

on Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz, 3400 MHz
```
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
```

Find out more on [medium](https://medium.com/@pyp.net/simd-low-latency-network-applications-and-fix-ea3179bd078d)

