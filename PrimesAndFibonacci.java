class PrimesAndFibonacci {

	boolean isPrime(long integer) {
		for (long i = 2; i < integer; ++i) {
			if ((integer % i) == 0) {
				return false;
			}
		}
		return true;
	}

	long doWork(long limit) {
		final long LUDICROUSLY_BIG_NUMER = 500000000;
		long n1 = 0, n2 = 1, n3 = 0;
		long result = 0;
		while (n3 < LUDICROUSLY_BIG_NUMER) // So we wouldn't be hanging here, prime check takes long time
		{
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
			if ((n3 > limit) && (isPrime(n3))) {
				result = n3;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PrimesAndFibonacci primes = new PrimesAndFibonacci();
		final long limit = 500000;
		System.out.println("This program calculates first fibonacci number that is bigger than " + limit + " and also a prime");
		long result = primes.doWork(limit);
		System.out.println("\nThe answer is " + ((result != 0) ? result : " N.A"));
	}
}
