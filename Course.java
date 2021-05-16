package softwareengineeringae2;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Lab> labs = new ArrayList<Lab>();
    
    public Course(String name, Lab lab){
        this.name = name;
        this.labs.add(lab);
    }
    public Course(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    public ArrayList<Lab> getLabs(){
        return labs;
    }
    
    public void addLab(Lab lab){
        this.labs.add(lab);
    }
    
    public String printLabs(){
        String s = "";
        
        for(Lab i : labs){
            s += i.toString() +"\n";
        }
        
        return s;
    }
    public String toString(){
        return "This course is: "+name +" with labs of: "+printLabs();
    }
}
