import java.util.Arrays;

public class insertion {

	void sort(int arr[])
	{
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	public static void main(String args[])
	{
		int arr[] = {1,9,0,12,85,6};

		insertion case1 = new insertion();
		case1.sort(arr);
        System.out.println(Arrays.toString(arr));
	}
};
