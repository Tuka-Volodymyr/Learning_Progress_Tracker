package tracker;

import java.util.ArrayList;
import java.util.HashSet;

public class Action {
    public Output output;
    public Checker checker;
    public Statistics statistics;
    public Students students;

    public ArrayList<Students> listOfStudents;

    public Action(){
        listOfStudents=new ArrayList<>();
        statistics=new Statistics();
        checker=new Checker();
        output =new Output();
    }


    public void addStudents(){
        String firstName;
        StringBuilder lastName;
        String email;
        int count=0;
        String[] array;
        output.stdntAddMsg();
        while (true){
            String studentsData =Input.readInput();
            if(studentsData.equals("back")){
                output.totalStdntMsg(count);
                return;
            }
            array=studentsData.split(" ");
            //check value
            if(3 > array.length) {
                output.wrongCredentials();
                continue;
            }else if(array.length>3){
                firstName=array[0];
                lastName=new StringBuilder(array[1]);
                for(int i=2;i<array.length-1;i++){
                    lastName.append(" ").append(array[i]);
                }
                email=array[array.length-1];
            }else {
                firstName=array[0];
                lastName = new StringBuilder(array[1]);
                email=array[2];
            }
            if(checker.wrongName(firstName)){
                output.wrongFrstName();
            } else if (checker.wrongName(lastName.toString())) {
                output.wrongLastName();
            } else if (checker.wrongEmail(email)) {
                output.wrongEmail();
            }else if(checker.emailAlreadyUse(email,listOfStudents)){
                output.emailAlreadyUse();
            }else {
                students=new Students(firstName,lastName.toString(),email,statistics);
                //add student
                listOfStudents.add(students);
                count++;
                output.stdntWasAddMsg();
            }
        }
    }
    public void addPoint(){
        output.enterIDPoint();
        while (true){
            String[] points=Input.readInput().split(" ");
            if(points[0].equals("back")){
                return;
            }
            if(checker.wrongIdStudent(points[0],listOfStudents)) {
                output.wrongStudentId(points[0]);
            }else if(checker.wrongPoint(points)){
                output.wrongPoint();
            }else {
                for(Students stud:listOfStudents){
                    if(stud.hashCode==Integer.parseInt(points[0])){
                        stud.points.java.addPoint(Integer.parseInt(points[1]));
                        stud.points.dsa.addPoint(Integer.parseInt(points[2]));
                        stud.points.databases.addPoint(Integer.parseInt(points[3]));
                        stud.points.spring.addPoint(Integer.parseInt(points[4]));
                    }
                }
                output.pointAdded();
            }
        }

    }
    public void find(){
        output.enterId();
        while (true) {
            String[] points = Input.readInput().split(" ");
            if (points[0].equals("back")) {
                return;
            }
            if(checker.wrongIdStudent(points[0],listOfStudents)) {
                output.wrongStudentId(points[0]);
                continue;
            }
            output.printPoints(points[0],listOfStudents);
        }
    }

    public void list(){
        if(listOfStudents.isEmpty()){
            output.emptyList();
        }else {
            output.printListOfIdStudent(listOfStudents);
        }
    }
    public void statistics(){
        statistics.makeStatistics(output,listOfStudents);
        while (true) {
            String[] points = Input.readInput().split(" ");
            if (points[0].equals("back")) {
                return;
            }
            switch (points[0].toLowerCase()){
                case "java"->statistics.javaCompleted(listOfStudents);
                case "dsa"->statistics.dsaCompleted(listOfStudents);
                case "databases" ->statistics.databaseCompleted(listOfStudents);
                case "spring" ->statistics.springCompleted(listOfStudents);
                default -> output.unknownCourse();
            }
        }
    }
    public void accomplish(){
        HashSet<Integer> hashSet=new HashSet<>();
        for(Students stud:listOfStudents){
            if(stud.points.java.points>=statistics.maxPointJava) {
                output.printNotify(stud.email, stud.firstName + " " + stud.lastName, "Java");
                hashSet.add(stud.hashCode);
                stud.points.java.points -= statistics.maxPointJava;
            }
            if(stud.points.dsa.points>=statistics.maxPointDSA) {
                output.printNotify(stud.email, stud.firstName + " " + stud.lastName, "DSA");
                hashSet.add(stud.hashCode);
                stud.points.dsa.points -= statistics.maxPointDSA;
            }
            if(stud.points.databases.points>=statistics.maxPointDatabases) {
                output.printNotify(stud.email, stud.firstName + " " + stud.lastName, "Databases");
                hashSet.add(stud.hashCode);
                stud.points.databases.points -= statistics.maxPointDatabases;
            }
            if(stud.points.spring.points>=statistics.maxPointSpring){
                output.printNotify(stud.email, stud.firstName + " " + stud.lastName, "Spring");
                hashSet.add(stud.hashCode);
                stud.points.spring.points-=statistics.maxPointSpring;
            }
        }
        output.totalStudOfNotified(hashSet.size());
    }
}
