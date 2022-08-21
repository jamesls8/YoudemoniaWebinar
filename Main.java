import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //CSV = Comma separated values
        //      Text file that uses a comma to separate values

        try (Scanner in = new Scanner(System.in)) 
        {
            System.out.print("Enter CSV Location: ");
            String fileName = in.nextLine();

            System.out.print("Enter Sender NAME: ");
            String sender = in.nextLine();

            System.out.print("Enter Sender POSITION: ");
            String senderPosition = in.nextLine();

            Email webinars = new Email(fileName, sender, senderPosition);
            
            webinars.generateFiles();
        }
    }
}