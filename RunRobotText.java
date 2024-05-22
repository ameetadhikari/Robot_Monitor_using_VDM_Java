import java.util.Scanner;
public class RunRobotText 
{
    public static void main(String[] args) 
    {
        try
        {
            RobotMonitor robot = new RobotMonitor();
            Scanner sc = new Scanner (System.in);
            char reply;
            do
            {
                System.out.println("\nCURRENT ROBOT POSITION: " + robot);
                System.out.println("[1]: Move RIGHT");
                System.out.println("[2]: Move LEFT");
                System.out.println("[3]: Move UP");
                System.out.println("[4]: Move DOWN");
                System.out.println("[5]: Robot EXIT");
                System.out.println("[6]: END");
                System.out.print("ENTER CHOICE: ");
                reply = sc.next().charAt(0);
                try
                {
                    switch(reply)
                    {
                        case '1': robot.MoveRight();break;
                        case '2': robot.MoveLeft();break;
                        case '3': robot.MoveUp();break;
                        case '4': robot.MoveDown();break;
                        case '5': robot.Exit();break;
                        case '6': System.out.println("Goodbye");break; 
                        default:  System.out.println("ERROR: Options 1 - 6 only!");
                    }   
                }
                catch(VDMException e)
                {
                    System.out.println("VDMException " + e.getMessage());
                }

            } while(reply != '6');  
        }
        catch(VDMException e)
        {
            System.out.println("VDMException" + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SYSTEM ERROR" + e.getMessage());
            System.exit(0);
        }
    }

}
