/**
 * Calvin Low
 * Student #:001294060
 * Lab #: CSI 9298
 * TA Name: Yu Zhang
 * 
 * This program will reverse strings and check for palindromes, the code will first
 * ask the user to enter a string to reverse or "done" to exit. If the user enters a string
 * then the code will use a recursive algorithm and implementation to reverse the string. If
 * the original and reversed strings are the same then the program will indicate that it is a 
 * palindrome. The program will then ask for another string and do the same until the user 
 * enters "done" to exit.
 */

import java.util.Scanner;

public class Module1
{
  /**
   * Recursive method that reverses the inputted string array.
   * 
   * @return
   *  The reversed string.
   */
  public static String[] reverse(String[] line, int start, int end)
  {
    if (start < end) //Recursion will only occur as long as the start is less than the end.
    {
      String holder = line[start]; //Stores the start item in the array.
      line[start] = line[end]; //Swaps the start item for the end item. 
      line[end] = holder; //Sets the end item of the array for the stored item.
      reverse(line, start + 1, end - 1); //Calls the method again (recusion) this time at a diffrent start/end. 
    }
    return line; //returns completed array when finished.
  }
  public static void main(String[] args)
  {
    String origin; //The original inputted string.
    String output; //The reversed string.
    Scanner input1 = new Scanner(System.in); //Asks the user for a string to reverse, "done" to exit.
    System.out.println("Enter a string to reverse, enter 'done' to exit.");
    origin = input1.nextLine(); //Sets the original string. 
    String[] word = origin.split(""); //Creates an array of the original string.
    if (origin.equals("done")) //If the original string is "done" exits the code. 
    {
      System.exit(0); //Exits the code.
    }
    else
    {
      while(origin != "done") //While the user has not entered "done" the code will continue the next ask for string.
      {
        String[] word_2 = reverse(word, 0, word.length - 1); //Creates a new array for the reversed word array.
        int end = origin.length(); //Sets the end value.
        int start = 0; //Sets the start value. 
        output = word_2[start]; //Sets the first letter of the reversed string to avoid errors. 
        start += 1; //Increments the start value to start after 0. 
        while(start != end) //While loop that adds all individual strings from the array into the output.
        {
          output += word_2[start];
          start += 1;
        }
        System.out.println("Original String: ");
        System.out.println(origin);
        System.out.println("Reversed String: ");
        System.out.println(output);
        if (origin.equals(output)) //If the origin and output are the same, it is a palindrome.
        {
          System.out.println("This is a palindrome!");
        }
        input1 = new Scanner(System.in); //Restart the scanner to ask for another string. 
        System.out.println("Enter a string to reverse, enter 'done' to exit.");
        origin = input1.nextLine(); //Sets the origin to the new string. 
        word = origin.split(""); //Sets word to the new origin.
        if (origin.equals("done")) //If the user enters "done" exits the code. 
        {
          System.exit(0);
        }
        
      }
    }
  }
}
