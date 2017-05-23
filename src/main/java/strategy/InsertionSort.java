package strategy;

class InsertionSort implements SortStrategy{

	@Override
	public int[] sort(int[] numbers) {

		int[] sorted = numbers.clone();		// just for values!
		
		for(int i=1; i<sorted.length; i++)
		{
			for(int j = i; j>0 && sorted[j]<sorted[j-1]; j--)
			{
				swap(sorted, j,j-1);
			}
		}
		return sorted;
	}
	
	private void swap(int[] sorted, int index1, int index2)
	{
		int tmp = sorted[index1];
		sorted[index1] = sorted[index2];
		sorted[index2] = tmp;
	}

}
