package com.test.mvnmyExample;
/**
 * Uses benchmarking to time TriNum for given array sizes, currently passed from command line
 */

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class MyBenchmark {

	// one way of passing arguments to the benchmarking method
	@Param({ "1" }) // Sets the default if not overridden (override by
					// specifying values on command line)
	public static int size;

	@State(Scope.Thread)
	public static class MyState {
		int[] theArray;

		// populates the theArray before running benchmarking test
		@Setup(Level.Trial)
		public void doSetup() {
			theArray = TriNum.popArray(size);
		}

	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput) // Throughput is the default
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 20, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void testMethod(Blackhole myBlackhole, MyState theState) {
		// calls the method to be measured
		int theCount = TriNum.cumCount(theState.theArray);

		myBlackhole.consume(theCount);// to defend against dead code
										// elimination, don't want the JVM to
										// optimise this
	}

	public static void main(String[] args) throws RunnerException {

		String[] sizeOfArray;// will contain all the sizes of arrays to be
								// tested
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
