/*
 4]	Write a menu-driven Java Program to create an ArrayList of 
 (1) integers and (2) floats of user specified length. 
 Write a set of overloaded methods to “add” and/or “remove” elements from the arrays and another
  set of overloaded methods to perform linear search on the arrays, given the key element. 
 Create object(s) to demonstrate the above functionalities. 
 */
import java.util.Scanner;
import java.util.ArrayList;
public class TW4 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> iList = new ArrayList<>();
        ArrayList<Float> fList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1.Insert a Integer ArrayList");
            System.out.println("2.Insert a Float ArrayList");
            System.out.println("3.Perform linear search");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch(choice){
                case 1: System.out.println("Enter value: ");
                        int value = in.nextInt();
                        iList.add(value);
                        break;
                case 2: System.out.println("Enter value: ");
                        float ele = in.nextFloat();
                        fList.add(ele);
                        break;
                case 3: System.out.println("1.Linear Search for integer\n2.Linear search for float");
                        int option = in.nextInt();
                        switch(option){
                            case 1: System.out.println("Enter key to search: ");
                                    int key = in.nextInt();
                                    System.out.println(linearSearch(iList, key));
                                    break;
                            case 2: System.out.println("Enter key to search: ");
                                    float key1 = in.nextFloat();
                                    System.out.println(linearSearch(fList, key1));
                                    break;
                        }
                        break;
                case 4: System.exit(0);
                        break;
            }
            
        }
    }
    static boolean linearSearch(ArrayList<Integer> iList, int key){
        for(int ele: iList){
            if(ele == key){
                return true;
            }
        }
        return false;
    }
    static boolean linearSearch(ArrayList<Float> fList, float key){
        for(float ele: fList){
            if(ele == key){
                return true;
            }
        }   
        return false;
    }
}
