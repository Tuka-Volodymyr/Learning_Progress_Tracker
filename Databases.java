package tracker;

public class Databases{
    public int points;
    public Statistics statistics;

    public Databases(Statistics statistics){
        this.statistics=statistics;
        points=0;
    }
    public void addPoint(int pointToAdd){
        points+=pointToAdd;
        if(pointToAdd!=0)statistics.addSubmissionsDatabases();
    }
}
