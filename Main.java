import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TuitionManager tuitionManager = new TuitionManager();
        UI ui = new UI(tuitionManager);
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Manage Student");
            System.out.println("2. Manage Student Result");
            System.out.println("3. Sort Student");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buang buffer

            switch (choice) {

                // ================= MANAGE STUDENT =================
                case 1: {
                    System.out.println("\n--- Manage Student ---");
                    System.out.println("1. Add Student");
                    System.out.println("2. Delete Student");
                    System.out.println("3. Modify Student");
                    System.out.println("4. Display Student");
                    System.out.println("5. Load Dummy Data");
                    System.out.println("0. Back");
                    System.out.print("Student Choice: ");

                    int stuChoice = sc.nextInt();
                    sc.nextLine(); // buang buffer

                    switch (stuChoice) {
                        case 1:
                            ui.addPelajarUI(sc);
                            break;

                        case 2:
                            System.out.println("Please enter you student id:");
                            String idnumber = sc.nextLine();
                            tuitionManager.deletePelajar(idnumber);
                            break;

                        case 3:
                            ui.modifyPelajarUI(sc);
                            break;

                        case 4:
                            tuitionManager.showAllPelajar();
                            break;
                        
                        case 5:
                            tuitionManager.loadDummyData();

                        case 0:
                            break;

                        default:
                            System.out.println("❌ Invalid student menu choice.");
                    }
                    break;
                }

                // ================= MANAGE STUDENT RESULT =================
                case 2: {
                    System.out.println("\n--- Manage Student Result ---");
                    System.out.println("1. Add Student Result");
                    System.out.println("2. Remove last Student Result");
                    System.out.println("0. Back");
                    System.out.print("Result Choice: ");

                    int resChoice = sc.nextInt();
                    sc.nextLine(); // buang buffer

                    switch (resChoice) {
                        case 1:
                            ui.addKeputusanExamUI(sc);
                            break;

                        case 2:
                            System.out.println("Please enter your id:");
                            String idpelajar = sc.nextLine();

                            tuitionManager.removeLastKeputusanExam(idpelajar);
                            break;


                        case 0:
                            break;

                        default:
                            System.out.println("❌ Invalid result menu choice.");
                    }
                    break;
                }
                // ================== SORT ==================
                case 3: {
                    System.out.println("\n--- Sort Student  ---");
                    System.out.println("1. Sort student by name");
                    System.out.println("2. Sort student by id");
                    System.out.println("3. Sort stundet by gender");
                    System.out.println("0. Back");
                    System.out.print("Sort Choice: ");

                    int sortoice = sc.nextInt();
                    sc.nextLine();

                    switch(sortoice){
                        case 1:{
                            tuitionManager.sortPelajarByName();
                            System.out.println("System has sorted student by name");
                            break;
                        }
                        case 2:{
                            tuitionManager.sortPelajarByID();
                            System.out.println("System has sorted student by ID");
                            break;
                        }
                        case 3:{
                            tuitionManager.sortPelajarByJantina();
                            System.out.println("System has sorted student by Gender");
                            break;
                        }
                        case 0:{
                            break;
                        }
                    }
                    break;
                }

                // ================= EXIT =================
                case 0:
                    running = false;
                    System.out.println("👋 Exiting system...");
                    break;

                default:
                    System.out.println("❌ Invalid main menu choice.");
            }
        }

        sc.close();
    }
}
