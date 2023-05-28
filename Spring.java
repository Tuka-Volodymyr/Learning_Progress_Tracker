package tracker;

public class Spring {
    public int points;
    public Statistics statistics;
    public Spring(Statistics statistics){
        this.statistics=statistics;
        points=0;
    }
    public void addPoint(int pointToAdd){
        points+=pointToAdd;
        if(pointToAdd!=0)statistics.addSubmissionsSpring();
    }
}
