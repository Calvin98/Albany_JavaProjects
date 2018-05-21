/**
 * Calvin Low
 * Student #:001294060
 * Lab #: CSI 9298 (Wednesday 8:10 am)
 * TA Name: Yu Zhang
 * Module 2 (Assignment 2)
 * 
 * This program will compare the behaviors of BubbleSort and QuickSort by generating a random list of
 * integers from 0-99 10 times for both sorting methods.The program will then have both algorithms sort
 * each list and keep track of how many comparisons the sorting algorithms have done for the current list they are 
 * sorting.The program will print the Original List, Sorted List and Number of Comparisons for each list using both 
 * algorithms.Finally the program will print the average of the number of comparisons for both the BubbleSort and 
 * QuickSort of the 10 lists that both algorithms sorted.
 */
import java.util.Random;

public class Module2 
{
  /**
   * The number of comparisons QuickSort does.
   * @param q_comparisons
   *  Number of comparisons for QuickSort. 
   */
  public static int q_comparisons = 0;
  
  /**
   * The number of comparisons BubbleSort does.
   * @param b_comparisons
   *  Number of comparisons for BubbleSort. 
   */
  public static int b_comparisons = 0;
  
  /**
   * The total of all comparisons for QuickSort to average.
   * @param q_average
   *  Total of all comparisons for QuickSort.
   */
  public static int q_average = 0;
  
  /**
   * The total of all comparisons for BubbleSort to average.
   * @param b_average
   *  Total of all comparisons for BubbleSort.
   */
  public static int b_average = 0;
  
  /**
   * Int method that creates a random list of numbers from 0 to 99.
   * 
   * @return
   *  A list of random integers from 0 to 99.
   */
  public static int[] random_list()
  {
    int[] list = new int[100]; //Creates a list the size of 100 for all possible numbers of 0 to 99.
    for (int i = 0; i < list.length; i++) //Uses a for loop to add a random number of 0 to 99 to the current
    {                                     //list position
      list[i] = (int)(Math.random() * 100);
    }
    return list;
  }
  
  /**
   * Method that does BubbleSort, taken from Starting Out With Java text,
   * Page 1072 - 1073. Added a counter for every comparison the BubbleSort does,
   * also added a way to print the Bubble Sorted Order and the Number of Comparisons.
   * Adds the current comparison to the average total to be used later
   * 
   * @param array
   *  The Array to sort. 
   */
  public static void bubbleSort(int[] array)
  {
    int lastPos; //Position of the last element to compare. 
    int index; //Index of an element to compare.
    int temp; //Used to swap elements. 
    for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
    {
      for (index = 0; index <= lastPos - 1; index++)
      {
        if (array[index] > array[index + 1])
        {
          temp = array[index];
          array[index] = array[index + 1];
          array[index + 1] = temp;
          b_comparisons += 1; //Adds to the amount of comparisons currently done by BubbleSort.
        }
      }
    }
    //Prints all sorted values of BubbleSort
    System.out.println("\nBubble Sorted order: ");
    for (int element : array)
    {
      System.out.print(element + " ");
    }
    //Prints the number of comparisons done by BubbleSort.
    System.out.println("\nNumber of comparisons: ");
    System.out.println(b_comparisons);
    b_average += b_comparisons; //Adds the current comparison value to the total average.
    b_comparisons = 0; //Sets the comparison to 0 to start over. 
  }
  /**
   * Method used to swap the values found in any two elements of the array for QuickSort.
   * Accepts an int array, and int a and b which is the position to swap. Taken from Starting Out 
   * With Java text, page 1093.
   * 
   * @param array
   *  Array to swap.
   * @param a
   *  Position to swap.
   * @param b
   *  Position to swap. 
   */
  public static void swap(int[] array, int a, int b)
  {
    int temp; //A temporary value holder used for swapping.
    temp = array[a];
    array[a] = array[b];
    array[b] = temp;
    //q_comparisons += 1;
  }
  
  /**
   * The partition method that accepts an int array, a start value and an end value to create a partition
   * for QuickSort Taken from Starting Out With Java text, Page 1091. Added a counter that adds how many 
   * comparisons the code has done for Quick Sort.
   * 
   * @return
   *  endofLeftList (The Partition). 
   */
  public static int partition(int array[], int start, int end)
  {
    int pivotValue; //The pivotValue to compare.
    int endofLeftList; //The end of the Left List.
    int mid; //The middle value.
    mid = (start + end) / 2;
    swap(array, start, mid);
    pivotValue = array[start];
    endofLeftList = start;
    for (int scan = start + 1; scan <= end; scan++)
    {
      if (array[scan] < pivotValue)
      {
        endofLeftList++;
        swap(array, endofLeftList, scan);
      } 
      q_comparisons +=1; //Adds the amount of comparisons currently done for QuickSort.
    }
    swap(array, start, endofLeftList); //Uses the Swap method for QuickSort.
    return endofLeftList; //Returns the endofLeftList. 
  }
  
  /**
   * Part of the QuickSort method that accepts an int array, a start value and an end value
   * to be sorted using the Partition method and recursion. Taken from Starting Out With Java
   * text, page 1091.
   * 
   * @param array
   *  The array to sort.
   * @param start
   *  The start value to sort.
   * @param end
   *  The end value to sort. 
   */
  public static void doQuickSort(int[] array, int start, int end)
  {
    int pivotPoint; //The Pivot Point value used for QuickSort.
    
    if (start < end)
    {
      pivotPoint = partition(array, start, end);
      doQuickSort(array, start, pivotPoint - 1);
      doQuickSort(array, pivotPoint + 1, end);
    }
  }
  
  /**
   * Part of the QuickSort method that accepts an int array to be sorted using the method 
   * doQuickSort. Taken from Starting Out With Java text, page 1090. Added a way to print 
   * the Quick Sorted Order and the Number of Comparisons. Adds the current comparison
   * total to the average total to be used later.
   * 
   * @param array
   *  The Array to sort. 
   */
  public static void quickSort(int[] array)
  {
    doQuickSort(array, 0, array.length - 1); //Uses the doQuickSort method with the inputted array.
    //Prints all integers of the list sorted using QuickSort.
    System.out.println("\nQuick Sorted order: ");
    for (int element : array)
    {
      System.out.print(element + " ");
    }
    //Prints the number of comparisons done by QuickSort.
    System.out.println("\nNumber of comparisons: ");
    System.out.println(q_comparisons);
    q_average += q_comparisons; //Adds the current comparison value to the total average of comparisons of Quicksort.
    q_comparisons = 0; //Sets comparisons for QuickSort to 0, to start over. 
  }
  
  public static void main(String[] args)
  {
    int i = 1; //Iterator for BubbleSort.
    int t = 1; //Iterator for QuickSort.
    
    //10 Lists of Random Values from 0-99 used for QuickSort.
    int[] values = random_list(); 
    int[] values2 = random_list(); 
    int[] values3 = random_list();
    int[] values4 = random_list();
    int[] values5 = random_list();
    int[] values6 = random_list();
    int[] values7 = random_list();
    int[] values8 = random_list();
    int[] values9 = random_list();
    int[] values10 = random_list();
    
    //10 List of Random Values from 0-99 used for BubbleSort, copied from previous list to avoid errors.
    int[] values11 = values;
    int[] values12 = values2;
    int[] values13 = values3;
    int[] values14 = values4;
    int[] values15 = values5;
    int[] values16 = values6;
    int[] values17 = values7;
    int[] values18 = values8;
    int[] values19 = values9;
    int[] values20 = values10;
    
    
    //Uses a while loop to output all 10 sorted lists for BubbleSort and Quick Sort and comparisons.
    while (i != 11)
    {
      System.out.println("Original Unsorted Row " + i + ": ");
      if (i == 1)
      {
        for (int element : values)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values11);
        quickSort(values);
      }
      else if (i == 2)
      {
        for (int element : values2)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values12);
        quickSort(values2);
      }
      else if (i == 3)
      {
        for (int element : values3)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values13);
        quickSort(values3);
      }
      else if (i == 4)
      {
        for (int element : values4)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values14);
        quickSort(values4);
      }
      else if (i == 5)
      {
        for (int element : values5)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values15);
        quickSort(values5);
      }
      else if (i == 6)
      {
        for (int element : values6)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values16);
        quickSort(values6);
      }
      else if (i == 7)
      {
        for (int element : values7)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values17);
        quickSort(values7);
      }
      else if (i == 8)
      {
        for (int element : values8)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values18);
        quickSort(values8);
      }
      else if (i == 9)
      {
        for (int element : values9)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values19);
        quickSort(values9);
      }
      else if (i == 10) 
      {
        for (int element : values10)
        {
          System.out.print(element + " ");
        }
        System.out.println();
        bubbleSort(values20);
        quickSort(values10);
      }
      i++;
      System.out.println();
    }
    //Prints the Average number of BubbleSort.
    System.out.println("\nBubble Sort Average: ");
    System.out.println(b_average / 10);
    System.out.println();
    //Prints the Average number of QuickSort.
    System.out.println("\nQuick Sort Average: ");
    System.out.println(q_average / 10);
    System.out.println();
  }
}
