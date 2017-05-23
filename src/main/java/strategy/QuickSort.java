package strategy;

class QuickSort implements SortStrategy{

	@Override
	public int[] sort(int[] numbers) {

		int[] sorted = numbers.clone();		// just for values!
		sortQuickSort(sorted, 0, sorted.length-1);
		return sorted;
	}
	
	private void sortQuickSort(int[] sorted, int lo, int hi)
	{
		if(hi<=lo) return;
		int j = partition(sorted, lo, hi);
		sortQuickSort(sorted, lo, j-1);
		sortQuickSort(sorted, j+1, hi);
	}
	
	private int partition(int[] sorted, int lo, int hi)
	{
		int i=lo, j=hi+1;
		int pivotElement = sorted[lo];
		
		while(true)
		{
			while(sorted[++i]<pivotElement) if(i==hi) break;
			while(pivotElement<sorted[--j]) if(j==lo) break;
			if(i>=j) break;
			swap(sorted, i,j);
		}
		swap(sorted, lo, j);
		return j;
	}
	
	private void swap(int[] sorted, int index1, int index2)
	{
		int tmp = sorted[index1];
		sorted[index1] = sorted[index2];
		sorted[index2] = tmp;
	}	
}
