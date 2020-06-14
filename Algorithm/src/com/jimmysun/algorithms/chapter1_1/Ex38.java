package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class Ex38 {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		int key = StdIn.readInt();
		if (BruteForceSearch.rank(key, whitelist) == -1) {
			StdOut.println(key);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Brute force search time: " + (endTime - startTime));

		key = StdIn.readInt();
		startTime = System.currentTimeMillis();
		Arrays.sort(whitelist);
		if (BinarySearch.indexOf(whitelist, key) == -1) {
			StdOut.println(key);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Binary search time: " + (endTime - startTime));
	}
}
