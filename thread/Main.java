import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

       Scanner sc = new Scanner(System.in);

       System.out.println("Enter Number Of Threads To Run:");
       int n = sc.nextInt();
       
       int x = 0;
       while (x != 1 && x != 2){
        System.out.println("Choose 1 for Thread or 2 for Runnable:");
        x = sc.nextInt();
       }

       if (x == 1){
        extendsThread(n);
       } else {
        implementsRunnable(n);
       }

       System.out.println("Quit? 1 for yes. 2 for no.");
       int quit = sc.nextInt();
       if (quit == 2){
        String[] arr = new String[0];
        main(arr);
       }

    }

    private static void extendsThread(int n){
        ArrayList<Multithreading> threads = new ArrayList<>();
       for (int i = 1; i <= n; i++){
        threads.add(new Multithreading(i));
       }

       for (Multithreading t : threads){
        t.start();
       }
    }

    private static void implementsRunnable(int n){
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            threads.add(new Thread(new runnableThread(i)));
        }

        for (Thread t: threads){
            t.start();
        }

    }
}