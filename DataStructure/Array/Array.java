package DataStructure_and_Algo.DataStructure.Array;

import java.util.Arrays;

public class Array {
	public static void main(String args[]) {
        int arr[] =  {1,2,3,4,5,6};
        rotate(arr,4);
        
        testArrayPassing(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
	
	private static void rotate(int arr[],int d) {
		d = d % arr.length;
		int new_arr[] = new int[arr.length];

		for(int i = arr.length - d, j=0; i<arr.length;i++,j++) {
			new_arr[j] = arr[i];
		}

		for(int i=0; i< arr.length - d; i++) {
			new_arr[d+i] = arr[i]; 
		}
		
		System.out.println("Rotated by "+d+"="+Arrays.toString(new_arr));
		System.out.println("Original="+Arrays.toString(arr));
	}
	
	public static void testArrayPassing(int arr[]) {
		arr[0] = 222;
	}
}
