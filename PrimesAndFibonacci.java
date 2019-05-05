class PrimesAndFibonacci {

	boolean isPrime(long integer) {
		for (int i = 2; i < integer; ++i) {
			if ((integer % i) == 0) {
				return false;
			}
		}
		return true;
	}

	long getNextPrime(long integer) {
		if (integer < 3)
			return ++integer;

		while (isPrime(++integer) != true) {
			// do nothing here
		}
		return integer;
	}

	long calculatePrime(long limit) {
		boolean notAPrime = false;
		long x = getNextPrime(limit);
		while (x < limit) {
			x = getNextPrime(x);
		}
		return x;
	}

	public static void main(String[] args) {
		PrimesAndFibonacci primes = new PrimesAndFibonacci();
		final long limit = 500000;
		System.out.println("This program calculates first prime and fibonacci bigger than " + limit);
		System.out.println("The prime is " + primes.calculatePrime(limit));
	}
}
