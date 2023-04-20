import java.util.Arrays;

class selection
{
	void sort(int arr[])
	{
		int n = arr.length;

		for (int i = 0; i < n-1; i++)
		{
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
	public static void main(String args[])
	{
		selection case1 = new selection();
		int arr[] = {0,5,2,1,78,3};
        case1.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
