package BiShe.度小满;

public class Main {

   static int foo(int n){
        if (n<=2)
            return n;
        return foo(n-1)+foo(n-2);
    }

    public static void main(String[] args) {
        System.out.println(foo(5));
    }
}
