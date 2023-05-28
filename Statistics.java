package tracker;

import java.util.*;

public class Statistics{
    public HashSet<Java> listOfJavaStud;
    public HashSet<DSA> listOfDSAStud;
    public HashSet<Databases> listOfDatabaseStud;
    public HashSet<Spring> listOfSpringStud;
    public final int maxPointJava=600,maxPointDSA=400,maxPointDatabases=480,maxPointSpring=550;
    public int submissionsJava,submissionsDSA,submissionsDatabases,submissionsSpring;
    public int averageOfJava,averageOfDSA,averageOfDatabases,averageOfSpring;
    public ArrayList<String> mostPopularList,leastPopularList,highestActivityList,lowestActivityList,easiestCourseList,hardestCourseList;
    public Output output;
    public Statistics(){
        listOfJavaStud=new HashSet<>();
        listOfSpringStud=new HashSet<>();
        listOfDatabaseStud=new HashSet<>();
        listOfDSAStud=new HashSet<>();
        mostPopularList=new ArrayList<>();
        leastPopularList=new ArrayList<>();
        highestActivityList=new ArrayList<>();
        lowestActivityList=new ArrayList<>();
        easiestCourseList=new ArrayList<>();
        hardestCourseList=new ArrayList<>();
        submissionsJava=0;
        submissionsDatabases=0;
        submissionsSpring=0;
        submissionsDSA=0;
    }
    public void makeStatistics(Output output,ArrayList<Students> listOfStudents){
        this.output=output;
        output.printCourseStatistics();
        if(listOfStudents.isEmpty()){
            output.printAllStatisticsOfNull();
        }else{
            makeListsOfStud(listOfStudents);
            popularity();
            activity();
            course();
            output.printPopularity(mostPopularList,leastPopularList);
            output.printActivity(highestActivityList,lowestActivityList);
            output.printCourse(easiestCourseList,hardestCourseList);
        }
    }

    public void popularity(){
        Map<String,Integer> map=new TreeMap<>();
        map.put("Databases",getNumberOfDatabasesStud());
        map.put("Java",getNumberOfJavaStud());
        map.put("DSA",getNumberOfDSAStud());
        map.put("Spring",getNumberOfSpringStud());
        int mostPopularNum=Collections.max(map.values());
        int leastPopularNum=Collections.min(map.values());
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if (Objects.equals(mostPopularNum, entry.getValue())){
                mostPopularList.add(entry.getKey());
            }else {
                if (Objects.equals(leastPopularNum, entry.getValue())){
                    leastPopularList.add(entry.getKey());
                }
            }
        }
    }
    public void activity(){
        Map<String,Integer> map=new TreeMap<>();
        map.put("Databases",submissionsDatabases);
        map.put("Java",submissionsJava);
        map.put("DSA",submissionsDSA);
        map.put("Spring",submissionsSpring);
        int highestActivityNum=Collections.max(map.values());
        int lowestActivityNum=Collections.min(map.values());
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(Objects.equals(highestActivityNum, entry.getValue())){
                highestActivityList.add(entry.getKey());
            }else {
                if(Objects.equals(lowestActivityNum, entry.getValue()))lowestActivityList.add(entry.getKey());
            }

        }
    }



    public void course(){
        Map<String,Integer> map=new TreeMap<>();
        map.put("Databases",averageOfDatabases);
        map.put("Java",averageOfJava);
        map.put("DSA",averageOfDSA);
        map.put("Spring",averageOfSpring);
        int hardestCourseNum=Collections.min(map.values());
        int easiestCourseNum=Collections.max(map.values());
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(Objects.equals(hardestCourseNum, entry.getValue())){
                hardestCourseList.add(entry.getKey());
            }else{
                if(Objects.equals(easiestCourseNum, entry.getValue()))easiestCourseList.add(entry.getKey());
            }
        }

    }
    public void javaCompleted(ArrayList<Students> listOfStudents){
        Map<String,Integer> map=new TreeMap<>();
        output.theCourseTable("Java");
        for(Java stud:listOfJavaStud){
            for(Students studGen:listOfStudents){
                if(studGen.points.java.equals(stud)){
                    float completed=(float)stud.points*100/maxPointJava;
                    String dataOfCourse=output.printDataOfCompletedCourse(studGen.hashCode,stud.points,completed);
                    map.put(dataOfCourse,stud.points);
                }
            }
        }
        sort(map);
    }
    public void dsaCompleted(ArrayList<Students> listOfStudents){
        Map<String,Integer> map=new TreeMap<>();

        output.theCourseTable("DSA");
        for(DSA stud:listOfDSAStud){
            for(Students studGen:listOfStudents){
                if(studGen.points.dsa.equals(stud)){
                    float completed=(float)stud.points*100/maxPointDSA;
                    String dataOfCourse=output.printDataOfCompletedCourse(studGen.hashCode,stud.points,completed);
                    map.put(dataOfCourse,stud.points);
                }
            }
        }
        sort(map);
    }
    public void databaseCompleted(ArrayList<Students> listOfStudents){
        Map<String,Integer> map=new TreeMap<>();
        output.theCourseTable("Databases");
        for(Databases stud:listOfDatabaseStud){
            for(Students studGen:listOfStudents){
                if(studGen.points.databases.equals(stud)){
                    float completed=(float)stud.points*100/maxPointDatabases;
                    String dataOfCourse=output.printDataOfCompletedCourse(studGen.hashCode,stud.points,completed);
                    map.put(dataOfCourse,stud.points);
                }
            }
        }
        sort(map);
    }
    public void springCompleted(ArrayList<Students> listOfStudents){
        Map<String,Integer> map=new TreeMap<>();
        output.theCourseTable("Spring");
        for(Spring stud:listOfSpringStud){
            for(Students studGen:listOfStudents){
                if(studGen.points.spring.equals(stud)){
                    float completed=(float)stud.points*100/maxPointSpring;
                    String dataOfCourse=output.printDataOfCompletedCourse(studGen.hashCode,stud.points,completed);
                    map.put(dataOfCourse,stud.points);
                }
            }
        }
        sort(map);
    }
    public void sort(Map<String,Integer> map){
        while (!map.isEmpty()){
            Iterator it=map.entrySet().iterator();
            while(it.hasNext()) {
                int max = Collections.max(map.values());
                Map.Entry<Character, Integer> item = (Map.Entry<Character, Integer>) it.next();
                //it.remove() will delete the item from the map
                if ((Integer) item.getValue() == max) {
                    System.out.println(item.getKey());
                    it.remove();
                }
            }
        }
    }

    public void addSubmissionsJava() {
        submissionsJava++;
    }
    public void addSubmissionsDSA() {
        submissionsDSA++;
    }

    public void addSubmissionsDatabases() {
        submissionsDatabases++;
    }
    public void addSubmissionsSpring() {
        submissionsSpring++;
    }

    public int getNumberOfDatabasesStud() {
        return listOfDatabaseStud.size();
    }

    public int getNumberOfDSAStud() {
        return listOfDSAStud.size();
    }

    public int getNumberOfJavaStud() {
        return listOfJavaStud.size();
    }

    public int getNumberOfSpringStud() {
        return listOfSpringStud.size();
    }
    public void makeListsOfStud(ArrayList<Students> listOfStudents){
        for(Students stud:listOfStudents){
            if(stud.points.java.points!=0){
                listOfJavaStud.add(stud.points.java);
                averageOfJava=stud.points.java.points/submissionsJava;
            }
            if(stud.points.dsa.points!=0){
                listOfDSAStud.add(stud.points.dsa);
                averageOfDSA=stud.points.dsa.points/submissionsDSA;
            }
            if(stud.points.databases.points!=0){
                listOfDatabaseStud.add(stud.points.databases);
                averageOfDatabases=stud.points.databases.points/submissionsDatabases;
            }
            if(stud.points.spring.points!=0){
                listOfSpringStud.add(stud.points.spring);
                averageOfSpring=stud.points.spring.points/submissionsSpring;
            }
        }
    }






}
