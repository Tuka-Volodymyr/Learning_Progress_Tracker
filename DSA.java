package tracker;

public class DSA {
    public int points;
    public Statistics statistics;

    public DSA(Statistics statistics){
        points=0;
        this.statistics=statistics;
    }
    public void addPoint(int pointToAdd){
        points+=pointToAdd;
        if(pointToAdd!=0)statistics.addSubmissionsDSA();
    }
}
