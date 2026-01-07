import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TuitionManager tuitionManagerObject = new TuitionManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("---Main Menu---");
        System.out.println("Please make a choice: ");
        System.out.println("1. Add Student");
        System.out.println("2. Add Subject Result");
        System.out.println("3. show all pelajar");
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

            case 2: {

                System.out.print("Enter Student ID: ");
                String searchID = sc.nextLine();

                // Find student
                Pelajar pelajar = tuitionManagerObject.findPelajar(searchID);

                if (pelajar == null) {
                    System.out.println("❌ Student not found.");
                } 
                else {
                    // Student found → add subject result
                    System.out.print("Enter Subject Name: ");
                    String subject = sc.nextLine();

                    System.out.print("Enter Markah: ");
                    int markah = sc.nextInt();
                    sc.nextLine(); // buang buffer

                    System.out.print("Enter Grade: ");
                    String gred = sc.nextLine();

                    // STACK PUSH (KeputusanExam)
                    KeputusanExam newExam = new KeputusanExam(subject, markah, gred);
                    newExam.next = pelajar.keputusanExamTop;
                    pelajar.keputusanExamTop = newExam;

                    System.out.println("✅ Subject result added successfully.");
                    }

                    break;
                }

            case 3: {
                tuitionManagerObject.showAllPelajar();
            }
        }

    sc.close();

    }
}
