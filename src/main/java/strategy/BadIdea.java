package strategy;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class BadIdea {
	private int[] intArray;
//	private int[] hilfsArray;
	private enum Sort {
		SELECTIONSORT, MERGESORT, BUBBLESORT, QUICKSORT, INSERTIONSORT
	}

	private final static int BOUND = 100;
	
	private BadIdea(Sort sortStrategy, int lengthOfArray)
	{
		createAndFillArray(lengthOfArray);
		switch(sortStrategy)
		{
			case SELECTIONSORT:
				sortSelectionSort();
				break;
			case MERGESORT:
				sortMergeSort();
				break;
			case BUBBLESORT:
				sortBubbleSort();
				break;
			case QUICKSORT:
				sortQuickSort();
				break;
			case INSERTIONSORT:
				sortInsertionSort();
				break;
			default:
				System.out.println("kein Sortierverfahren");
		}
	}
	
	private void createAndFillArray(int lengthOfArray)
	{
		Random r = new Random();
		intArray = new int[lengthOfArray];
		for(int i=0; i<intArray.length; i++)
		{
			intArray[i] = r.nextInt(BOUND);
		}
	}
	
	private void sortBubbleSort()
	{
		for(int bubble=1; bubble<intArray.length; bubble++)
		{
			for(int index=0; index<intArray.length-bubble; index++)
			{
				if(intArray[index]>intArray[index+1])
				{
					swap(index, index+1);
				}
			}
		}
	}
	
	private void swap(int index1, int index2)
	{
		int tmp = intArray[index1];
		intArray[index1] = intArray[index2];
		intArray[index2] = tmp;
	}
	
	private void sortSelectionSort()
	{
		for(int index=0; index<intArray.length; index++)
		{
			int minIndex = index;	// Index des kleinsten Elements
			for(int j=index+1; j<intArray.length; j++)
			{
				if(intArray[j]<intArray[minIndex])
				{
					minIndex = j;
				}
			}
			if(index!=minIndex)
			{	
				swap(index, minIndex);
			}
		}
	}
	
	private void sortMergeSort()
	{
//		hilfsArray = new int[intArray.length];
		sortMergeSort(0, intArray.length-1);
	}
	
	private void sortMergeSort(int lo, int hi)
	{
		if(hi<=lo) return;
		int mid = lo+(hi-lo)/2;
		sortMergeSort(lo, mid);
		sortMergeSort(mid+1, hi);
//		merge(lo, mid, hi);
	}
	
	/*private void merge(int lo, int mid, int hi)
	{
		int i=lo, j=mid+1;
		for(int k=lo; k<=hi; k++)
		{
			hilfsArray[k] = intArray[k];
		}
		for(int k=lo; k<=hi; k++)
		{
			if(i > mid) 							intArray[k] = hilfsArray[j++];
			else if(j > hi) 						intArray[k] = hilfsArray[i++];
			else if(hilfsArray[j]<hilfsArray[i])	intArray[k] = hilfsArray[j++];
			else 								intArray[k] = hilfsArray[i++];
		}
	}*/
	
	private void sortQuickSort()
	{
		sortQuickSort(0, intArray.length-1);
	}
	
	private void sortQuickSort(int lo, int hi)
	{
		if(hi<=lo) return;
		int j = partition(lo, hi);
		sortQuickSort(lo, j-1);
		sortQuickSort(j+1, hi);
	}
	
	private int partition(int lo, int hi)
	{
		int i=lo, j=hi+1;
		int pivotElement = intArray[lo];
		
		while(true)
		{
			while(intArray[++i]<pivotElement) if(i==hi) break;
			while(pivotElement<intArray[--j]) if(j==lo) break;
			if(i>=j) break;
			swap(i,j);
		}
		swap(lo, j);
		return j;
	}
	
	private void sortInsertionSort()
	{
		for(int i=1; i<intArray.length; i++)
            for (int j = i; j > 0 && intArray[j] < intArray[j - 1]; j--) {
                swap(j, j - 1);
            }
	}
	
/*	public void print()
	{
		System.out.print("[ ");
		for(int i=0; i<intArray.length-1; i++)
		{
			System.out.print(intArray[i]+", ");
			if(i>0 && i%30==0) System.out.println();
		}
		if(intArray.length>0) System.out.print(intArray[intArray.length-1]);
		System.out.println(" ]");
	}*/
	
	public static void main(String[] args) {
		Instant start = Instant.now();
		//BadIdea bi1 = new BadIdea(Sort.SELECTIONSORT, 100000);	// 3081
		Instant end = Instant.now();
		System.out.println("Selectionsort : " + Duration.between(start, end).toMillis() + " Millisekunden");
		//bi1.print();
		
		start = Instant.now();
		//BadIdea bi2 = new BadIdea(Sort.BUBBLESORT, 100000);		// 12958
		end = Instant.now();
		System.out.println("Bubblesort    : " + Duration.between(start, end).toMillis() + " Millisekunden");
		//bi2.print();
		
		start = Instant.now();
		//BadIdea bi3 = new BadIdea(Sort.INSERTIONSORT, 100000);	// 4253
		end = Instant.now();
		System.out.println("Insertionsort : " + Duration.between(start, end).toMillis() + " Millisekunden");
		//bi3.print();
		
		start = Instant.now();
		//BadIdea bi4 = new BadIdea(Sort.MERGESORT, 100000);	// 17
		end = Instant.now();
		System.out.println("Mergesort     : " + Duration.between(start, end).toMillis() + " Millisekunden");
		//bi4.print();

		start = Instant.now();
		//BadIdea bi5 = new BadIdea(Sort.QUICKSORT, 100000);	// 20
		end = Instant.now();
		System.out.println("Quicksort     : " + Duration.between(start, end).toMillis() + " Millisekunden");
		//bi5.print();
	}

}
