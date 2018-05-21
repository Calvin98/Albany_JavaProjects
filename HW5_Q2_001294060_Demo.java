/**
 * Calvin Low
 * Student #: 001294060
 * HW_5
 * DUE DATE: November 21, 2017
 * 
 * This program opens a given text file containing n names and then reads and stores
 * all these names into a string array. It then asks the user to enter a name to search
 * in the array which will then create an object of the SortAndSearch class and use the sort
 * and search methods on this object. The SortAndSearch method will output a sorted list of
 * the inputted names alphabetically and it will then output "The given name .... exits"
 * if the name is found, or else "The given name .... is not found", if the name dosen't
 * exist in the list. 
 */
import java.io.*;
import java.util.Scanner;

public class HW5_Q2_001294060_Demo 
{
  public static void main(String[] args) throws IOException
  {
    String name; //The filename the user inputs. 
    String search; //Which name to search. 
    int names = 0; //Number of names in the file.
    int start = 0; //Where the scanner starts scanning.
    Scanner input1 = new Scanner(System.in);
    System.out.println("Enter the file name: ");
    name = input1.nextLine();
    File reader = new File(name);
    while (!reader.exists()) //While loop that checks if the file exists, if not the user must enter the correct file.
    {
      System.out.println("File is not found, enter the filename again");
      input1 = new Scanner(System.in);
      name = input1.nextLine();
      reader = new File(name);
    }
    Scanner inputFile = new Scanner(reader); //Scanner for the file. 
    while (inputFile.hasNext()) //Counts how many names are in the file.
    {
      names += 1;
      inputFile.nextLine();
    }
    Scanner inputFile2 = new Scanner(reader); //Scanner for the file.
    String[] array = new String[names]; //initializes an array with the amount of names in the file.
    while (inputFile2.hasNext()) //Fills the array with all names in the file. 
    {
      array[start] = inputFile2.nextLine();
      start += 1;
    }
    Scanner input2 = new Scanner(System.in); //Scanner to search the inputted name. 
    System.out.println("Enter the name to search: ");
    search = input2.nextLine(); //Sets the name to search as the inputted name.
    SortAndSearch find = new SortAndSearch(); //Creates the object SortAndSearch.
    find.array_initialize(array); //Initalizes SortAndSearch with the array.
    System.out.println(find.array_selectionsort()); //Sort the names in the file in alphabetical order. 
    if (find.array_search(search) == true) //See if the given name exists. 
    {
      System.out.println("The given name " + search + " exists.");
    }
    else
    {
      System.out.println("The given name " + search + " is not found.");
    }
  }
}
