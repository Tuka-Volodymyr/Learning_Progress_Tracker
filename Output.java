package tracker;

import java.util.ArrayList;

public class Output{
    public void titleMsg() {
        System.out.println("Learning Progress Tracker");
    }

    public void errorUnknownCommMsg() {
        System.out.println("Error: unknown command!");
    }

    public void noInputMsg() {
        System.out.println("No input.");
    }

    public void byeMsg() {
        System.out.println("Bye!");
    }
    public void stdntAddMsg(){System.out.println("Enter student credentials or 'back' to return:");}
    public void stdntWasAddMsg(){System.out.println("The student has been added.");}
    public void totalStdntMsg(int amount){System.out.printf("Total %s students have been added.\n",amount);}
    public void errorIncorrectExitMsg(){System.out.println("Enter 'exit' to exit the program.");}
    public void wrongFrstName(){System.out.println("Incorrect first name.");}
    public void wrongLastName(){System.out.println("Incorrect last name.");}
    public void wrongEmail(){System.out.println("Incorrect email.");}
    public void wrongCredentials(){System.out.println("Incorrect credentials.");}
    public void emailAlreadyUse(){System.out.println("This email is already taken.");}
    public void emptyList(){System.out.println("No students found");}
    public void enterIDPoint(){System.out.println("Enter an id and points or 'back' to return");}
    public void printListOfIdStudent(ArrayList<Students> listOfStudents){
        System.out.println("Students:");
        for(Students str:listOfStudents){
            System.out.println(str.hashCode);
        }
    }
    public void wrongStudentId(String id){System.out.printf("No student is found for id=%s%n",id);}
    public void pointAdded(){System.out.println("Points updated.");}
    public void wrongPoint(){System.out.println("Incorrect points format");}
    public void enterId(){System.out.println("Enter an id or 'back' to return:");}
    public void printPoints(String id,ArrayList<Students> listOfStudents){
        for(Students stud:listOfStudents){
            if(Integer.parseInt(id)==stud.hashCode) {
                System.out.printf("%s points: Java=%s; DSA=%s; Databases=%s; Spring=%s%n", id, stud.points.java.points, stud.points.dsa.points, stud.points.databases.points, stud.points.spring.points);
            }
        }
    }
    public void printCourseStatistics(){System.out.println("Type the name of a course to see details or 'back' to quit:");}
    public void printAllStatisticsOfNull(){
        System.out.println("Most popular: n/a\n" +
                "Least popular: n/a\n" +
                "Highest activity: n/a\n" +
                "Lowest activity: n/a\n" +
                "Easiest course: n/a\n" +
                "Hardest course: n/a");
    }

    public void printPopularity(ArrayList<String> mostPopular,ArrayList<String> leastPopular){
        System.out.print("Most popular:");
        if(mostPopular.isEmpty())System.out.print(" n/a");
        for(String course:mostPopular){
            System.out.printf(" %s",course);
        }
        System.out.print("\nLeast popular:");
        if(leastPopular.isEmpty())System.out.print(" n/a");
        for(String course:leastPopular){
            System.out.printf(" %s",course);
        }
    }
    public void printActivity(ArrayList<String> highestActivity,ArrayList<String> lowestActivity){
        System.out.print("\nHighest activity:");
        if(highestActivity.isEmpty())System.out.print(" n/a");
        for(String course:highestActivity){
            System.out.printf(" %s",course);
        }
        System.out.print("\nLowest activity:");
        if(lowestActivity.isEmpty())System.out.print(" n/a");
        for(String course:lowestActivity){
            System.out.printf(" %s",course);
        }
    }
    public void printCourse(ArrayList<String> easiestCourse,ArrayList<String> hardestCourse){
        System.out.print("\nEasiest course:");
        if(easiestCourse.isEmpty())System.out.print(" n/a");
        for(String course:easiestCourse){
            System.out.printf(" %s",course);
        }
        System.out.print("\nHardest course:");
        if(hardestCourse.isEmpty())System.out.print(" n/a");
        for(String course:hardestCourse){
            System.out.printf(" %s",course);
        }
        System.out.println();
    }
    public void theCourseTable(String nameOfCourse){System.out.printf("%s\n" +
            "id    points    completed%n",nameOfCourse);}
    public String printDataOfCompletedCourse(int id,int point,float completed){
        return String.format("%d %d %.1f",id,point,completed)+"%";
    }
    public  void unknownCourse(){System.out.println("Unknown course.");}
    public void printNotify(String email,String name,String course){
        System.out.printf("To: %s\n" +
                "Re: Your Learning Progress\n" +
                "Hello, %s! You have accomplished our %s course!%n",email,name,course);
    }
    public void totalStudOfNotified(int count){
        System.out.printf("Total %d students have been notified.%n",count);

    }



}
