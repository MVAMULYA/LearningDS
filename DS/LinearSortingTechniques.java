/*
 * Linear Sorting Techniques:
 * BruteForce
 * BubbleSort
 * SelectionSort
 * InsertionSort
 */

public class LinearSortingTechniques {

	public static void main(String a[]) {
		Integer ar[] = {1,2,3,4,-1,-2,8,6,4,5};
	/*	doBruteForceSort(ar);
		display(ar, "BruteForce");
		doBubbleSort(ar);
		display(ar, "BubbleSort");*/
		/*doSelectionSort(ar);
		display(ar, "SelectionSort");*/
		/*doInsertionSort(ar);
		display(ar, "InsertionSort");*/
		LinearSortingTechniques l = new LinearSortingTechniques();
		l.doBruteForceSort(ar);
		display(ar, "BruteForce");
	}
	
	public void doBruteForceSort(Integer ar[]) {
		int i,j;
		for (i=0; i<=ar.length-2; i++) {
			for (j=i+1;j<=ar.length-1;j++) {
				if(ar[i]>ar[j]) {
					swap(ar, i, j);
				}
			}
		}	
	}
	
	public static void doBubbleSort(Integer ar[]) {
		int i,j;
		boolean swapped=true;
		for (i=0; i<ar.length && swapped; i++) {
			swapped=false;
			for (j=0;j<ar.length-1;j++) {				 
				if(ar[j]>ar[j+1]) {					
					swap(ar, j);	
					swapped=true;
				}				 
			}
		}	
	}
	
	public static void doSelectionSort(Integer ar[]) {
		int i=0, j,min ;
		for(i=0;i<=ar.length-2;i++)
		{		
			 min=i;
			for(j=i;j<=ar.length-1;j++)
			{
				if(ar[j]<ar[min]) 
				{
					min=j ;
				}
			}			
			
			if (i!=min) {
				swap(ar,min,i);
			}
		}
		
	}
	
/*	public static void doSelectionSort(Integer ar[])
	{
		int i,j,min;
		for(i=0;i<=ar.length-1;i++)
		{
			min=ar[i];
			int k=i;		
			for(j=i+1; j<=ar.length-1;j++)
			{
				if(ar[j]<min)
				{
					min=ar[j];
					k=j;
				}				
			}			
			ar[k]= ar[i];
			ar[i]=min;
		}
	}*/
	
	
	public static void doInsertionSort(Integer ar[]) {

	
		int i,j,temp;
				
		for (i=1;i<=ar.length-1;i++)
		{
			temp=ar[i];
			j=i;
			while(j>=1 && temp<ar[j-1])
			{
				ar[j] =ar[j-1];
				j--;
			}
			ar[j] = temp;
			
		}
		
	}

	
	public static void display(Integer ar[], String typeOfSort) {
		System.out.println("Sorting Mechanism:::" + typeOfSort);
		for (int a1 : ar) {
			System.out.print(a1);	
		}
	}
	
	public static void swap(Integer ar[], int i, int j) {
		int temp;
		temp=ar[j];
		ar[j]=ar[i];
		ar[i]=temp;
	}

	public static void swap(Integer ar1[], int j) {
		int temp;
		temp=ar1[j+1];
		ar1[j+1]=ar1[j];
		ar1[j]=temp;;
	}
}
