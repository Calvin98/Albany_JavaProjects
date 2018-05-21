/**
 * Calvin Low
 * Student #: 001294060
 * HW_5
 * DUE DATE: November 21, 2017
 * 
 * This program contains the instance field array that stores the inputted string array and the constructor
 * array_initalize that sets the string array field with the input String array. It also contains two
 * methods array_selectionsort and array_search where array_selectionsort sorts the inputted array
 * alphabetically and array_search finds the inputted name that the user wants to find and tries
 * to match it with the list of names in the sorted array. The result for array_search either comes
 * up and true if the method finds a matching name in the list, otherwise it is false. 
 */
public class SortAndSearch 
{
  String[] arrays; //Instance field for the array.
  
  /**
   * Constructor that sets the string array field with the input String array.
   * @param array 
   *   The initial array. 
   */
  
  public void array_initialize(String[] array)
  {
    arrays = array; 
  }
  
  /**
   * Method for sorting, accepts the string array as its arguments, sorts it and returns the sorted array.
   * @return 
   *  Sorted array 
   */
  
  public String array_selectionsort()
  {
    String[] sorted = new String[arrays.length]; //Creates a sorted version of the inputted array.
    String comparable; //String that helps sort the array alphabeticaly. 
    int max = arrays.length; //Sets the maximum array length
    for (int i = 0; i < max; i++) //Loop that fills the array with the sorted names.
        {
            for (int j = i + 1; j < max; j++) 
            {
                if (arrays[i].compareTo(arrays[j])>0) 
                {
                    comparable = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = comparable;
                }
            }
        }
    for (int i = 0; i < max - 1; i++) //Loop that outputs all of sorted names in the array except for the last.
        {
            System.out.println(arrays[i]);
        }
    
    return arrays[max - 1]; //Returns the last name in the sorted array. 
  }
  
  /**
   * Method that returns true if the sorted array contains the inputted name, otherwise it would return false
   * @return 
   *  True or False if the name exists in the sorted array.
   */
  public Boolean array_search(String name)
  {
    int n = 0;
    while (n != arrays.length) //Loop that goes through the entire array to find the matching name. 
    {
      if (arrays[n].equals(name)) //If the matching name is found returns true.
      {
        return true;
      }
      else
      {
        n += 1;
      }
    }
    return false; //Returns false if the matching name is not found. 
  }
}
