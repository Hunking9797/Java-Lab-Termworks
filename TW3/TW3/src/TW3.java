/*
 * 3]	Write a Java Program to demonstrate the implementation of reading and writing binary 
 * data in Java.
 * 1) Read the source and destination file names. 
 * 2) Read user defined text to be written to the source file. 
 * 3) Write every alternate byte from the source to the destination file. 
 * 4) Compare the properties of the file.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
public class TW3 {
    
    static String sourceFilename;
    static String targetFilename;
    static String inputFilename, outputFilename;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int flag = 1;
        while(flag == 1){
            System.out.println("1: Read the source and destination file names");
            System.out.println("2: Read user defined text to be written to the source file.");
            System.out.println("3: Write every alternate byte from the source to the destination file.");
            System.out.println("4: Compare the properties of the file.");
            int choice = in.nextInt();
            switch(choice){
                case 1: System.out.println("Enter source filename: ");
                        inputFilename = in.next();
                        sourceFilename = "C:\\Users\\nhale\\Desktop\\Java Programs\\TW3\\TW3\\src\\" + inputFilename + ".bin";
                        System.out.println("Enter target filename: ");
                        outputFilename = in.next();
                        targetFilename = "C:\\Users\\nhale\\Desktop\\Java Programs\\TW3\\TW3\\src\\" + outputFilename + ".bin";
                        break;
                case 2: System.out.println("Enter the text: ");
                        String userText = in.next();
                        byte buf[] = new byte[1024];
                        buf = userText.getBytes();
                        FileOutputStream fop = new FileOutputStream(sourceFilename);
                        fop.write(buf);
                        fop.close();
                        break;
                case 3: byte buffer[] = new byte[1024];
                        FileInputStream fip = new FileInputStream(sourceFilename);
                        FileOutputStream fop1 = new FileOutputStream(targetFilename);
                        fip.read(buffer);
                        int count = 0;
                        for(byte b : buffer){
                            if(count % 2 == 0){
                                fop1.write((char)b);
                            }
                            count++;
                        }
                        fop1.close();
                        fip.close();
                        break;

                case 4: File finput = new File(sourceFilename);
                        File foutput = new File(targetFilename);
                        System.out.println("Properties of source file: ");
                        System.out.println("Name: " + finput.getName());
                        System.out.println("Path: " + finput.getAbsolutePath());
                        System.out.println("Size: " + finput.length() + "bytes");

                        System.out.println("Properties of target file: ");
                        System.out.println("Name: " + foutput.getName());
                        System.out.println("Path: " + foutput.getAbsolutePath());
                        System.out.println("Size: " + foutput.length() + "bytes");
                        break;
            }
            System.out.println("Do you want to continue?(0/1)");
            flag = in.nextInt();
        }
        in.close();
    }
}
