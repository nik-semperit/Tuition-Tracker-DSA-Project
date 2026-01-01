import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Main Menu: 1");
        System.out.println("Please make a choice: ");
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                TuitionManager.addPelajar( a,  b,  c,  d,  e,  f);
        }
        sc.close();
    }
}
