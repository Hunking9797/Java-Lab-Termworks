/*
Write a multithreaded Java program to create 
 a list of numbers and then sort the contents in ascending (thread 1) and descending (thread 2).
 */
import java.util.Scanner;
import java.util.concurrent.Executors;

class Ascending extends Thread{
    int arr[];
    Ascending(int[] arr){
        this.arr = arr;
    }
    public void run(){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}

class Descending extends Thread{
    int arr[];
    Descending(int[] arr){
        this.arr = arr;
    }
    public void run(){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}

public class TW6 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = in.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the array elements: ");
        for(int i=0; i<size; i++){
            arr[i] = in.nextInt();
        }

        Ascending a = new Ascending(arr);
        System.out.println("Ascending order: ");
        a.start();
        try{
            Thread.sleep(100);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }

        Descending d = new Descending(arr);
        System.out.println("Descending order: ");
        d.start();
        try{
            Thread.sleep(100);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
