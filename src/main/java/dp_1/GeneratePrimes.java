package dp_1;


import java.util.Arrays;

public class GeneratePrimes {

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes(25);
        sieveOfEratosthenes.filterAndPrintPrimesFromSieve();
    }
}


class SieveOfEratosthenes {
    private boolean[] sieve;
    private int maxValue;
    private static final int SMALLEST_PRIME = 2;

    SieveOfEratosthenes(int maxValue) {
        this.maxValue = maxValue;
        sieve = initiateSieve();
    }

    void filterAndPrintPrimesFromSieve() {
        if (sieve.length > 0) {
            filter();
            printPrimes();
        } else {
            System.out.println("No primes found.");
        }
    }

    private boolean[] initiateSieve(){
        if(this.maxValue >= SMALLEST_PRIME) {
            int sizeOfSieveIncludingZero = maxValue + 1;
            boolean[] sieve = new boolean[sizeOfSieveIncludingZero];
            sieve[0] = false;
            sieve[1] = false;
            for (int number = SMALLEST_PRIME; number < sieve.length; number++) {
                sieve[number] = true;
            }
            return sieve;
        }else{
            return new boolean[0];
        }
    }

    void filter() {
            int numberToCross;
            int lastNumberToCheck = (int) Math.sqrt(sieve.length);
            for (int crossedNumber = SMALLEST_PRIME; crossedNumber <= lastNumberToCheck; crossedNumber++) {
                if (sieve[crossedNumber]) {
                    for (numberToCross = 2 * crossedNumber; numberToCross < sieve.length; numberToCross += crossedNumber)
                        sieve[numberToCross] = false;
                }
            }
    }

    int[] extractPrimes() {
        int[] primes;
        int countOfPrimes = getCountOfPrimes();
        if (countOfPrimes > 0) {
            primes = new int[countOfPrimes];
            int indexPrimeArray = 0;
            for (int number = SMALLEST_PRIME; number < sieve.length; number ++) {
                if (sieve[number]) {
                    primes[indexPrimeArray] = number;
                    indexPrimeArray ++;
                }
            }

        } else{
            primes = new int[0];
        }
        return primes;
    }

    int getCountOfPrimes() {
        int countOfPrimes = 0;
        for (boolean crossedNumber : sieve) {
            if (crossedNumber) {
                countOfPrimes++;
            }
        }
        return countOfPrimes;
    }

    private void printPrimes() {
        int[] primes = extractPrimes();
        System.out.println(Arrays.toString(primes));
    }

    boolean[] getSieve() {
        return sieve;
    }
}
