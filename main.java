import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TuitionManager tuitionManagerObject = new TuitionManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("---Main Menu---");
        System.out.println("Please make a choice: ");
        System.out.println("1. Add Student");
        System.out.print("Choice : ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){
            case 1: {

                String nama_p;
                String idPelajar_p;
                String alamatRumah_p;
                String jantina_p;
                int umur_p;
                Penjaga penjagaObject_p;
                
                System.out.print("Please enter the student's name: ");
                nama_p = sc.nextLine();

                System.out.print("Please enter the student's ID: ");
                idPelajar_p = sc.nextLine();

                System.out.print("Please enter the student's Address: ");
                alamatRumah_p = sc.nextLine();

                System.out.print("Please enter the student's Gender: ");
                jantina_p = sc.nextLine();

                System.out.print("Please enter the student's Age : ");
                umur_p = sc.nextInt();
                sc.nextLine(); //buang buffer 
                
                String namaParent_p;
                String nomborPhone_p; 
                String hubungan_p; 
                String pekerjaan_p;

                System.out.print("Please enter the parent's Name : ");
                namaParent_p= sc.nextLine();

                System.out.print("Please enter the parent's Phone Number : ");
                nomborPhone_p = sc.nextLine();

                System.out.print("Please enter the parent's Status (mother/father) : ");
                hubungan_p = sc.nextLine();

                System.out.print("Please enter the parent's Occupation : ");
                pekerjaan_p = sc.nextLine();
                
                penjagaObject_p = new Penjaga(namaParent_p, nomborPhone_p, hubungan_p, pekerjaan_p);
                tuitionManagerObject.addPelajar(nama_p,idPelajar_p,alamatRumah_p,jantina_p,umur_p,penjagaObject_p);
                
                

            }

                //TuitionManager.addPelajar();
        }

    sc.close();

    }
}
