/**
 * Calvin Low
 * Student #: 001294060
 * HW_5
 * DUE DATE: November 21, 2017
 * 
 * This program asks the user to enter m x n matrix of integers, m and n being the number of 
 * rows and columns, respectively. The program then stores this matrix into a two dimensional
 * m x n array and then uses the three methods Transpose, Minimum and Average. 
 * 
 * Transpose accepts the m x n array as its argument, performs its transpose, and returns
 * the transposed n x m array.
 * 
 * Minimum accepts the ith row of the array as its argument, and returns the minimum of the
 * elements.
 * 
 * Average accepts the jth column of the array as its argument, and returns the average 
 * of the column elements. 
 */
import java.util.Scanner;
import java.lang.Math;

public class HW5_Q1_001294060 
{
  public static void Transpose(int[][] arrays)
  {
    int col = arrays.length; //Columns in the array.
    int row = arrays[0].length; //Rows in the array.
    int start_row = 0; //Start Row to fill.
    int start_col = 0; //Start Column to fill. 
    System.out.println("The transpose is: ");
    while(start_row != row)
     {
      while(start_col != col)
      {
        System.out.println(arrays[start_col][start_row] + "    " + arrays[start_col + 1][start_row] + "    " + arrays[start_col + 2][start_row]); //Prints out each transpose
        start_col = 3;
      }
      start_col = 0;
      start_row += 1;
    }
  }
  public static void Minimum(int[][] arrays)
  {
    int row = arrays.length; //Rows in the array. 
    int col = arrays[0].length; //Columns in the array.
    int start_row = 0; //Start Row to fill.
    int start_col = 1; //Start Columns to fill.
    System.out.println("The minimum of the row of elements:");
    int min; 
    while(start_row != row)
     {
      min = arrays[start_row][0];
      while(start_col != col)
      {
        if (min > arrays[start_row][start_col])
        {
          min = arrays[start_row][start_col];
        }
        start_col += 1;
      }
      start_col = 1;
      start_row += 1;
      System.out.println(min);
    }
  }
  public static void Average(int[][] arrays)
  {
    int col = arrays.length; //Columns in the array.
    int row = arrays[0].length; //Rows in the array.
    int start_row = 0; //Starting row to fill.
    int start_col = 0; //Starting columns to fill.
    int [][] array2 = new int[row][col]; //2d Array to fill. 
    System.out.println("The average of the column elements: ");
    while(start_row != row) //Fills each column and with the correctly transposed array. 
     {
      while(start_col != col)
      {
        array2[start_row][start_col] = arrays[start_col][start_row];
        start_col +=1;
      }
      start_col = 0;
      start_row += 1;
    }
   start_row = 0;
   double addition = 0;
   double average = 0;
   while(start_row != row) //Prepares each row to be averaged and then averages each row. 
   {
     while(start_col != col)
     {
       addition += array2[start_row][start_col];
       start_col += 1;
     }
     average = addition / col;
     average = Math.round(average * 10);
     average = average / 10;
     System.out.print(average + " ");
     average = 0;
     addition = 0; 
     start_col = 0;
     start_row += 1;
   }
  }
  public static void main(String[] args)
  {
  int row; //The rows in the 2d array.
  int col; //The columns in the 2d array. 
  Scanner input1 = new Scanner(System.in); //Scanner for number of rows.
  System.out.println("Enter the number of rows or m in the matrix");
  row = input1.nextInt();
  Scanner input2 = new Scanner(System.in); //Scanner for number of columns. 
  System.out.println("Enter the number of columns or n in the matrix");
  col = input2.nextInt();
  int[][] array = new int[row][col]; //Creates a 2d array to the entered rows and columns specifications.
  int start_col = 0;
  int start_row = 0;
  while (start_row != row) //Inputs values into each row and specfic column. 
  {
    Scanner input3 = new Scanner(System.in); //Scanner for values to be put in each row and columns. 
    System.out.println("Enter the elements in row " + start_row);
    while (start_col != col)
    {
      array[start_row][start_col] = input3.nextInt(); //Fills appopriate row and columns with the entered values. 
      start_col += 1;
    }
    start_col = 0;
    start_row += 1;
  }
  Transpose(array); //Transposes and outputs the finished array.
  Minimum(array); //Outputs the Minimum of each row.
  Average(array); //Outputs the Average of each row. 
  }
}
