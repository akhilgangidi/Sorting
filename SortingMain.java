import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class SortingMain 
{
	static int insertionMove = 0;
	public static int insertionSort(int array[])
	{
		int comparisons = 0;
		int n = array.length;
		for(int i = 1; i < n; ++i)
		{
			int key = array[i];
			int j = i - 1;
			
			comparisons++;
			while(j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
				insertionMove++;
				comparisons++;
			}
			comparisons++;
			array[j + 1] = key;
		}
		return comparisons;
	}
	static int selectionMove = 0;
	public static int selectionSort(int array[])
	{
		int comparisons = 0;
		int n = array.length;
		
		for(int i = 0; i < n - 1; i++)
		{
			int minIndex = i;
			for(int j = i + 1; j < n; j++)
			{
				comparisons++;
				if(array[j] < array[minIndex])
				{
					minIndex = j;
					selectionMove++;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
			
		}
		return comparisons;
	}
	static int quickMove = 0;
	static int quickComparisons = 0;
	public static void quickSort(int array[], int x, int y) 
	  {
	    int i = x;
	    int j = y;
	    int v;
	    int temp;

	    v = array[(x+y) / 2];
	    while (i <= j)
	    {
	        while (array[i] < v)
	            i++;
	        
	        while (array[j] > v)
	            j--;
	        
	        if (i<=j)
	        {
	            temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	            
	            i++;
	            j--;
	            
	            quickMove++;
	        }
	        quickComparisons++;
	    }
	    
	    if (x < j)
	        quickSort(array, x, j);
	    if (i < y)
	        quickSort(array, i, y);
	 }
	static int mergeComparisons = 0;
	static int mergeMove = 0;
	public static void merge(int array[], int l, int m, int r)
	{
		int i, j, k; 
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for(i = 0; i < n1; ++i)
			left[i] = array[l + i];
		for(j = 0; j < n2; ++j)
			right[j] = array[m + 1 + j];
		i = 0;
		j = 0; 
		k = l; 
		
        while (i < n1 && j < n2) 
        { 
        	
            if (left[i] <= right[j]) 
            { 
            	mergeComparisons++;
                array[k] = left[i]; 
                i++;
                mergeMove++;
            } 
            else
            { 
            	mergeComparisons++;
                array[k] = right[j]; 
                j++; 
                mergeMove++;
            } 
            k++; 
        }
        
        while (i < n1) 
        { 
        	mergeComparisons++;
            array[k] = left[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
        	mergeComparisons++;
            array[k] = right[j]; 
            j++; 
            k++; 
        } 
	}
	public static int mergeSort(int array[], int l, int r)
	{
		if(l < r)
		{
			
			int m = (l + (r-1))/2;
			
			mergeSort(array, l, m);
			mergeSort(array, m + 1, r);
			
			merge(array, l, m, r);
		}
		return mergeComparisons;
	}
	
	static int heapComparisons = 0;
	static int heapMoves = 0;
	public static void heapify(int array[], int n, int i) 
    { 
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
  
         
        if (l < n && array[l] > array[largest]) 
        {
            largest = l; 
            heapComparisons++;
        }
       
        if (r < n && array[r] > array[largest]) 
        {
        	heapComparisons++;
            largest = r; 
        }
        
        if (largest != i) 
        { 
        	heapMoves++;
            int swap = array[i]; 
            array[i] = array[largest]; 
            array[largest] = swap; 
            heapify(array, n, largest); 
        } 
    } 
	public static void heapSort(int array[]) 
    { 
        int n = array.length; 
  
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(array, n, i); 
  
        for (int i=n-1; i>=0; i--) 
        { 
            heapMoves++;
            int temp = array[0]; 
            array[0] = array[i]; 
            array[i] = temp; 
           
            heapify(array, i, 0); 
        } 
    } 
	static int radixMoves = 0;
	public static int getMax(int arr[], int n) 
	    { 
	        int max = arr[0]; 
	        for (int i = 1; i < n; i++) 
	            if (arr[i] > max) 
	                max = arr[i]; 
	        return max; 
	    } 
	  
	public static void countSort(int array[], int n, int exp) 
	    { 
	        int output[] = new int[n]; // output array 
	        int i; 
	        int count[] = new int[10]; 
	        Arrays.fill(count,0); 
	  
	        for (i = 0; i < n; i++) 
	        {
	            count[(array[i]/exp) % 10]++; 
	        }

	        for (i = 1; i < 10; i++) 
	            count[i] += count[i - 1]; 
	   
	        for (i = n - 1; i >= 0; i--) 
	        {
	        	radixMoves++;
	            output[count[(array[i]/exp) % 10] - 1] = array[i]; 
	            count[(array[i]/exp) % 10]--; 
	        } 
 
	        for (i = 0; i < n; i++) 
	            array[i] = output[i]; 
	    } 

	public static void radixsort(int arr[], int n) 
	    { 
	        int m = getMax(arr, n); 
	  
	        for (int exp = 1; m/exp > 0; exp *= 10) 
	        {
	        	countSort(arr, n, exp); 
	        	radixMoves++;
	        }
	            
	    } 
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int elements;
		
		System.out.print("Please enter a number for the elements of the array: ");
		elements = scan.nextInt();
		
		boolean arrayLoop = true;
		
		int array[] = new int[elements];
		
		while(arrayLoop == true)
		{
			System.out.println("\nPlease select the type of array you want");
			System.out.println("1. In Order");
			System.out.println("2. Reverse Order");
			System.out.println("3. Random Order");
			System.out.println("4. Almost Order");
			System.out.println("0. Exit");

			int choice = scan.nextInt();
			if(choice == 1)
			{
				System.out.println("Creating a in order array with " + elements + " elements...");
				System.out.println();
				
				long randStartTime = System.nanoTime();
				for(int i = 0; i < elements; i++)
				{
					array[i] = i+1;
				}
				long randEndTime = System.nanoTime();
				long randDuration = (randEndTime - randStartTime);
				System.out.print("In Order Array: ");
				for(int i = 0; i < array.length; i++)
					System.out.print(array[i] + " ");
				System.out.println("\n");
				System.out.println("In order array generation took " + randDuration + "ns\n");
				arrayLoop = false;
			}
			else if(choice == 2)
			{
				System.out.println("Creating a reverse order array with " + elements + " elements...");
				System.out.println();
				
				long randStartTime = System.nanoTime();
				int reverseOrder = elements;
				for(int i = 0; i < elements; i++)
				{
					array[i] = reverseOrder--;
				}
				long randEndTime = System.nanoTime();
				long randDuration = (randEndTime - randStartTime);
				System.out.print("Reverse Order Array: ");
				for(int i = 0; i < array.length; i++)
					System.out.print(array[i] + " ");
				System.out.println("\n");
				System.out.println("Reverse order array generation took " + randDuration + "ns\n");
				arrayLoop = false;
			}
			else if(choice == 3)
			{
				System.out.println("Creating a random array with " + elements + " elements...");
				System.out.println();
			
				int MAX_RAND = 100;
				long randStartTime = System.nanoTime();
				for(int i = 0; i < elements; i++)
					array[i] = rand.nextInt(MAX_RAND);
				long randEndTime = System.nanoTime();
				long randDuration = (randEndTime - randStartTime);
				
				System.out.print("Random Array: ");
				for(int i = 0; i < array.length; i++)
					System.out.print(array[i] + " ");
				System.out.println("\n");
				System.out.println("Random array generation took " + randDuration + "ns\n");
				arrayLoop = false;
			}
			else if(choice == 4)
			{
				System.out.println("Creating a almost order array with " + elements + " elements...");
				System.out.println();
				
				long randStartTime = System.nanoTime();
				for(int i = 0; i < elements/2; i++)
				{
					array[i] = i + 1;
				}
				int MAX_RAND = 100;
				for(int j = elements/2; j < elements; j++)
				{
					array[j] = rand.nextInt(MAX_RAND);
				}
				long randEndTime = System.nanoTime();
				long randDuration = (randEndTime - randStartTime);
				System.out.print("Almost Order Array: ");
				for(int i = 0; i < array.length; i++)
					System.out.print(array[i] + " ");
				System.out.println("\n");
				System.out.println("Almost order array generation took " + randDuration + "ns\n");
				arrayLoop = false;
			}
			else if(choice == 0)
			{
				System.exit(0);
			}
			else
				System.out.println("\nPlease choose a valid choice\n");
		}
		
		boolean loop = true;
		while(loop == true)
		{
			System.out.println("Please choose a sorting algorithm!");
			System.out.println("1. Insertion Sort");
			System.out.println("2. Selection Sort");
			System.out.println("3. Quick Sort");
			System.out.println("4. Merge Sort");
			System.out.println("5. Heap Sort");
			System.out.println("6. Radix Sort");
			System.out.println("7. Calculate Winning Algorithm");
			System.out.println("0. Exit");
			System.out.println();
			System.out.print("Please enter a choice: ");
			int choice2 = scan.nextInt();
			
			if(choice2 == 1)
			{
				int sortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					sortArray[i] = array[i];
				
				long startTime = System.nanoTime();
				int comparisons = insertionSort(sortArray);
				long endTime = System.nanoTime();
				
				long duration = (endTime - startTime);
				
				System.out.println();
				System.out.println("Sorting Algorithm: Insertion Sort");
				System.out.println("Elements: " + sortArray.length);
				System.out.println("Time: " + duration + "ns");
				System.out.println("Comparisons: " + comparisons);
				System.out.println("Movements: " + insertionMove);
				System.out.print("Sorted Array: ");
				for(int i = 0; i < sortArray.length; i++)
					System.out.print(sortArray[i] + " ");
				System.out.println();
				System.out.println();
				insertionMove = 0;
			}
			else if(choice2 == 2)
			{
				
				int sortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					sortArray[i] = array[i];
				
				long startTime = System.nanoTime();
				int comparisons = selectionSort(sortArray);
				long endTime = System.nanoTime();
				
				long duration = (endTime - startTime);
				
				
				System.out.println();
				System.out.println("Sorting Algorithm: Selection Sort");
				System.out.println("Elements: " + sortArray.length);
				System.out.println("Time: " + duration + "ns");
				System.out.println("Comparisons: " + comparisons);
				System.out.println("Movements: " + selectionMove);
				System.out.print("Sorted Array: ");
				for(int i = 0; i < sortArray.length; i++)
					System.out.print(sortArray[i] + " ");
				System.out.println();
				System.out.println();
				selectionMove = 0;
			}
			else if(choice2 == 3)
			{
				int sortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					sortArray[i] = array[i];
				
				long startTime = System.nanoTime();
				quickSort(sortArray, 0, (sortArray.length - 1));
				long endTime = System.nanoTime();
				
				long duration = (endTime - startTime);
				
				System.out.println();
				System.out.println("Sorting Algorithm: Quick Sort");
				System.out.println("Elements: " + sortArray.length);
				System.out.println("Time: " + duration + "ns");
				System.out.println("Comparisons: " + quickComparisons);
				System.out.println("Movements: " + quickMove);
				System.out.print("Sorted Array: ");
				for(int i = 0; i < sortArray.length; i++)
					System.out.print(sortArray[i] + " ");
				System.out.println();
				System.out.println();
				quickComparisons = 0;
				quickMove = 0; 
			}
			else if(choice2 == 4)
			{
				mergeComparisons = 0;
				int sortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					sortArray[i] = array[i];
				long startTime = System.nanoTime();
				int comparisons = mergeSort(sortArray, 0, (sortArray.length - 1));;
				long endTime = System.nanoTime();
				
				long duration = (endTime - startTime);
				
				System.out.println();
				System.out.println("Sorting Algorithm: Merge Sort");
				System.out.println("Elements: " + sortArray.length);
				System.out.println("Time: " + duration + "ns");
				System.out.println("Comparisons: " + comparisons);
				System.out.println("Movements " + mergeMove);
				System.out.print("Sorted Array: ");
				for(int i = 0; i < sortArray.length; i++)
					System.out.print(sortArray[i] + " ");
				System.out.println();
				System.out.println();
				mergeMove = 0;
			}
			else if(choice2 == 5)
			{
				int sortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					sortArray[i] = array[i];
				long startTime = System.nanoTime();
				heapSort(sortArray);
				long endTime = System.nanoTime();
				
				long duration = (endTime - startTime);
				
				System.out.println();
				System.out.println("Sorting Algorithm: Heap Sort");
				System.out.println("Elements: " + sortArray.length);
				System.out.println("Time: " + duration + "ns");
				System.out.println("Comparisons: " + heapComparisons);
				System.out.println("Movements " + heapMoves);
				System.out.print("Sorted Array: ");
				for(int i = 0; i < sortArray.length; i++)
					System.out.print(sortArray[i] + " ");
				System.out.println();
				System.out.println();
				heapComparisons = 0;
				heapMoves = 0;
			}
			else if(choice2 == 6)
			{
				int sortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					sortArray[i] = array[i];
				long startTime = System.nanoTime();
				radixsort(sortArray, sortArray.length);
				long endTime = System.nanoTime();
				
				long duration = (endTime - startTime);
				
				System.out.println();
				System.out.println("Sorting Algorithm: Radix Sort");
				System.out.println("Elements: " + sortArray.length);
				System.out.println("Time: " + duration + "ns");
				System.out.println("No comparisons in Radix Sort");
				System.out.println("Movements " + radixMoves);
				System.out.print("Sorted Array: ");
				for(int i = 0; i < sortArray.length; i++)
					System.out.print(sortArray[i] + " ");
				System.out.println();
				System.out.println();
				radixMoves = 0;
			}
			else if(choice2 == 7)
			{
				int insertionSortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					insertionSortArray[i] = array[i];
				
				long insertionStartTime = System.nanoTime();
				int insertionComparisons = insertionSort(insertionSortArray);
				long insertionEndTime = System.nanoTime();
				
				long insertionDuration = (insertionEndTime - insertionStartTime);
				
				int selectionSortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					selectionSortArray[i] = array[i];
				
				long selectionStartTime = System.nanoTime();
				int selectionComparisons = selectionSort(selectionSortArray);
				long selectionEndTime = System.nanoTime();
				
				long selectionDuration = (selectionEndTime - selectionStartTime);
				
				int quickSortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					quickSortArray[i] = array[i];
				
				long quickStartTime = System.nanoTime();
				quickSort(quickSortArray, 0, (quickSortArray.length - 1));
				long quickEndTime = System.nanoTime();
				
				long quickDuration = (quickEndTime - quickStartTime);
				
				int mergeSortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					mergeSortArray[i] = array[i];
				
				long mergeStartTime = System.nanoTime();
				int mergeComparisons = mergeSort(mergeSortArray, 0, (mergeSortArray.length - 1));;
				long mergeEndTime = System.nanoTime();
				
				long mergeDuration = (mergeEndTime - mergeStartTime);
				
				int heapSortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					heapSortArray[i] = array[i];
				
				long heapStartTime = System.nanoTime();
				heapSort(heapSortArray);
				long heapEndTime = System.nanoTime();
				
				long heapDuration = (heapEndTime - heapStartTime);
				
				int radixsortArray[] = new int[array.length];
				for(int i = 0; i < array.length; i++)
					radixsortArray[i] = array[i];
				
				long radixStartTime = System.nanoTime();
				radixsort(radixsortArray, radixsortArray.length);
				long radixEndTime = System.nanoTime();
				
				long radixDuration = (radixEndTime - radixStartTime);
				
				if(insertionDuration < selectionDuration 
						&& insertionDuration < quickDuration 
						&& insertionDuration < mergeDuration
						&& insertionDuration < heapDuration
						&& insertionDuration < radixDuration)
				{
					
					System.out.println();
					System.out.println("Winning algorithm: Insertion Sort");
					System.out.println("Elements: " + insertionSortArray.length);
					System.out.println("Time: " + insertionDuration + "ns");
					System.out.println("Comparisons: " + insertionComparisons);
					System.out.println("Movements: " + insertionMove);
					insertionMove = 0;
				}
				else if(selectionDuration < insertionDuration 
						&& selectionDuration < quickDuration 
						&& selectionDuration < mergeDuration
						&& selectionDuration < heapDuration
						&& selectionDuration < radixDuration)
				{
					System.out.println();
					System.out.println("Winning algorithm: Selection Sort");
					System.out.println("Elements: " + selectionSortArray.length);
					System.out.println("Time: " + selectionDuration + "ns");
					System.out.println("Comparisons: " + selectionComparisons);
					System.out.println("Movements: " + selectionMove);
					selectionMove = 0;
				}
				else if(quickDuration < insertionDuration 
						&& quickDuration < selectionDuration 
						&& quickDuration < mergeDuration
						&& quickDuration < heapDuration
						&& quickDuration < radixDuration)
				{
					System.out.println();
					System.out.println("Winning Algorithm: Quick Sort");
					System.out.println("Elements: " + quickSortArray.length);
					System.out.println("Time: " + quickDuration + "ns");
					System.out.println("Comparisons: " + quickComparisons);
					System.out.println("Movements: " + quickMove);
					quickComparisons = 0;
					quickMove = 0; 
				}
				else if(mergeDuration < insertionDuration 
						&& mergeDuration < selectionDuration 
						&& mergeDuration < quickDuration
						&& mergeDuration < heapDuration
						&& mergeDuration < radixDuration)
				{
					System.out.println();
					System.out.println("Winning Algorithm: Merge Sort");
					System.out.println("Elements: " + mergeSortArray.length);
					System.out.println("Time: " + mergeDuration + "ns");
					System.out.println("Comparisons: " + mergeComparisons);
					System.out.println("Movements " + mergeMove);
					mergeMove = 0;
				}
				else if(heapDuration < insertionDuration 
						&& heapDuration < selectionDuration 
						&& heapDuration < quickDuration
						&& heapDuration < mergeDuration
						&& heapDuration < radixDuration)
				{
					System.out.println();
					System.out.println("Winning Algorithm: Heap Sort");
					System.out.println("Elements: " + heapSortArray.length);
					System.out.println("Time: " + heapDuration + "ns");
					System.out.println("Comparisons: " + heapComparisons);
					System.out.println("Movements " + heapMoves);
					heapComparisons = 0;
					heapMoves = 0;
				}
				else if(radixDuration < insertionDuration 
						&& radixDuration < selectionDuration 
						&& radixDuration < quickDuration
						&& radixDuration < mergeDuration
						&& radixDuration < heapDuration)
				{
					System.out.println();
					System.out.println("Sorting Algorithm: Radix Sort");
					System.out.println("Elements: " + radixsortArray.length);
					System.out.println("Time: " +radixDuration + "ns");
					System.out.println("No comparisons in Radix Sort");
					System.out.println("Movements " + radixMoves);
					System.out.println();
					System.out.println();
					radixMoves = 0;
				}
				
			}
			else if(choice2 == 0)
			{
				loop = false;
			}
			else
			{
				System.out.println("\nNot a valid menu choice.\n");
			}
		}
		System.exit(0);
	}
}
