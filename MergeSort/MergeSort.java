import java.util.Scanner;

class MergeSort{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] a){
		System.out.println("How many numbers do you want in the array?");
		int size = scan.nextInt();
		int[] array = getIntegers(size);
		sortIntegers(array,0,array.length-1);
		printIntegers(array);
	}

	public static int[] getIntegers(int size){
		int[] array = new int[size];
		System.out.println("Enter "+size+" values:");
		for(int i=0;i<size;i++)
			array[i] = scan.nextInt();
		return array;
	}

	public static void printIntegers(int[] array){
		for(int i=0;i<array.length;i++)
			System.out.printf("%4d",array[i]);
	}

	public static void sortIntegers(int[] array,int left,int right){
		if(right-left > 1){
			int m = (left+right)/2;
			sortIntegers(array,left,m);
			sortIntegers(array,m+1,right);
			merge(array,left,m,right);
		}
		else if(right - left == 1){
			if(array[left] > array[right]){
				array[left] = array[left] + array[right];
				array[right] = array[left] - array[right];
				array[left] = array[left] - array[right];
			}
			else
				return;
		}
		else
			return;
	}

	public static void merge(int array[],int l,int m,int r){
		int leftSubArray[] = new int[m-l+1];
		int rightSubArray[] = new int[r-m];

		//fill these sub arrays with their data
		for(int i=0; i<(m-l+1); i++)
			leftSubArray[i] = array[l + i];
		for(int i=0; i<(r-m); i++)
			rightSubArray[i] = array[m + 1 + i];

		int i=0,j=0;
		int k = l;
		while (i < (m-l+1) && j < (r-m)){
			if (leftSubArray[i] <= rightSubArray[j]){
				array[k] = leftSubArray[i];
				i++;
			}
			else{
				array[k] = rightSubArray[j];
				j++;
			}
			k++;
		}

		while (i < m-l+1){
			array[k] = leftSubArray[i];
			i++;
			k++;
		}

		while (j < r-m){
			array[k] = rightSubArray[j];
			j++;
			k++;
		}
	}
}
