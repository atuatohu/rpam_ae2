package softwareengineeringae2;

import java.util.ArrayList;

public class Teachers {
    private String name;
    private ArrayList<String> skills = new ArrayList<String>();
    
    public Teachers(String name, String skill){
        this.name = name;
        this.skills.add(skill);
    }
    
    public String getName(){
        return name;
    }
    public ArrayList<String> getSkills(){
        return skills;
    }
    
    public void addSkill(String skill){
        skills.add(skill);
    }
    
    public String printSkills(){
        String s = "";
        
        for(String i : skills){
            s += i +", ";
        }
        return s;
    }
    
    public String toString(){
        return "Teacher: "+name +" with skills of: "+printSkills() +"\n";
    }
}
