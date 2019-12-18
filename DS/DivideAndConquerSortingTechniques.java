
public class DivideAndConquerSortingTechniques {
	public static void main(String a[]) {
		int ar[]= {1,2,3,4,-1,-2,8,6,4,5};
		int n = ar.length;
		//mergeSort(ar,0,n-1);
		quickSort(ar,0,n-1);
		for (int i=0;i<n;i++)
		{
			System.out.print(ar[i]);
		}		
	}

	public static void mergeSort(int ar[],int left, int right) {
		int mid;
		if(left<right)
		{
			mid = (left+right)/2;
			mergeSort(ar,left,mid);
			mergeSort(ar,mid+1,right);
			merge(ar,left,mid,right);
		}
	}

	public static void quickSort(int ar[], int start, int end) {
		if (start < end) {
			int pIndex = partition(ar, start, end);
			quickSort(ar,  start,  pIndex-1);
			quickSort(ar,  pIndex+1,  end);
		}
	}

	private static int partition(int[] ar, int start, int end) {
		// TODO Auto-generated method stub
		int pIndex = start;
		int pivot = ar[end];
		for(int i=start; i< ar.length-1;i++) {
			if(ar[i] <= pivot) {
				swap(ar, i, pIndex);
				pIndex ++ ;				
			}		
		}
		swap(ar, pIndex, end);		
		return pIndex;
	}

	private static void swap(int[] a, int i, int j) {

		int temp = a[j];
		a[j]=a[i];
		a[i]=temp;
	}

	public static void merge(int ar[],int left, int mid, int right) {
		int n1,n2,i,j,k;
		n1=mid-left+1;
		n2=right-mid;
		int arL[] = new int [n1];
		int arR[] = new int [n2];
		for(i=0;i<n1;i++)
		{
			arL[i]=ar[left+i];
		}
		for(j=0;j<n2;j++)
		{
			arR[j]=ar[mid+1+j];			
		}
		i=j=0;
		k=left;
		while(i<n1 && j<n2)
		{
			if(arL[i]<arR[j])
			{
				ar[k]=arL[i];
				i++;
			}
			else
			{
				ar[k]=arR[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			ar[k]=arL[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			ar[k]=arR[j];
			j++;
			k++;
		}

	}

}
