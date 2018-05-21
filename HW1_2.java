/**
 * Calvin Low
 * Student #: 001294060
 * HW_1 
 * DUE DATE: September 18, 2017
 */

import javax.swing.JOptionPane;
public class HW1_2 
{
  public static void main (String[] args)
  {
    String name;
    name = JOptionPane.showInputDialog("Enter your name.");
    String year;
    year = JOptionPane.showInputDialog("Enter your year of birth in yyyy format.");
    int result = Integer.parseInt(year);
    int result2 = 0;
    while (result > 0)
    {
      result2 = result2 + result % 10;
      result = result / 10;
    }
    JOptionPane.showMessageDialog(null, name + ": The sum of digits in your year of birth is " + result2);
    
  }
}
