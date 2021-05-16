package softwareengineeringae2;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseAddTrial {
    
    public static int checkCourse(ArrayList<Course> array, String name){
        int n = -1;
        
        for(Course i : array){
            if(i.getName().equalsIgnoreCase(name))
                return array.indexOf(i);
        }
        return n;
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to adding courses");
        System.out.println("For adding, you need to specify the name");
        System.out.println("Each course has several labs, and each lab "
                          + "has a number of staffs and "
                          + "the requirements for the lab!");
        
        ArrayList<Course> c = new ArrayList<Course>();
        Scanner input = new Scanner(System.in);
        Scanner phrase;
        int choice = 0;
        while(true){
            System.out.println("1: add a course, 2: add a lab, 3: quit");
            
            choice = input.nextInt();
            if(choice == 3)
                break;
            else if(choice == 1){
                System.out.println("You have chosen to add a course!");
                System.out.println("For entering a course, specify its name!");
                
                String name = input.next();
                int index = checkCourse(c, name);
                
                if(index == -1){
                    Course course = new Course(name);
                    c.add(course); 
                }
                else{
                   System.out.println("Course already exist!");
                }   
            }
            else if(choice == 2){
                System.out.println("You have chosen to add a lab!");
                System.out.println("for which course you want to add the lab?");
                
                String name = input.next();
                input.nextLine();
                
                int index = checkCourse(c, name);
                if(index == -1){
                    System.out.println("Course does not exist!");
                }
                else{
                    System.out.println("Enter the lab name, nbOf staff, and "
                                      + "requirement having spaces between "
                                      + "each argument");
                    String sentence = input.nextLine();
                    phrase = new Scanner(sentence);
                    
                    String labName = phrase.next();
                    int nbOfStaff = phrase.nextInt();
                    String requirement = phrase.next();
                    
                    Lab lab = new Lab(labName, nbOfStaff, requirement);
                    c.get(index).addLab(lab);
                }
            }
        }
        for(Course i : c){
            System.out.println(i.toString());
        }
    }
}
