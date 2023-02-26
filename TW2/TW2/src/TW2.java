import java.util.Scanner;

/*
    Write a Java Program to demonstrate the implementation of stream classes in Java. 
    Assume that an input file named "input.txt" already exists with few lines of random text.
     Accept a filename from the user, this will be the destination file.
      Write a menu driven program to do the following:
       1) Transfer the contents of the input file to the destination file using the
        ByteArrayInputStream /ByteArrayInputStream class 
 3) Display the contents of the destination file.
 */
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
class TW2 {
    static String destinationFilename;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int flag = 1;
        while(flag == 1){
            System.out.println("1: Transfer the contents of the input file to the destination file using ByteArrayInputStream, Transfer the contents of the input file to the destination file using ByteArrayOutputStream");
            System.out.println("2: Display the contents of the destination file");
            int choice = in.nextInt();
            switch(choice){
                case 1: String filename;
                        System.out.println("Enter destination filename");
                        filename = in.nextLine();
                        destinationFilename = "C:\\Users\\nhale\\Desktop\\Java Programs\\TW2\\TW2\\src\\" + filename + ".txt";
                        byte buf[] = new byte[1024];
                        FileInputStream fi = new FileInputStream("C:\\Users\\nhale\\Desktop\\Java Programs\\TW2\\TW2\\src\\input.txt");
                        System.out.println(fi.toString());
                        ByteArrayInputStream bi = new ByteArrayInputStream(buf);
                        ByteArrayOutputStream bo = new ByteArrayOutputStream();
                        bo.write(buf);

                        break;
                case 2:
                        break;
                case 3: System.exit(0);
                        break;
            }
            System.out.println("Do you want to continue?(0/1)");
            flag = in.nextInt();
        }
        in.close();
    }
}
