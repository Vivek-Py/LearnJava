class CountingSort{
    public static void sort(int arr[]){
        // first we need the range of the array, you can write code to find it,
        // I'm assuming it is 0 to 1
 
        int range = 1; // this is the range of frequency array
        int freq[] = new int[range + 1]; // remember all the cells are initialized with 0
 
        for (int a : arr) {
            // This is frequency array filling technique
            freq[a]++;
        }
 
        int count = 0; // this variable denotes the current index of the arr to be filled
        for (int i = 0;i <= range;i++) {
            for (int j = 1;j <= freq[i]; j++) {
                arr[count++] = i; // i denotes the element, freq[i] denotes its frequency
            }
        }
    }
 
    /*
       This method prints the array in a single line along with a message passed to it  
    */
    public static void print(int arr[], String message) {
        System.out.println(message);
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
 
    /*
    * This is the driver function, this is where your code execution starts
    * For this example, we have taken a dummy array, you can take input and use it too
    */
    public static void main(String args[]) {
        int []array = {1,0,1,1,1,1,0,0,1,0,1,0,1,1,1,0,0,1,1,0,0,0};
        print(array, "Before sorting:");
        sort(array);
        print(array, "After sorting:");
    }
}
