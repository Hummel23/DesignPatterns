package strategy;

class MergeSort implements SortStrategy{

	@Override
	public int[] sort(int[] numbers) 
	{
		int[] tmp = new int[numbers.length];
		int[] sorted = numbers.clone();		// just for values!
		sortMergeSort(tmp, sorted, 0, numbers.length-1);
		return sorted;
	}
	
	private void sortMergeSort(int[] tmp, int[] sorted, int lo, int hi)
	{
		if(hi<=lo) return;
		int mid = lo+(hi-lo)/2;
		sortMergeSort(tmp, sorted, lo, mid);
		sortMergeSort(tmp, sorted, mid+1, hi);
		merge(tmp, sorted, lo, mid, hi);
	}
	
	private void merge(int[] tmp, int[] sorted, int lo, int mid, int hi)
	{
		int i=lo, j=mid+1;
		for(int k=lo; k<=hi; k++)
		{
			tmp[k] = sorted[k];
		}
		for(int k=lo; k<=hi; k++)
		{
			if(i > mid) 				sorted[k] = tmp[j++];
			else if(j > hi) 			sorted[k] = tmp[i++];
			else if(tmp[j]<tmp[i])	sorted[k] = tmp[j++];
			else 					sorted[k] = tmp[i++];
		}
	}

}
