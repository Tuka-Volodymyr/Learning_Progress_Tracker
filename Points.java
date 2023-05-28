package tracker;
public class Points {
    public Java java;
    public DSA dsa;
    public Databases databases;
    public Spring spring;
    public Points(Statistics statistics) {
        java = new Java(statistics);
        dsa = new DSA(statistics);
        databases = new Databases(statistics);
        spring = new Spring(statistics);
    }





}
