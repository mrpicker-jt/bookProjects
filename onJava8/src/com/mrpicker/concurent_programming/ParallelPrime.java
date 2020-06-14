package com.mrpicker.concurent_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.LongStream.rangeClosed;

public class ParallelPrime {
    static final int COUNT = 100_000;
    public static boolean isPrime(long n){
        return rangeClosed(2, (long)Math.sqrt(n)).noneMatch(i -> n % i == 0);
        }
    public static void main(String[] args)
        throws IOException {
        long startTime=System.currentTimeMillis();
        List<String> primes =
                Stream.iterate(2, i -> i + 1)
                .parallel()              // [1]
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .map(Long::toString)
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis()-startTime);
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
        }
    }