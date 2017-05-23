package dp_1;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by saba on 23.04.17.
 */
public class SieveOfEratosthenesTest {

    @Test
    public void shouldInitiateSieve() throws Exception {
        int maxValue = 10;
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(maxValue);
        int expectedSizeOfSieveArray = maxValue + 1;

        assertThat(String.format("Expected length of sieve array is %s, but is %s", expectedSizeOfSieveArray, sieve.getSieve().length),
                sieve.getSieve().length, is(expectedSizeOfSieveArray));
        assertFalse("Expected value at index 0 is false", sieve.getSieve()[0]);
        assertFalse("Expected value at index 1 is false", sieve.getSieve()[1]);
        assertTrue("Expected value at index 2 is true", sieve.getSieve()[2]);
        assertTrue("Expected value at index 7 is true", sieve.getSieve()[7]);
        assertTrue("Expected value at index 8 is true", sieve.getSieve()[8]);
        assertTrue("Expected value at last index is true", sieve.getSieve()[maxValue]);

        int maxValue1 = 1;
        SieveOfEratosthenes sieve1 = new SieveOfEratosthenes(maxValue1);
        int expectedSizeOfSieveArray1 = 0;

        assertThat(String.format("Expected length of sieve array is %s, but is %s", expectedSizeOfSieveArray1, sieve1.getSieve().length),
                sieve1.getSieve().length, is(expectedSizeOfSieveArray1));

        int maxValue2 = -1;
        SieveOfEratosthenes sieve2 = new SieveOfEratosthenes(maxValue2);
        int expectedSizeOfSieveArray2 = 0;

        assertThat(String.format("Expected length of sieve array is %s, but is %s", expectedSizeOfSieveArray1, sieve2.getSieve().length),
                sieve2.getSieve().length, is(expectedSizeOfSieveArray2));
    }

    @Test
    public void shouldFilterPrimesFromSieve() throws Exception {
        int maxValue = 5;
        boolean[] expectedFilteredPrimeArray = new boolean[]{false, false, true, true, false, true};
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(maxValue);
        sieve.filter();
        assertThat(String.format("Expected prime array %s, but is %s", Arrays.toString(expectedFilteredPrimeArray), Arrays.toString(sieve.getSieve())),
                sieve.getSieve(), is(expectedFilteredPrimeArray));


        maxValue = 10;
        boolean[] expectedFilteredPrimeArray1 = new boolean[]{false, false, true, true, false, true, false, true, false, false, false};
        SieveOfEratosthenes sieve1 = new SieveOfEratosthenes(maxValue);
        sieve1.filter();
        assertThat(String.format("Expected prime array %s, but is %s", Arrays.toString(expectedFilteredPrimeArray1), Arrays.toString(sieve1.getSieve())),
                sieve1.getSieve(), is(expectedFilteredPrimeArray1));

        maxValue = 2;
        boolean[] expectedFilteredPrimeArray2 = new boolean[]{false, false, true};
        SieveOfEratosthenes sieve2 = new SieveOfEratosthenes(maxValue);
        sieve2.filter();
        assertThat(String.format("Expected prime array %s, but is %s", Arrays.toString(expectedFilteredPrimeArray2), Arrays.toString(sieve2.getSieve())),
                sieve2.getSieve(), is(expectedFilteredPrimeArray2));
    }

    @Test
    public void extractPrimes() throws Exception {
        int maxValue = 5;
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(maxValue);
        sieve.filter();
        int[] primes = sieve.extractPrimes();
        int[] expectedPrimes = new int[]{2, 3, 5};
        assertThat(String.format("Expected primes %s, but is %s", Arrays.toString(expectedPrimes), Arrays.toString(primes)), primes, is(expectedPrimes));

        maxValue = -2;
        SieveOfEratosthenes sieve1 = new SieveOfEratosthenes(maxValue);
        sieve1.filter();
        int[] primes1 = sieve1.extractPrimes();
        int[] expectedPrimes1 = new int[]{};
        assertThat(String.format("Expected primes %s, but is %s", Arrays.toString(expectedPrimes1), Arrays.toString(primes1)), primes1, is(expectedPrimes1));

        maxValue = 2;
        SieveOfEratosthenes sieve2 = new SieveOfEratosthenes(maxValue);
        sieve2.filter();
        int[] primes2 = sieve2.extractPrimes();
        int[] expectedPrimes2 = new int[]{2};
        assertThat(String.format("Expected primes %s, but is %s", Arrays.toString(expectedPrimes2), Arrays.toString(primes2)), primes2, is(expectedPrimes2));

    }

    @Test
    public void getCountOfPrimes() throws Exception {
        int maxValue = 5;
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(maxValue);
        sieve.filter();
        //sieve.extractPrimes();
        int expectedCountOfPrimes = 3;

        assertThat(String.format("Expected count of primes %s, but is %s", expectedCountOfPrimes, sieve.getCountOfPrimes()), sieve.getCountOfPrimes(), is(expectedCountOfPrimes));

    }

    @Test
    public void setMaxValue() throws Exception {

    }

}