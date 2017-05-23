package strategy;

class SelectionSort implements SortStrategy{

	@Override
	public int[] sort(int[] numbers) {

		int[] sorted = numbers.clone();		// just for values!
		
		for(int index=0; index<sorted.length; index++)
		{
			int minIndex = index;	// Index des kleinsten Elements
			for(int j=index+1; j<sorted.length; j++)
			{
				if(sorted[j]<sorted[minIndex])
				{
					minIndex = j;
				}
			}
			if(index!=minIndex)
			{	
				swap(sorted, index, minIndex);
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
