package e2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.println(steppingStones(3));
	}
	
	
	public static int pow(int x, int p) {
		if(p == 0)
			return 1;
		if(p % 2 == 0) {
			return (int) Math.pow(pow(x, p/2), 2);
		} else {
			return (int) (x * Math.pow(pow(x, (p-1)/2), 2));
		}
	}
	
	
	
	/**
	 * 
	 * @param distance The distance from the last tile
	 * @return The number of different ways Beatrice can jump on the tiles
	 */
	public static int steppingStones(int distance) {
		if(distance < 0)
			return 0;
		if(distance == 0)
			return 1;
		
		return steppingStones(distance - 1) + 
				steppingStones(distance - 2) + 
				steppingStones(distance - 3);
	}
	
	/**
	 * Part A Find the average value given an
	 * array of doubles
	 * @param nums
	 * @return
	 */
	public static double average(double[] nums) 
	{
		double total = 0;
		
		for (int index = 0; index < nums.length; index++)
			total += nums[index];

		return total/nums.length;
	}
	
	/**
	 * Part B Given a Sentence Find the longest word
	 * 
	 */
	public static String longestWord(String words)
	{
		Scanner scan = new Scanner(words);
		String longest = "";

		while (scan.hasNext())
		{
			String currentWord = scan.next();
			if (currentWord.length() > longest.length())
			{
				longest = currentWord;
			}
		}
		scan.close();
		return longest;
	}
	
	/**
	 * Part C Given a string, return the string with all 
	 * spaces and non-alphabetic characters replaced by 
	 * the character ‘#’, e.g. “Hello, world!” becomes 
	 * “Hello##world#” 
	 */
	public static String hashTag(String sentence)
	{
		String value = "";
		for (int index = 0; index < sentence.length(); index++)
		{
			if (Character.isAlphabetic(sentence.charAt(index)))
				value += sentence.charAt(index);
			else
				value += '#';
		}
		return value;
	}
	
	/**
	 * Part D 
	 * Interest is added to the balance of a savings account 
	 * each month.  Write a method that, given an annual interest 
	 * rate and an initial balance, determines how many months 
	 * it takes for the balance to double.
	 */
	public static int doubleBalance(int balance, double interest)
	{
		double monthlyInterest = interest / 12;
		int months = 0;
		double current = balance;
		
		while (current < balance * 2)
		{
			current = current + (current * monthlyInterest);
			months++;
		}
		return months;
	}
	
	/**
	 * Part E
	 * Given an ArrayList of Integers, determine whether they are in increasing order
	 */
	public static boolean isIncreasing(ArrayList<Integer> nums)
	{
		for (int index = 0; index < nums.size() - 1; index++) {
			if (!(nums.get(index) < nums.get(index + 1)))
				return false;
		}
	
		return true;
	}
	
	/**
	 * Part F
	 * Given a string, return the index of the first vowel (or -1 if there are none). 
	 */
	public static int firstVowel(String words)
	{
		for (int index = 0; index < words.length(); index++)
		{
			if("AEIOUaeiou".indexOf(words.charAt(index)) != -1)
				return index;
		}
		return -1;
	}
	
	/**
	 * Part G
	 * Given a string, determine whether any letter appears two or more times
	 */
	public static boolean hasDuplicateLetters(String letters)
	{
		for (int i = 0; i < letters.length() - 1; i++)
			for (int j = i + 1; j < letters.length(); j++)
				if (letters.charAt(i) == letters.charAt(j))
					return true;
		
		return false;
	}
	
	/**
	 * Part H
	 * Given an array of ints, reverse its contents 
	 * (the method must modify the given array and returns void)
	 */
	public static void reverseArray(int[] arr)
	{
		for (int i = 0; i < arr.length/2; i++)
		{
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}
	
	/**
	 * Part I
	 * Given an array of integers, determine whether the 
	 * array is a permutation of the numbers 0 through n – 1, 
	 * where n is the length of the array.  
	 * (A permutation means that each number appears exactly once)
	 */
	public static boolean isPerm(int[] arr)
	{
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++)
			if(arr[i] != i)
				return false;
		return true;
	}
	
	/**
	 * Part J
	 * Given a number n, print out a reverse
	 * diagonal line of n stars
	 */
	public static void reverseStars(int n)
	{
		while(n > 0)
		{
			for (int i = 0; i < n - 1; i++)
				System.out.print(" ");
			
			System.out.print("*\n");
			n--;
		}
	}
	
	/**
	 * Part K
	 *  Given a 2D array of doubles, 
	 *  return a 1D array whose ith entry 
	 *  is the average of the ith column. 
	 *  
	 *  arr[row][col]
	 */
	public static double[] averageValues (double[][] arr)
	{
		double[] avgs = new double[arr[0].length];
		
		for (int col = 0; col < avgs.length; col++)
		{
			double colTotal = 0;
			for (int row = 0; row < arr.length; row++)
			{
				colTotal += arr[row][col];
			}
			avgs[col] = (colTotal / arr.length);
		}
		return avgs;
	}
	
	/**
	 * Part L
	 * Given a 2D array of Doubles
	 * Find the column with the maximum sum
	 */
	public static int maxCol(double[][] arr)
	{
		double[] sums = new double[arr[0].length];
		
		for (int col = 0; col < sums.length; col++) {
			double colTotal = 0;
			for (int row = 0; row < arr.length; row++)
				colTotal += arr[row][col];
			
			sums[col] = colTotal;
		}
		int maxIndex = 0;
		double maxVal = 0;
		for (int i = 0; i < sums.length; i++) {
			if(sums[i] > maxVal) {
				maxIndex = i;
				maxVal = sums[i];
			}
		}
		return maxIndex;
	}
	
	/**
	 * Part M
	 *  Given positive integers w and h and an int[] array 
	 *  array of length w * h, return a 2d array with h rows 
	 *  and w columns that contains the numbers in arr, 
	 *  listed left-to-right and top-to-bottom. 
	 */
	public static int[][] to2DArray(int[] arr, int height, int width)
	{
		int[][] values = new int[height][width];
		int index = 0;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				values[row][col] = arr[index];
				index++;
			}
		}
		return values;
	}
	
	/**
	 * Part N 
	 *  return smallest prime number that is larger than n
	 */
	private static int nextPrime(int n)
	{
		for (int i = n + 1; i < 2*n; i++)
		{
			if(isPrime(n)) {
				return n;
			}
		}
		return 0;
	}
	
	/**
	 * Helper for Part N
	 *  return true if candidatePrime is prime
	 */
	public static boolean isPrime(int candidatePrime)
	{
		boolean isPrime = true;
		if (candidatePrime <= 1) 
			return false;
		if (candidatePrime <= 3) 
			return true;
		if (candidatePrime % 2 == 0) 
			return false;
		if (candidatePrime < 9) 
			return true;
		int limit = (int) Math.sqrt((double) candidatePrime);
		for (int i = 5; i < limit; i+=6)
		{
			if (candidatePrime % i == 0) 
				return false;
			if (candidatePrime % (i+2) == 0) 
				return false;
		}
		return isPrime;	
	}
	
	/**
	 * Part O
	 *
	 * Given an array of positive integers, "collapse" the array to remove 
	 * duplicates, and fill in the unused cells at the end with zeros.  
	 * For example, given the array [5, 4, 5, 6, 4, 2], after this method 
	 * executes the array should be [5, 4, 6, 2, 0, 0].  The method modifies 
	 * the given array, and returns void
	 */
	public static void collapseArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = i + 1; j < arr.length; j++) 
			{
				if(arr[i] == arr[j]) 
					arr[j] = 0;
			}
		}
		
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				
			}
		}
	}
	/**
	 * Part O
	 *
	 * Given an array of positive integers, "collapse" the array to remove 
	 * duplicates, and fill in the unused cells at the end with zeros.  
	 * For example, given the array [5, 4, 5, 6, 4, 2], after this method 
	 * executes the array should be [5, 4, 6, 2, 0, 0].  The method modifies 
	 * the given array, and returns void
	 */
	public static int[] removeArray(int[] arr)
	{
		ArrayList<Integer> nonDuplicates = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = i + 1; j < arr.length; j++) 
			{
				if(arr[i] != arr[j]) 
					nonDuplicates.add(i);
			}
		}
		int[] array = new int [nonDuplicates.size()];
		for(int i = 0; i < nonDuplicates.size(); i++) {
			array[i] = nonDuplicates.get(i);
		}
		return arr;
	}

}	
