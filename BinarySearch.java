
public class BinarySearch {

	static boolean bsearch(int[] arr, int x) {
		int low = 0;
		int high = arr.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == x)
				return true;
			if(arr[mid] < x)
				low = mid+1;
			else
				high = mid-1;
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {1, 22, 33, 44, 55, 66, 77, 88, 99, 111};
		boolean found = bsearch(arr, 2);
		System.out.println(found);
	}
}
