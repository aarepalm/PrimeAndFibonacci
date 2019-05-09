class PrimesAndFibonacci {

	private long n1 = 0, n2 = 1, n3 = 0;
	private final static long limit = 500000;
	private final long LUDICROUSLY_BIG_NUMER = 500000000;
	private final boolean RESET_STATE = false;
	private final boolean KEEP_STATE = false;

	private boolean isPrime(long integer) {
		for (long i = 2; i < integer; ++i) {
			if ((integer % i) == 0) {
				return false;
			}
		}
		return true;
	}

	private long getNextFibonacci(boolean reset) {
		if (reset == true) {
			n1 = 0;
			n2 = 1;
			n3 = 0;
		}
		n3 = n1 + n2;
		System.out.print(" " + n3);
		n1 = n2;
		n2 = n3;
		return n3;
	}

	private boolean foundTheOne(long number) {
		if ((number > limit) && (isPrime(number)))
			return true;
		else
			return false;
	}

	private long doWork() {
		long result = 0;
		long fiboNumber = getNextFibonacci(RESET_STATE);
		while (fiboNumber < LUDICROUSLY_BIG_NUMER) // So we wouldn't be hanging here, prime check takes long time
		{
			if (foundTheOne(fiboNumber)) {
				result = fiboNumber;
				break;
			}
			fiboNumber = getNextFibonacci(KEEP_STATE);
		}
		return result;
	}

	public static void main(String[] args) {
		PrimesAndFibonacci primes = new PrimesAndFibonacci();
		System.out.println("This program calculates first fibonacci number that is bigger than " + limit + " and also a prime");
		long result = primes.doWork();
		System.out.println("\nThe answer is " + ((result != 0) ? result : " N.A"));
	}
}
