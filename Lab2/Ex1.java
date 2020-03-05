package lab2;
import java.util.Scanner;

//Average of integers, stored in array, read until user inputs -1
public class Ex1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        int x, nr, total, i;
        int[] grades = new int[20];
        float m;
    
        nr = 0;
        
        x = scanner.nextInt();
        
        while (x != -1)
        {
            grades[nr] = x;
            nr++;
            x = scanner.nextInt();
        }
        
        total = 0;
        
        for (i = 0; i < nr; i++)
            total += grades[i];
            
        m = ((float) total)/nr;
        System.out.println(Float.toString(m));
    }
}















