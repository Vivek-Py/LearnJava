
public class Sieve {
	public static void main(String[] args) {
		int i,j,n=100,count=0;
		int a[] = new int[101];
		
		for(i=2;i<=n;i++)
		{
			if(a[i]==0)
			{
				for(j=i*2;j<=n;j+=i)
				{
					a[j]=1;
				}
			}
		}
		for(i=2;i<=n;i++)
		{
			if(a[i]==0){
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.printf("\nTotal number of primes upto %d are: %d", n, count);
	}
}
