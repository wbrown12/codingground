//************************************************
//* Class SurfaceArea
//*   This class is designed to take input in WIDTH and HEIGHT
//*   and will calculate the perimeter and area of the RECTANGLE
//*
//*   Relevant formula's are:
//*     perimeter of a rectangle is 2(h + w) 
//*     area is hw (that's height times width).
//************************************************
public class SurfaceArea extends MathUtility
{
  // Default constructor will set all values to 0..
  SurfaceArea() { Reset(); }

  //-------------------------
  // Interface Implementation Functions
  //   These are functions that MUST be defined in order to use our
  //   base abstract class, MathUtillity.  This class makes it
  //   much more convenient to push the shared functionality into 
  //   a single class that so it's easier to make other instances of 
  //   classes that do the same thing. :)
  //-------------------------
  
  //----------------------------------------------------
  // Resets variables back to normal..  
  void Reset() { m_perimeter = m_area = 0; }

  //----------------------------------------------------
  // Implement these with dummy values..
  // We won't use them here..
  String  GetMenu()      { return "";   }
  boolean ValidateMenu() { return true; }
  
  //----------------------------------------------------
  // Builds Question to ask user when they want to know about the VALUE to enter.. 
  String GetInputQuestion() { return ""; }
  
  //----------------------------------------------------
  // Outputs results to the console.. 
  void PrintResults()
  {
    System.out.println("  Perimeter = " + m_perimeter);
    System.out.println("  Area      = " + m_area);
  }
  
  //----------------------------------------------------
  // OVERRIDES version on BASE class! 
  protected boolean AskForAndValidateInputs()
  {
    // First, collect height..
    m_height = AskForInput("Please enter Height of Rectangle: ");
    
    // Ensure that the value they give us is numeric..
    if( !m_height.matches("-?\\d+(\\.\\d+)?") ) // <-- This is saying we can start with a - and can have any number of digits before and after the .
    {
      System.out.println("\nERROR: Height MUST be a NUMBER.  Please ensure you entered a number and try again.\n");
      return false; 
    }

    // Next, collect width..
    m_width = AskForInput("Please enter Width of Rectangle: ");
    
    // Ensure that the value they give us is numeric..
    if( !m_width.matches("-?\\d+(\\.\\d+)?") ) // <-- This is saying we can start with a - and can have any number of digits before and after the .
    {
      System.out.println("\nERROR: Width MUST be a NUMBER.  Please ensure you entered a number and try again.\n");
      return false; 
    }
    
    // All is good in the hood :)
    return true;
  }
  
  //----------------------------------------------------
  // Does the MATH that is necessary here..
  // This function is called from within the Execute() function on the base class.  
  boolean DoMath()
  {
    // Attempt to convert our string
    // This SHOULD be valid now, but the try/catch
    // will find anything that is NOT valid:
    // If we fail here, we will just return false, let the person calling us deal with the error..
    double height = 0;    
    double width  = 0;
    try                
    { 
      height = Double.parseDouble(m_height); 
      width  = Double.parseDouble(m_width); 
    }
    catch(Exception e) 
    { 
      m_error = e.getMessage(); 
      return false; 
    }

    // Conversion SUCCESSFULL!
    // We have a HEIGHT and WIDTH now, let's do something with it!
    m_perimeter = 2 * (height + width);
    m_area      = height * width;  
    
    // If we make it here, we succeeded :)
    return true;
  }

  //----------------------------------------------------
  //----------------------------------------------------
  //----------------------------------------------------

  //-------------------------
  // Private members variables..
  //-------------------------
  private String m_height    = "";
  private String m_width     = "";
  
  private double m_perimeter = 0;
  private double m_area      = 0;
}
