package tracker;

import java.util.ArrayList;

public class Checker {
    public boolean wrongName(String name){
        if(name.length()==1)return true;
        name=name.replaceAll("\\s","");
        return !name.matches("^[a-zA-Z]([a-zA-Z]|[-'](?=[^-']))*[a-zA-Z]$");
    }
    public boolean wrongEmail(String email){
        return !email.matches("^[a-zA-Z0-9.!#$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$");
    }
    public boolean emailAlreadyUse(String email, ArrayList<Students> listOfStudents){
        for(Students stud:listOfStudents){
            if(stud.email.equals(email))return true;
        }
        return false;
    }
    public boolean wrongIdStudent(String id,ArrayList<Students> listOfStudents){
        for(Students stud:listOfStudents){
            if(String.valueOf(stud.hashCode).equals(id))return false;
        }
        return true;
    }
    public boolean wrongPoint(String[] points){
        if(points.length!=5)return true;
        for(String str:points){
            if(!str.matches("[0-9]+"))return true;
        }
        return false;
    }


}
