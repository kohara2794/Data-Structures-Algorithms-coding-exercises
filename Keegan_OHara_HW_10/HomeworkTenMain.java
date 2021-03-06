/** Keegan O'Hara
    CS 124
    Homework 10 main class
    
    Codes from textbook utilized in Sort.java  */
    
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
    
public class HomeworkTenMain {
   
   public static void main(String [] args) throws IOException {
   
      // Declare the Arrays....regular arrays are used here because we
      //   know the size of them.
      Integer [] tenArray;
      Integer [] hundredArray;
      Integer [] thousandArray;     
      Integer [] tenKArray;
      Integer [] hundredKArray;
      Integer [] millionArray;

   
      // load up the arrays from the given files
      tenArray = loadArray("random_numbers/r_10.out");
      hundredArray = loadArray("random_numbers/r_100.out");
      thousandArray = loadArray("random_numbers/r_1k.out");
      tenKArray = loadArray("random_numbers/r_10k.out");
      hundredKArray = loadArray("random_numbers/r_100k.out");
      millionArray = loadArray("random_numbers/r_1m.out");
      
      //time variables
      long begin, end, elapsed;
      
      begin = System.nanoTime();
      Sort.insertionSort(tenArray);
      end = System.nanoTime();
      elapsed = (end - begin);
      System.out.println("Time for insertion, 10 items : " + elapsed + "\n");
      
      begin = System.nanoTime();
      Sort.insertionSort(hundredArray);
      end = System.nanoTime();
      elapsed = ((end - begin) / 1000000000);
      System.out.println("Time for insertion, 100 items : " + elapsed + "\n");
      
      begin = System.nanoTime();
      Sort.insertionSort(thousandArray);
      end = System.nanoTime();
      elapsed = ((end - begin) / 1000000000);
      System.out.println("Time for insertion, 1k items : " + elapsed + "\n");
      
      begin = System.nanoTime();
      Sort.insertionSort(tenKArray);
      end = System.nanoTime();
      elapsed = ((end - begin) / 1000000000);
      System.out.println("Time for insertion, 10k items : " + elapsed + "\n");
      
      begin = System.nanoTime();
      Sort.insertionSort(hundredKArray);
      end = System.nanoTime();
      elapsed = ((end - begin) / 1000000000);
      System.out.println("Time for insertion, 100k items : " + elapsed + "\n");
      
     //  begin = System.nanoTime();
      // Sort.insertionSort(millionArray);
//       end = System.nanoTime();
//       elapsed = ((end - begin) / 1000000000);
//       System.out.println("Time for insertion, 1m items : " + elapsed + "\n");










      printArray(tenArray);
      
      radixSort(tenArray);
      System.out.println("\nAfter radix sort\n");
      
      printArray(tenArray);      
      tenArray = loadArray("random_numbers/r_10.out");
      
      System.out.println("\nUnsorted??\n");
      printArray(tenArray);
      
     


      
   }
   
   
  
   /*  loadArray Method used for loading the values from the provided
        input files into arrayLists.
       @param String fileName, name of the file to read from
       @return ArrayList temp, the filled ArrayList to return   **/ 
  
   public static Integer [] loadArray(String fileName) throws IOException {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      
      File file = new File(fileName);
      Scanner inputFile = new Scanner(file);
      
      while (inputFile.hasNext())  {
         int number = inputFile.nextInt();
         temp.add(number);
      }
      Integer [] load = new Integer[temp.size()];
      for (int i = 0; i < temp.size(); i++) {
         load[i] = temp.get(i);
      }
      return load;
   }
   
   
   /*  Custom method for looping through and printing an ArrayList **/
   
   public static void printArray(Integer [] array) {
      for (int iterable_element : array) {
         System.out.println(iterable_element);
      }
   }

   
   
   /* radixSort method for using radixSort on a given ArrayList
      
      code from sanFoundry.com  **/
      
   public static void radixSort( Integer [] a)

    {

        int i, m = a[0], exp = 1, n = a.length;

        int[] b = new int[10];

        for (i = 1; i < n; i++)

            if (a[i] > m)

                m = a[i];

        while (m / exp > 0)

        {

            int[] bucket = new int[10];

 

            for (i = 0; i < n; i++)

                bucket[(a[i] / exp) % 10]++;

            for (i = 1; i < 10; i++)

                bucket[i] += bucket[i - 1];

            for (i = n - 1; i >= 0; i--)

                b[--bucket[(a[i] / exp) % 10]] = a[i];

            for (i = 0; i < n; i++)

                a[i] = b[i];

            exp *= 10;        

        }

    } 

         
      
}
      
      
      