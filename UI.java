import java.util.Scanner;

public class UI {
    
    private TuitionManager tuitionManager;

    public UI(TuitionManager tuitionManager) {
        this.tuitionManager = tuitionManager;
    }

    public void addPelajarUI(Scanner sc) {

        String nama;
        String idPelajar;
        String alamatRumah;
        String jantina;
        int umur;

        System.out.print("Please enter the student's name: ");
        nama = sc.nextLine();

        System.out.print("Please enter the student's ID: ");
        idPelajar = sc.nextLine();

        System.out.print("Please enter the student's Address: ");
        alamatRumah = sc.nextLine();

        System.out.print("Please enter the student's Gender: ");
        jantina = sc.nextLine();

        System.out.print("Please enter the student's Age: ");
        umur = sc.nextInt();
        sc.nextLine(); // buang buffer

        String namaParent;
        String nomborPhone;
        String hubungan;
        String pekerjaan;

        System.out.print("Please enter the parent's Name: ");
        namaParent = sc.nextLine();

        System.out.print("Please enter the parent's Phone Number: ");
        nomborPhone = sc.nextLine();

        System.out.print("Please enter the parent's Status (mother/father): ");
        hubungan = sc.nextLine();

        System.out.print("Please enter the parent's Occupation: ");
        pekerjaan = sc.nextLine();

        Penjaga penjagaObject =
                new Penjaga(namaParent, nomborPhone, hubungan, pekerjaan);

        tuitionManager.addPelajar(
                nama, idPelajar, alamatRumah,
                jantina, umur, penjagaObject
        );

        System.out.println("✅ Student added successfully.");
    }

    public void modifyPelajarUI(Scanner sc) {
        System.out.print("Please enter the student's ID to modify: ");
        String idPelajar = sc.nextLine();
        
        System.out.print("Enter new address (or press Enter to skip): ");
        String newAddress = sc.nextLine();
        
        System.out.print("Enter new age (or -1 to skip): ");
        int newAge = sc.nextInt();
        sc.nextLine(); // buang buffer
        
        // Use null if address is empty
        if (newAddress.trim().isEmpty()) {
            newAddress = null;
        }
        
        tuitionManager.modifyPelajar(idPelajar, newAddress, newAge);
    }

    public void addKeputusanExamUI(Scanner sc) {
        System.out.print("Please enter the student's ID: ");
        String idPelajar = sc.nextLine();
        
        System.out.print("Please enter the subject name: ");
        String subjectName = sc.nextLine();
        
        System.out.print("Please enter the exam score (markah): ");
        int markah = sc.nextInt();
        sc.nextLine(); // buang buffer
        
        System.out.print("Please enter the grade (gred): ");
        String gred = sc.nextLine();
        
        tuitionManager.addKeputusanExam(idPelajar, subjectName, markah, gred);
    }

    public void deletePelajarUI(Scanner sc) { 
        // Implementation for deleting student
        System.out.println("helloworld");
    }
}