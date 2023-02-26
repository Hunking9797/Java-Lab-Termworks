/*
 5]	Write a menu-driven Java Program to create a HashMap to store key-value pairs of login credentials.
  The menu options to be provided are for : adding a key-value pair,
  retrieve the “value” for a given “key” (first check if the specified key is present),
   retrieve all the keys, retrieve all the values, retrieve all the key-value pairs,
  change the value associated with a key in a HashMap,
  remove a HashMap element given the key, remove a HashMap entry with Key and Value, 
 check if a given “value” exists in the Hashmap and display the HashMap. 
 Read user input where required and display suitable error messages where applicable.
 */
import java.util.Scanner;
import java.util.HashMap;
public class TW5 {
    public static void main(String[] args) throws Exception {
        HashMap<String,String> credentials = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String key, value;
        while(true){
            System.out.println("1.Add key value pair\n2.Retrieve value\n3.Retrieve all keys\n4.Retrieve all values\n5.Retrieve all key value pairs");
            System.out.println("6.Change value based on key\n7.Remove element\n8.Check if given value exists");
            int choice = in.nextInt();
            switch(choice){
                case 1: System.out.println("Enter key: ");
                        key = in.next();
                        System.out.println("Enter value: ");
                        value = in.next();
                        credentials.put(key,value);
                    break;
                case 2: System.out.println("Enter key to retrieve value: ");
                        key = in.next();
                        if(credentials.containsKey(key)){
                            System.out.println(credentials.get(key));
                        }
                        else{
                            System.out.println("given key is not in credentials");
                        }
                        break;
                case 3: System.out.println("Keys in the credentials are: " + credentials.keySet());
                        break;
                case 4: System.out.println("Values in the credentials are: " + credentials.values());
                        break;
                case 5: System.out.println("Following are the key value pairs: \n" + credentials);
                        break;
                case 6: System.out.println("Enter the key to replace its value: ");
                        key = in.next();
                        if(credentials.containsKey(key)){
                            System.out.println("Enter the new value: ");
                            value = in.next();
                            credentials.replace(key, value);
                        }
                        else{
                            System.out.println("Given key doesn't exist in credentials");
                        }
                        break;
                case 7: System.out.println("Enter the key to remove entry: ");
                        key = in.next();
                        if(credentials.containsKey(key)){
                            credentials.remove(key);
                        }
                        else{
                            System.out.println("Given key doesn't exists in credentials");
                        }
                        break;
                case 8: System.out.println("Enter the value: ");
                        value = in.next();
                        if(credentials.containsValue(value)){
                            System.out.println("Given value is present in credentials");
                        }
                        else{
                            System.out.println("Given value is not present in credentials");
                        }
                        break;
                default: System.exit(0);
                        break;
            }
        }

    }
}
