/*
 * A skeleton for HW3
 * The file with the primes is read using input redirection
 * The product of two primes whose factor will be calculated
 * is read as command line argument.
 * To compile on EOS:
 * /usr/java/jdk1.8.0_102/bin/javac HW3.java  
 * Sample execution command:
 * /usr/java/jdk1.8.0_102/bin/java HW3  239811952854769 < oneMillionPrimes.txt

 */ 

import java.util.*;


public class HW3 {

    private final static int SIZE = 1000000;
    public static void main(String args[]) {

	if (args.length != 1) {
	    System.out.println("Usage java HW3 target");
	    return;
	}
	ArrayList < Integer > primes = new ArrayList < Integer > (SIZE);
	// Read a collection of prime numbers
	// Use input redirection
	Scanner scn = new Scanner(System.in);

	while (scn.hasNext()) {
	    primes.add(scn.nextInt());
	}


	long target = Long.parseLong(args[0]);
	System.out.println("The target is: "+target);
	System.out.println("And its factors are: ");
	long startTime = System.currentTimeMillis();
    final long fTarget = target;
       
    primes.stream().
        parallel().
        filter(e -> e <= fTarget).
        filter(e -> fTarget % e == 0).
        forEach(System.out::println);
        
	long endTime = System.currentTimeMillis();
	long duration = endTime - startTime;
	System.out.println("Time taken: "+ duration);
	
    }
}
