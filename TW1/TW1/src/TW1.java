/*
 1]	Write a menu driven Java program to read contents of a file and :
  a) print characters on the console – one character at a time 
  b) print the entire file 
  c) print contents to another file. 
  Read both source & target file names & check for their 
  existence/ non – existence to take appropriate actions.
 */
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class TW1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int flag = 1;

        while(flag == 1){
            System.out.println("1: print characters on the console – one character at a time");
            System.out.println("2: print the entire file");
            System.out.println("3: print contents to another file.");
            System.out.println("Enter a choice: ");
            int choice = in.nextInt();
            switch(choice){
                case 1: FileInputStream fip = new FileInputStream("C:\\Users\\nhale\\Desktop\\Java Programs\\TW1\\TW1\\src\\input.txt");
                        int ch = fip.read();
                        while(ch != -1){
                            System.out.print((char)ch);
                            ch = fip.read();
                        }
                        System.out.println();
                        fip.close();
                        break;
                case 2: FileInputStream fip1 = new FileInputStream("C:\\Users\\nhale\\Desktop\\Java Programs\\TW1\\TW1\\src\\input.txt");
                        byte bArray[] = new byte[100];
                        fip1.read(bArray);
                        for(byte b: bArray){
                            System.out.print((char)b);
                        }
                        System.out.println();
                        fip1.close();
                        break;
                case 3: FileOutputStream fop = new FileOutputStream("C:\\Users\\nhale\\Desktop\\Java Programs\\TW1\\TW1\\src\\output.txt");
                        FileInputStream fip2 = new FileInputStream("C:\\Users\\nhale\\Desktop\\Java Programs\\TW1\\TW1\\src\\input.txt");
                        byte buf[] = new byte[100];
                        fip2.read(buf);
                        fop.write(buf);
                        fip2.close();
                        fop.close();
                        break;
            }
            System.out.println("Do you want to continue?(1/0)");
            flag = in.nextInt();
        }
        
    }
}
