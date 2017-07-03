package com.test.mvnmyExample;
/**
 * Uses benchmarking to time summing numbers in arrays for given array sizes,
 *  for ints, doubles, rand and sequential (0,1,2,3,4...)
 *  All random numbers are generated from Random with the same starting seed (11)
 */

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class MyBenchmark {

	@State(Scope.Thread)
	public static class MyState {
		// the four arrays for the four different benchmarking methods

		// one way of passing arguments to the benchmarking method
		@Param({ "6", "10", "100", "1000", "10000" }) // Sets the default if not
														// overridden (override
														// by
		// specifying values on command line)
		public static int size;

		int[] theArrayIntNotRand;
		double[] theArrayDoubleNotRand;
		int[] theArrayIntRand;
		double[] theArrayDoubleRand;

		// populates the theArrays before running benchmarking test
		@Setup(Level.Trial)
		public void doSetup() {
			theArrayIntNotRand = IntTriNum.popArray(size);
			theArrayDoubleNotRand = DoubleTriNum.popArray(size);
			theArrayIntRand = IntRand.popArray(size);
			theArrayDoubleRand = DoubleRand.popArray(size);
		}

	}

	// non-random ints
	@Benchmark
	@BenchmarkMode(Mode.Throughput) // Throughput is the default
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 20, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public int testIntNotRand(MyState theState) {
		// calls the method to be measured, testing an array of ints
		// 0,1,2,3...etc
		int theCount = IntTriNum.cumCount(theState.theArrayIntNotRand);

		return theCount;// to defend against dead code
						// elimination, don't want the JVM to
						// optimise this
	}

	// non-random doubles
	@Benchmark
	@BenchmarkMode(Mode.Throughput) // Throughput is the default
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 20, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public double testDoubleNotRand(MyState theState) {
		// calls the method to be measured, testing an array of doubles
		// 0,1,2,3...etc
		double theCount = DoubleTriNum.cumCount(theState.theArrayDoubleNotRand);

		return theCount;// to defend against dead code
						// elimination, don't want the JVM to
						// optimise this
	}

	// random ints
	@Benchmark
	@BenchmarkMode(Mode.Throughput) // Throughput is the default
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 20, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public int testIntRand(MyState theState) {
		// calls the method to be measured, testing an array of random ints
		int theCount = IntRand.cumCount(theState.theArrayIntRand);

		return theCount;// to defend against dead code
						// elimination, don't want the JVM to
						// optimise this
	}

	// random doubles
	@Benchmark
	@BenchmarkMode(Mode.Throughput) // Throughput is the default
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 20, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public double testDoubleRand(MyState theState) {
		// calls the method to be measured, testing an array of random doubles
		double theCount = DoubleRand.cumCount(theState.theArrayDoubleRand);

		return theCount;// to defend against dead code
						// elimination, don't want the JVM to
						// optimise this
	}

	public static void main(String[] args) throws RunnerException {

		String[] sizeOfArray;// will contain all the sizes of arrays to be
								// tested, can also override this when run
		if (args.length > 0) {
			try {
				sizeOfArray = args;
				// sizeOfArray now contains all the sizes of arrays to be tested
				Options opt = new OptionsBuilder().include(MyBenchmark.class.getSimpleName()).param("size", sizeOfArray)
						.forks(1).build();
				// runs the benchmarking
				new Runner(opt).run();
			} catch (NumberFormatException e) {
				System.out.println("Invlaid Input must be a number");
			}
		} else {
			// using the default sizes of the array to test
			Options opt = new OptionsBuilder().include(MyBenchmark.class.getSimpleName()).forks(1).build();
			// runs the benchmarking
			new Runner(opt).run();
		}

	}

}
