/**
 * Calvin Low
 * Student #:001294060
 * Lab #: CSI 9298 (Wednesday 8:10 am)
 * TA Name: Yu Zhang
 * Module 5 (Assignment 3)
 * 
 * This porgram will create and search a binary search tree of an occurence data based upon the 2000 census
 * data of babies born that year. The program will prompt the user to enter a name and will search the binary
 * search tree for that name and its occurence data, it will then do one of two things. If the name is in the 
 * tree, the program will return the name, and the number of times it occured in the census data. If the name
 * did not occur, it will report this fact. Either way, the program will return how many nodes it had to visit 
 * in its search. Afterwards the program will repeat the prompt until the name "Exit" or "exit" is given.
 */
import java.util.Scanner;
import java.io.*;

public class Module5 
{
  /**
   * The number of nodes that the search has visited.
   * @param nodes_visited
   *  Number of nodes visited. 
   */
  public static int nodes_visited = 0; 
  
  /**
   * The node class with its respective constructors for building nodes of 
   * the Binary Search tree. 
   */
  public static class Node
  {
    public String names, occurences; //Used to store the names and occurences.
    public Node left, right; //Nodes of leftChild and rightChild.
    public int value; //Value used to keep track of node position for Tree add method. 
    
    /**
     * Constructor for leaf nodes, inspired by Starting Out With Java Text, Page 1339. 
     * 
     * @param value
     *  Value that keeps track of node position for Tree add method.
     * @param nam
     *  Name to be inputted by various methods.
     * @param occ
     *  Occurences to be inputted by various methods.
     */
    Node (int value, String nam, String occ)
    {
      names = nam;
      occurences = occ;
      left = null;
      right = null;
    }
    /**
     * Constructor for non-leaf nodes, inspired by Starting Out With Java Text, Page 1339.
     * 
     * @param value
     *  Value that keeps track of node position for Tree add method.
     * @param nam
     *  Name to be inputted by various methods.
     * @param occ
     *  Ocurrences to be inputted by various methods.
     * @param leftChild
     *  Left Child Node.
     * @ param rightChild
     *  Right Child Node.
     */
    Node (int value, String nam, String occ, Node leftChild, Node rightChild)
    {
      names = nam;
      occurences = occ;
      left = leftChild;
      right = rightChild;
    }
  }
  public static class Tree
  {
    public Node root; //Root Node of the Tree class. 
    
    /**
     * Adds a value to the search Tree, modified to be a void method so that it is compatible with the
     * readFile() method in the readFile class, inspired by Starting Out With Java text, page 1355.
     * 
     * @param val
     *  Keeps track of the position of the Node.
     * @param name
     *  Name to be inputted into various methods.
     * @param occur
     *  Occurences to be inputted into various methods.
     */
    private void add(int val, String name, String occur)
    {
      Node new_node = new Node(val, name, occur); //Creates a new_node incase the root is null or current is null.
      if (root == null)
      {
        root = new_node; //Sets root and the new_node since it is null. 
      }
      else
      {
        Node current = root; //Holds the current root.
        Node previous; //The previous root.
        while(true) //While loop to add to the tree. 
        {
          previous = current; //Sets the previous node to the current node. 
          if(val < current.value)
          {
            current = current.left;
            if (current == null)
            {
              previous.left = new_node; //If current is null set the previous root left child to new_node.
              return;
            }
          }
          else
          {
            current = current.right;
            if (current == null)
            {
              previous.right = new_node; //If current is null set the previous root right child to new_node.
              return;
            }
          }
        }
      }
    }
    /**
     * Searches the binary search tree through recursion, inspired by Contains method in 
     * Starting Out With Java text page 1355.
     * 
     * @param root
     *  The root of the Node.
     * @param input
     *  The String input that nameExists searches for.
     * @return 
     *  Either the input not being found or the input found and the number of times it occured.
     */
    public String nameExists(Node root, String inputs)
    {
      if (root == null) //If the root returns null it means the search could not find the input.
      {
        return "The input was not found!"; 
      }
      if (inputs.equals(root.names)) //If the root was found returns the input and number of times it occured.
      {
        nodes_visited += 1; //Increments the nodes_visited
        return inputs + " found, Number of times it occured: " + root.occurences; 
      }
      if (root.left != null) //If the leftChild is non-null.
      {
        nodes_visited += 1; //Increments the nodes_visited.
        return nameExists(root.left, inputs);
      }
      else //Else the rightChild is non_null. 
      {
        nodes_visited += 1; //Increments the nodes_visted.
        return nameExists(root.right, inputs);
      }
    }
  }
  /**
   * The readFile method in order to scan the text file of the 2000 census 
   * data of babies born that year.
   */
  private static class readFile
  {
    private Scanner names; //Scanner method to keep track of names.
    /**
     * Opens the file that contains the 2000 census data of babies born that year.
     */
    public void openFile()
    {
      try
      {
        names = new Scanner(new File("m6p1Census2000Names.txt"));
      }
      catch (Exception n)
      {
        System.out.println("File not found!");
      }
    }
    /**
     * Reads the file that contains the 2000 census data of babies born that year
     * @param tree
     *  The tree object to be created from reading the file. 
     */
    public void readFile(Tree btree)
    {
      int v = 0;
      while(names.hasNext())
      {
        String babyname = names.next();
        String occurence = names.next();
        btree.add(v, babyname, occurence);
        v++;
      }
    }
  }
 public static void main(String[] args)
 {
   Tree binaryTree = new Tree(); //Creates a new Tree object called "binaryTree".
   readFile read = new readFile(); //Creates a new readFile object to read the text document.
   read.openFile(); //Uses the object to open the already set text document.
   read.readFile(binaryTree); //Reads the text document usin the "binaryTree" object in order to fill it with nodes.
   String name; //Name to be inputted by the user.
   Scanner input1 = new Scanner(System.in); //Scanner for the user input
   System.out.println("Enter a name to search, or enter Exit or exit to end the program");
   name = input1.nextLine(); //Sets the name to the user input.
   if (name.equals("Exit") || name.equals("exit"))
   {
     System.exit(0); //If the user enters Exit or exit the program exits.
   }
   else
   {
     while(name != "Exit" || name != "exit") //While the user does not use either Exit or exit as an input.
     {
       System.out.println(binaryTree.nameExists(binaryTree.root, name)); //Searches binaryTree for the inputted name.
       System.out.println("Number of nodes visited: " + nodes_visited); //Outputs the number of Nodes visited.
       nodes_visited = 0; //Resets the nodes_visited in preparation for the program to repeat.
       System.out.println("Enter a name to search, or enter Exit or exit to end the program");
       input1 = new Scanner(System.in); //Restarts the scanner in preparation for the program to repeat.
       name = input1.nextLine(); //Sets the name to the new user input.
       if (name.equals("Exit") || name.equals("exit")) //If the user enters Exit or exit the program exits.
       {
         System.exit(0); 
       }
     }
   }
 }
}
