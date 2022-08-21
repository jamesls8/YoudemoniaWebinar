
public class Recipient {
    private String university;
    private String first_name;
    private String last_name;
    private String position; 
    private String email;
    private String gender;

    public Recipient(String[] arr){
        if (arr.length != 6)
            System.out.println("\nFail, Can only have 6 attributes per line\n");
        else{
            this.university = arr[0];
            this.first_name = arr[1];
            this.last_name = arr[2];
            this.position = arr[3];
            this.email = arr[4];
            this.gender = arr[5];
        }
    }
    public String getUniversity(){
        return this.university;
    }
    public String getFirstName(){
        return this.first_name;
    }
    public String getLastName(){
        return this.last_name;
    }
    public String getPosition(){
        return this.position;
    }
    public String getEmail(){
        return this.email;
    }
    public String getGender(){
        return this.gender;
    }

    public boolean isMale(){
        if(getGender() == "M" || getGender() == "m" || getGender() == "male" || getGender() == "Male")
            return true;
        else
            return false;
    }

    public void printAttributes(){
        System.out.println(getUniversity());
        System.out.println(getFirstName());
        System.out.println(getLastName());
        System.out.println(getPosition());
        System.out.println(getEmail());
        System.out.println(getGender());
    }

    public String toString(){
        return getUniversity() + "\t" + getFirstName() + "\t" + getLastName() + "\t" + getPosition() + "\t" + getEmail() + "\t" + getGender();
    }
}
