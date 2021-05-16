package softwareengineeringae2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeachersAddTrial {

    public static int checkTeacher(ArrayList<Teachers> array, String s){
        int n = -1;
        for(Teachers i: array){
            if(i.getName().equalsIgnoreCase(s))
                return array.indexOf(i);
        }
        return n;
    }
    
    public static void writeTeachersToFile(ArrayList<Teachers> t) throws IOException{
        File myFile = null;
        try{
            myFile = new File("D:\\Karim\\file1.txt");
            if(myFile.createNewFile()){
                System.out.println("File created! "+myFile.getName());
            }
            else{
                System.out.println("File already exists!");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            FileWriter writer = new FileWriter("D:\\Karim\\file1.txt",false);
            
            for(Teachers i : t){
                writer.write(i.toString());
            }
            writer.close();
            System.out.println("Success!");
        }catch(IOException e){
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {  
        System.out.println("Writing teachers!");
        Scanner input = new Scanner(System.in);
        Scanner phrase;
        
        int choice = 0;
        String name, skill;
        ArrayList<Teachers> t = new ArrayList<Teachers>();
        
        while(true){
            System.out.println("Select what do you want to do!");
            System.out.println("1: create a teacher, 2: Quit");
            
            choice = input.nextInt();
            if(choice == 2){
                break;
            }
            else{
                System.out.println("Enter the name followed by ',' then skill");
                String sentence = input.next();
                phrase = new Scanner(sentence);
                phrase.useDelimiter(",");
                name = phrase.next();
                skill = input.next();
                
                int index = checkTeacher(t, name);
                if(index == -1){
                    Teachers teacher = new Teachers(name, skill);
                    t.add(teacher);
                }
                else{
                    System.out.println("Teacher exist! adding the skill "
                                       + "to the teacher");
                    t.get(index).addSkill(skill);
                    System.out.println("Skill added!");
                }
            }
        }
        System.out.println(t.size());
        for(Teachers i: t){
            System.out.println(i.toString());
        }
        writeTeachersToFile(t);
    }
}
