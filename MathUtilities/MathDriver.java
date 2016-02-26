// Library necessary to make use of containers, specifically the hash map
// we are using for our human readable name..
import java.util.*;

public class MathDriver
{
  //------------------------------------------------------
  // Publicly defining these objects which we will use
  // during execution of our program.
  public static Scanner     KeyInput = null;

  // Since these menu's text won't change, let's make it a constant!
  public static final String MENU_TEXT = "Please select what you want to do..\n" +
                                         "  (T)emperature\n" + 
                                         "  (C)ircle Circumference\n" +
                                         "  (S)urface Area\n" +
                                         "  (Q)uadratic Equation\n" +
                                         "  (E)xit";
  
  // Utility function that will ASK user for input ..
  // returns a string representing what the user entered..
  // NOTE: This will convert the string returned to UPPER CASE!
  public static String AskForInput(String outputText)
  {
    // Ask the user for input, and return that value (in upper case)..
    System.out.println(outputText);
    return KeyInput.next().toUpperCase();
  }
  
  //------------------------------------------------------
  // Main entry point of our actual program..
  // This will allow us to ask for this input via the command prompt.. 
  public static void main(String[] args)
  {    
    // Prepare ourselves for use!
    KeyInput = new Scanner(System.in); // Create an instance of our input scanner..
    
    // We will loop until they enter Q, or q, or quit, 
    // or Quagmire, or anything that starts with a Q..
    String menuInput    = ""; boolean validMenu = false;
    do
    {
      //-------------------------------------------------------
      // Step 1: Ensure we know what our main objective is..
      //         This will be the main menu of sorts..
      //         See the globally defined menu above..
      if( !validMenu )
      {
        // Ask the user what they want to do..
        menuInput = AskForInput(MENU_TEXT);
        
        // Note, substring() will start at the first character in the array within the string, and
        // move forward one character.  Effectively getting us the first letter in the string :)
        menuInput = menuInput.substring(0,1);
  
        // If they entered a e, or E or Exit, get out of the loop!
        if( menuInput.equals("E") )
          break; // NOTE: Break will exit the loop we are currently in
        
        // If they entered something, let's ensure it's valid..
        if( !menuInput.equals("T") && !menuInput.equals("C") && !menuInput.equals("S") && !menuInput.equals("Q") )
        {
          // If we don't start with one of these things, they gave us invalid input..
          System.out.println("\nERROR: Invalid input detected.  Please carefully review the options and try again.\n");
          continue; // NOTE: Continue will move on to the next line
        }
        
        validMenu = true;
      }
      
      //-------------------------------------------------------
      // Step 2: EXECUTE whatever they told us to..
      //         If we make it here, we have a valid option, and need to proceed..

      // Now we want to do the actual conversion..
      switch (menuInput)
      {
        case "T":
          Temperature TempCalc = new Temperature();
          TempCalc.Execute(); 
          break;
        case "C":
          Circumference CircleCalc = new Circumference();
          CircleCalc.Execute();
          break;
        case "S":
          SurfaceArea RectangleCalc = new SurfaceArea();
          RectangleCalc.Execute();
          break;
        case "Q":
          QuadraticEquation QuadraticCalc = new QuadraticEquation();
          QuadraticCalc.Execute();
          break;
      }
      
      // Now reset our state machine variables, so we are starting FRESH!
      validMenu = false;
      
    } while( menuInput != "E" );

    // If we get out of the loop, they want to quit..
    // Go ahead and let em!
    System.out.println("\nFIN!\nThank you for stopping by!");
  }

}
