package tracker;

public class Students {
    public String firstName;
    public String lastName;
    public String email;
    public int hashCode;
    public Points points;
    public Students(String firstName,String lastName,String email,Statistics statistics){
        points=new Points(statistics);
        this.email=email;
        this.lastName=lastName;
        this.firstName=firstName;
        hashCode=hashCode();
    }
    public int hashCode() {
        int result = 17;
        result = 31 * result +  email.hashCode();
        if(result<0)result=-result;
        return result;
    }

}
