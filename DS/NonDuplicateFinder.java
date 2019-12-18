
public class NonDuplicateFinder {
	
	public static void main(String a[])
	{
		int ar[]= {7,7,6,8,8,8,8,9,1,1,4,2,2,3,3,3,5};
		int i;
		i=1;
		System.out.println(ar.length);
		while(i<ar.length)
		{
			if(ar[i] == ar[i-1])
			{
				i++;
				while (i < ar.length && ar[i] == ar[i-1])
				{
					i++;
				}
			}
			else
			{
				System.out.println(ar[i-1]);
			}
			if (i == ar.length-1)
			{
				System.out.println(ar[i]);				
			}
			i++;
		}		
	}

}
