package Day_7;

import java.util.ArrayList;

public class Remove_Duplicates_From_Sorted_Array {
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int i = 0;
		for(int j=1; j<n; j++){
			if(arr.get(i) != arr.get(j)){
				arr.set(i+1,arr.get(j));
				i++;
			}
		}
		return i+1;
	}
}
