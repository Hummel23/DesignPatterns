package strategy;

class BubbleSort implements SortStrategy{
	
	@Override
	public int[] sort(int[] numbers) {

		int[] sorted = numbers.clone();		// just for values!
		
		for(int bubble=1; bubble<sorted.length; bubble++)
		{
			for(int index=0; index<sorted.length-bubble; index++)
			{
				if(sorted[index]>sorted[index+1])
				{
					swap(sorted, index, index+1);
				}
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
