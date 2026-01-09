import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TuitionManager tuitionManager = new TuitionManager();
        UI ui = new UI(tuitionManager);
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            //
            System.out.println("\n" + Colors.CYAN + Colors.BOLD + "╔═══════════════════════════════════╗");
            System.out.println("║       TUITION MANAGER MENU        ║");
            System.out.println("╠═══════════════════════════════════╣" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  1. " + Colors.WHITE + "Manage Student                " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  2. " + Colors.WHITE + "Manage Student Result         " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  3. " + Colors.WHITE + "Sort Student                  " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  4. " + Colors.WHITE + "Search Student by ID          " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.BG_RED+ "  0. " + Colors.WHITE + "Exit                          " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "╚═══════════════════════════════════╝" + Colors.RESET);
            System.out.print(Colors.YELLOW + " ➤  Choice: " + Colors.RESET);

            int choice = sc.nextInt();
            sc.nextLine(); // buang buffer

            switch (choice) {

                // ================= MANAGE STUDENT =================
                case 1: {
            System.out.println("\n" + Colors.CYAN + Colors.BOLD + "╔═══════════════════════════════════╗");
            System.out.println("║        MANAGE STUDENT MENU        ║");
            System.out.println("╠═══════════════════════════════════╣" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  1. " + Colors.WHITE + "Add Student                   " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  2. " + Colors.WHITE + "Delete Student                " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  3. " + Colors.WHITE + "Modify Student                " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  4. " + Colors.WHITE + "Display Student               " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.BG_GREEN + "  5. " + Colors.WHITE + "Load Dummy Data               " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "║" + Colors.BG_RED + "  0. " + Colors.WHITE + "Back                          " + Colors.CYAN + "║" + Colors.RESET);
            System.out.println(Colors.CYAN + "╚═══════════════════════════════════╝" + Colors.RESET);
            System.out.print(Colors.YELLOW + " ➤  Student Choice: " + Colors.RESET);

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
                        System.out.println("\n" + Colors.CYAN + Colors.BOLD + "╔═══════════════════════════════════╗");
                        System.out.println("║    MANAGE STUDENT RESULT MENU     ║");
                        System.out.println("╠═══════════════════════════════════╣" + Colors.RESET);
                        System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  1. " + Colors.WHITE + "Add Student Result            " + Colors.CYAN + "║" + Colors.RESET);
                        System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  2. " + Colors.WHITE + "Remove last Student Result    " + Colors.CYAN + "║" + Colors.RESET);
                        System.out.println(Colors.CYAN + "║" + Colors.BG_RED + "  0. " + Colors.WHITE + "Back                          " + Colors.CYAN + "║" + Colors.RESET);
                        System.out.println(Colors.CYAN + "╚═══════════════════════════════════╝" + Colors.RESET);
                        System.out.print(Colors.YELLOW + " ➤  Result Choice: " + Colors.RESET);

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
                    System.out.println("\n" + Colors.CYAN + Colors.BOLD + "╔═══════════════════════════════════╗");
                    System.out.println("║         SORT STUDENT MENU         ║");
                    System.out.println("╠═══════════════════════════════════╣" + Colors.RESET);
                    System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  1. " + Colors.WHITE + "Sort Student by Name          " + Colors.CYAN + "║" + Colors.RESET);
                    System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  2. " + Colors.WHITE + "Sort Student by ID            " + Colors.CYAN + "║" + Colors.RESET);
                    System.out.println(Colors.CYAN + "║" + Colors.GREEN + "  3. " + Colors.WHITE + "Sort Student by Gender        " + Colors.CYAN + "║" + Colors.RESET);
                    System.out.println(Colors.CYAN + "║" + Colors.BG_RED + "  0. " + Colors.WHITE + "Back                          " + Colors.CYAN + "║" + Colors.RESET);
                    System.out.println(Colors.CYAN + "╚═══════════════════════════════════╝" + Colors.RESET);
                    System.out.print(Colors.YELLOW + " ➤  Sort Choice: " + Colors.RESET);

                    int sortoice = sc.nextInt();
                    sc.nextLine();

                    switch(sortoice){

                        case 1:{
                            tuitionManager.sortPelajarByName();
                            System.out.println(Colors.YELLOW + "\n System has sorted student by name");
                            break;
                        }
                        case 2:{
                            tuitionManager.sortPelajarByID();
                            System.out.println(Colors.YELLOW + "\n System has sorted student by ID");
                            break;
                        }
                        case 3:{
                            tuitionManager.sortPelajarByJantina();
                            System.out.println(Colors.YELLOW+ "\n System has sorted student by Gender");
                            break;
                        }
                        case 0:{
                            break;
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.print("\n Please enter student's ID: ");
                    String idpelajar = sc.nextLine();

                    tuitionManager.searchPelajarByID(idpelajar);
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
