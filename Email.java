import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Email {
    private RecipientList recipients;
    private String sender;
    private String senderPos;

    public Email(String fileName, String sender, String senderPos)
    {
        this.sender = sender;
        this.senderPos = senderPos;

        recipients = new RecipientList(fileName);
        recipients.populateList();
    }

    public String constructEmail(Recipient r)
    {
        //header
        String emailAdress = r.getEmail() + "\n\n";
        String horizontalLine = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n";



        String greeting;
        if (r.isMale())
            greeting = "Dear Mr. " + r.getLastName() + ",\n\n"; 
        else
            greeting = "Dear Ms. " + r.getLastName() + ",\n\n";
        

        String para1 = "I hope this email finds you well! My name is "  + getSender() + ", and I'm reaching out as a representative of an organization called Youdemonia: a student-run, Southeast Michigan-based, 501c3 pending organization. At Youdemonia, we aim to better our society by combating social disparities and inspiring the next generation of leaders.\n\n";


        String para2 = "We are currently arranging an online college admissions webinar that will take place sometime in late October or Early November. This webinar would be accessible via zoom to students across the country. We are interested in your participation as a keynote speaker who can offer insight into the college admissions process and answer student-submitted questions.\n\n";


        String para3;
        if (r.getPosition().substring(0,1).equals("a") || r.getPosition().substring(0,1).equals("e")
        || r.getPosition().substring(0,1).equals("i") || r.getPosition().substring(0,1).equals("o") 
        || r.getPosition().substring(0,1).equals("u")
        || r.getPosition().substring(0,1).equals("A") || r.getPosition().substring(0,1).equals("E") 
        || r.getPosition().substring(0,1).equals("I") || r.getPosition().substring(0,1).equals("O")
        || r.getPosition().substring(0,1).equals("U"))
            para3 = "As many schools in our local community are underfunded and lack adequate counseling, information about college admissions may be very difficult to come across. We would love to have a skilled speaker such as yourself to fill this resource disparity and help students from various backgrounds become educated on the next steps of their education. In addition, we plan to partner with other organizations with the primary goal of marketing this event, especially towards underprivileged areas and schools. To this end, we aim to help students navigate the college admissions process. Through your expertise as an " 
            +  r.getPosition() + " at "
            +  r.getUniversity() +", you can help limit the information gap between economic divisions and help us on our mission to promote equality among all.\n\n";
        else
            para3 = "As many schools in our local community are underfunded and lack adequate counseling, information about college admissions may be very difficult to come across. We would love to have a skilled speaker such as yourself to fill this resource disparity and help students from various backgrounds become educated on the next steps of their education. In addition, we plan to partner with other organizations with the primary goal of marketing this event, especially towards underprivileged areas and schools. To this end, we aim to help students navigate the college admissions process. Through your expertise as a " 
            +  r.getPosition() + " at "
            +  r.getUniversity() +", you can help limit the information gap between economic divisions and help us on our mission to promote equality among all.\n\n";

        String closing = 
        "Hope to hear from you soon, \n"
        + getSender() + "\n"
        + getSenderPos() + "\n"
        + "www.youdemonia.org";


        String email = emailAdress + horizontalLine + greeting + para1 + para2 + para3 + closing;

        return email;
    }


    public void generateFiles() throws FileNotFoundException
    {
        for (int r = 0; r < this.recipients.getRowCount(); r++)
        {
            String fileName = "." + this.recipients.getRecipient(r).getLastName() + ".txt";
            try(PrintWriter out = new PrintWriter(fileName))
            {
                out.print(constructEmail(this.recipients.getRecipient(r)));
                System.out.println("PASS - " + this.recipients.getRecipient(r));
            }
        }
    }


    public String getSender()
    {
        return this.sender;
    }
    public String getSenderPos()
    {
        return this.senderPos;
    }

    public void printEmail()
    {
        System.out.println(constructEmail(recipients.getRecipient(0)));
    }
}

