public class Recursion_Basics{

    public static void print_num(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        // if(n>1)
        print_num(n - 1);
    }

    public static void printnum(int n) {
        if (n > 5)
            return;
        System.out.println(n);
        printnum(n + 1);
    }
    
    public static int printsum(int n) {
        if (n == 1)
            return 1;
        int sum = n + printsum(n - 1);
        return sum;
    }
    
    public static int factorial(int n) {
        if (n == 1 || n == 0)
            return 1;

        return  n * factorial(n - 1);
    }

    public static void fibbonacci(int a, int b, int n) {
        /* System.out.print(a + " " + b + " ");
        print this term in main function 
         */
        if (n == 2)
            return;

        int c = a + b;
        System.out.print(c + " ");
        fibbonacci(b, c, n - 1);
    }
    // "Stack Height : n"
    public static int x_n(int x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        return x * x_n(x, n - 1);
    }

    
    //????????????????????????????????????????
    // "Stack Height : log(n)"
    public static int x_n_logn(int x, int n) {
        if (n == 0)
            return 1;
        
        if (x == 0)
            return 0;
            
        if(n%2==0)
            return x_n_logn(x, n / 2) * x_n_logn(x, n / 2);
        else
            return x * x_n_logn(x, n / 2) * x_n_logn(x, n / 2);
    }

    public static void main(String args[]) {
        print_num(5);
        printnum(1);
        System.out.println(printsum(5));
        System.out.println(factorial(5));
        System.out.print(0 + " " + 1 + " ");
        fibbonacci(0, 1, 10);
        System.out.println("\n" + x_n(2, 10) );
        System.out.println(x_n_logn(2, 10) );
    }
}
