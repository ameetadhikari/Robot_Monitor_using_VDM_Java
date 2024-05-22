/** A general unchecked VDMExcpetion that can be used to throw VDM specific errors in Java implementations
 *  @author Dr Aaron Kans
 *	@version 14/03/2015
 */
public class VDMException extends RuntimeException
{
  public VDMException (String message)
  {
    super (message);
  }
}
