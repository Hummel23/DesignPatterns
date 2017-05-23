package strategy;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;


public class TestSortStrategy {
    private final static int BOUND = 100;

    private static int[] createAndFillArray(int lengthOfArray) {
        Random r = new Random();
        int[] intArray = new int[lengthOfArray];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = r.nextInt(BOUND);
        }
        return intArray;
    }

    private static void print(int[] intArray) {
        System.out.print("[ ");
        for (int i = 0; i < intArray.length - 1; i++) {
            System.out.print(intArray[i] + ", ");
            if (i > 0 && i % 30 == 0) {
                System.out.println();
            }
        }
        if (intArray.length > 0) {
            System.out.print(intArray[intArray.length - 1]);
        }
        System.out.println(" ]");
        System.out.println();
    }

    private enum Select {
        M, B, S, I, Q, MB, MS, MI, MQ, MBS, MBI, MBQ, MSI, MSQ, MIQ, MBSI, MBSQ, MBSIQ,
        BS, BI, BQ, BSI, BSQ, BSIQ, SI, SQ, SIQ, IQ
    }

    public static void main(String[] args) {
        Select select = Select.MBSIQ;

        boolean measure = true;
        Instant start = null, end;
        final int anzNumbers = 1000000;
        int[] numbers = createAndFillArray(anzNumbers);
        int[] sorted;

        start = Instant.now();
        SortStrategy s1 = new MergeSort();
        sorted = s1.sort(numbers);
        if (measure) {
            end = Instant.now();
            System.out.println("MergeSort : " + Duration.between(start, end).toMillis() + " Millisekunden");
        } else print(sorted);

			/*if(measure) start = Instant.now();
            else print(numbers);
			SortStrategy s2 = new BubbleSort();
			sorted = s2.sort(numbers);
			if(measure)
			{
				end = Instant.now();
				System.out.println("BubbleSort : " + Duration.between(start, end).toMillis() + " Millisekunden");
			}
			else print(sorted);*/

        if (measure) start = Instant.now();
        else print(numbers);
        SortStrategy s3 = new SelectionSort();
        sorted = s3.sort(numbers);
        if (measure) {
            end = Instant.now();
            System.out.println("SelectionSort : " + Duration.between(start, end).toMillis() + " Millisekunden");
        } else print(sorted);

        if (measure) start = Instant.now();
        else print(numbers);
        SortStrategy s4 = new InsertionSort();
        sorted = s4.sort(numbers);
        if (measure) {
            end = Instant.now();
            System.out.println("InsertionSort : " + Duration.between(start, end).toMillis() + " Millisekunden");
        } else print(sorted);

        if (measure) start = Instant.now();
        else print(numbers);
        SortStrategy s5 = new QuickSort();
        sorted = s5.sort(numbers);
        if (measure) {
            end = Instant.now();
            System.out.println("QuickSort : " + Duration.between(start, end).toMillis() + " Millisekunden");
        } else print(sorted);
    }

}
