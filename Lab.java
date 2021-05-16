package softwareengineeringae2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab {
    private String name;
    private int nbOfStaff;
    private ArrayList<String> requirements = new ArrayList<String>();
    
    Scanner input;
    
    public Lab(String name, int nbOfStaff, String requirements){
        this.name = name;
        this.nbOfStaff = nbOfStaff;
        
        input = new Scanner(requirements);
        while(input.hasNext()){
            String s = input.next();
            this.requirements.add(s);
        }
    }
    
    public int getNbOfStaff(){
        return nbOfStaff;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getRequirements(){
        return requirements;
    }
    
    public String printRequirements(){
        String s = "";
        
        for(String i : requirements){
            s += i +",";
        }
        return s;
    }
    
    public String toString(){
        return "This lab is: "+name +"with staffs of: "+nbOfStaff +"\n"
                +"requirements: "+printRequirements();
    }
}
