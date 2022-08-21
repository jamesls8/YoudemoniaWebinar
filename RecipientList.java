import java.io.*;

public class RecipientList 
{
    private Recipient[] list;
    private String fileName;
    private int numRows;


    public RecipientList(String fileName)
    {
        this.fileName = fileName;
        this.numRows = countRows();
    }


    public int countRows()
    {
        BufferedReader reader = null;
        String line = "";
        int rowCount = 0;
        try {
            reader = new BufferedReader(new FileReader(this.fileName));
            while((line = reader.readLine()) != null){
                rowCount++;
            }
            return rowCount;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        finally{
            try {
                reader.close();
            } catch (IOException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public int getRowCount()
    {
        return this.numRows;
    }


    public void populateList()
    {
        this.list = new Recipient[getRowCount()];
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(this.fileName));
            int currRowPos = 0;
            while((line = reader.readLine()) != null)
            {
                String[] currentRow = line.split(",");

                list[currRowPos] = new Recipient(currentRow);

                currRowPos++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch (IOException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public Recipient getRecipient(int index){
        return this.list[index];
    }


    public void printList(){
        for (int r = 0; r < this.list.length; r++)
        {
            this.list[r].printAttributes();
        }
    }

}
