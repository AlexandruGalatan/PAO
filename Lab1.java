import java.util.Scanner;

public class ex
{
    public static void main(String[] args)
    {
        ex1();
    }

    public static void ex1()
    {
        for (int i = 1; i <= 99; i = i + 2)
            System.out.println(i);
    }
    
    public static void ex2()
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("x = ");
        int x = scanner.nextInt();
        
        System.out.print("y = ");
        int y = scanner.nextInt();
        
        String xstr = Integer.toString(x);
        String ystr = Integer.toString(y);
        
        if (x == y)
            System.out.println(xstr.concat(" = ").concat(ystr));
        else
        {
            System.out.println(xstr.concat(" != ").concat(ystr));
            if (x < y)
            {
               System.out.println(xstr.concat(" < ").concat(ystr));
               System.out.println(xstr.concat(" <= ").concat(ystr));
            }
            else
            {
                System.out.println(xstr.concat(" > ").concat(ystr));
               System.out.println(xstr.concat(" >= ").concat(ystr));
            }
        }
            
        
    }
    
    public static void ex3()
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("n = ");
        int n = scanner.nextInt();
        int s = 0;
        
        for (int i = 1; i <= n; i++)
            if (i % 5 == 0 || i % 3 == 0)
                s += i;
        
        System.out.println(s);
    }
    
    public static void ex4()
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("n = ");
        int n = scanner.nextInt();
        int f = 1;
        
        for (int i = 2; i <= n; i++)
            f = f * i;
        
        System.out.println(f);
    }
    
    public static void ex5()
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("n = ");
        int n = scanner.nextInt();
        int nr = 0;
        
        for (int i = 2; i <= n/2; i++)
            if (n % i == 0)
                nr++;
        
        System.out.println(nr == 0);
    }
    
    public static void ex6()
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("n = ");
        int n = scanner.nextInt();
        int tot = 0;
        int last1 = 0;
        int last2 = 1;
        
        for (int i = 2; i < n; i++)
        {
            tot = last1 + last2;
            last1 = last2;
            last2 = tot;
        }
        
        System.out.println(tot);
    }
    
    public static void ex7()
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("n = ");
        int n = scanner.nextInt();
        int mare = 1;
        
        for (int i = 2; i <= n/2; i++)
            if (n % i == 0)
                mare = i;
        
        System.out.println(mare);
    }
}


