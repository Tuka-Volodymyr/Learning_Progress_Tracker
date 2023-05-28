package tracker;

public class Java {

    public int points;
    public Statistics statistics;
    public Java(Statistics statistics){
        points=0;
        this.statistics=statistics;
    }
    public void addPoint(int pointToAdd){
        points+=pointToAdd;
        if(pointToAdd!=0)statistics.addSubmissionsJava();
    }

}
