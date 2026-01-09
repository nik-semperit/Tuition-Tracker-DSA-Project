public class TuitionManager { 

    private Pelajar head; //Pointer untuk senarai pelajar (pelajar pertama)

    public TuitionManager() {
    this.head = null;
    }


    public void addPelajar(String nama, String idPelajar, String alamatRumah, String jantina, int umur, Penjaga penjagaObject){

        // buat node pelajar
        Pelajar newPelajarObject = new Pelajar(nama, idPelajar,  alamatRumah,  jantina,  umur, penjagaObject);

        // check kalau list wujud ke tak, kalau tak wujud then buat node pertama
        if (head == null){
            head = newPelajarObject;
        }

        else     { 

            // current ialah head
            Pelajar current = head;

            // selagi node seterusnya tak kosong, pergi ke node seterusnya 
            while (current.next != null) { 
                current = current.next;
            }

            // Bila jumpa node seterusnya yang ada ruang kosong, sambungkan node ke tempat kosong tersebut
            current.next = newPelajarObject;
            System.out.println("Student added : " + current.nama);
            sleep(300);

        }


    };

    // RC23325 Vikneswaran

    public void deletePelajar(String idPelajar) {

    // Step 1: check if list empty
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    // Step 2: use findPelajar
    Pelajar target = findPelajar(idPelajar);

    if (target == null) {
        System.out.println("Student ID " + idPelajar + " cannot be found");
        return;
    }

    // Step 3: if target is head
    if (head == target) {
        head = head.next;
        System.out.println("Student has been removed from the system");
        return;
    }

    // Step 4: find previous node
    Pelajar current = head;

    while (current.next != null && current.next != target) {
        current = current.next;
    }

    // Step 5: bypass target
    if (current.next == target) {
        current.next = target.next;
        System.out.println("Student has been removed from the system");
    }
}


    public void modifyPelajar(String idPelajar, String newAlamat, int newUmur) {

    Pelajar found = findPelajar(idPelajar);

    if (found == null) {
        System.out.println("\nError: Student with ID " + idPelajar + " not found.");
        return;
    }

    // Modify address only if provided
    if (newAlamat != null) {
        found.alamatRumah = newAlamat;
    }

    // Modify age only if provided
    if (newUmur != -1) {
        found.umur = newUmur;
    }

    System.out.println("Student information updated successfully.");
}



    public Pelajar findPelajar(String idPelajar) {
        // current node = first node
        Pelajar current = head;

        // selagi node tidak kosong
        while (current != null) {

            // Kalau idpelajar node idpelajar di node sekarang sama dengan idpelajar di node yang diminta, berhenti mencari (return) 
            if(current.idPelajar.equals(idPelajar)) { 
                return current;
            }

            current = current.next;
        }
        return null;
    };

    // RC23325 Vikneswaran

    // rubrik : searching
    public void searchPelajarByID(String idPelajar) {
        Pelajar current = head; 
        boolean found = false;

        while (current != null) {
            if (current.idPelajar.equals(idPelajar)) {
                System.out.println("\nStudent Found");
                System.out.println("Name: " + current.nama);
                System.out.println("ID: " + current.idPelajar);
                System.out.println("Address: " + current.alamatRumah);
                System.out.println("Age: " + current.umur);
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Student with ID " + idPelajar + " is not registered in the system.");
        }
    }

    // --- stack operation ---

    // rubrik : stack push
    public void addKeputusanExam(String idpelajar, String subjectName, int markah, String gred) {
        
        //cari student
        Pelajar targetPelajar = findPelajar(idpelajar);

        //check kalau student tu wujud
        if ( targetPelajar == null) { 
            System.out.println("Error : Student ID " + idpelajar + " not found.");
            return;
        }

        //buat node keputusan 
        KeputusanExam keputusanPelajar = new KeputusanExam(subjectName, markah, gred);


        //sambungkan node keputusan baru ke keputusan lama  (insert at head)
        keputusanPelajar.next = targetPelajar.keputusanExamTop; 

        //keputusan pelajar swap most recent node at top
        targetPelajar.keputusanExamTop = keputusanPelajar;
        
        sleep(300);
        System.out.println("Exam result added for " + targetPelajar.nama);

    }; 
    
     // rubrik stack pop;
    public void removeLastKeputusanExam(String idpelajar) {
        Pelajar targetPelajar = findPelajar(idpelajar);
        
        if ( targetPelajar == null) { 
                System.out.println("Error : Student ID " + idpelajar + " not found.");
                return;
        }

        if (targetPelajar.keputusanExamTop == null) { 
            System.out.println("No grade data available in " + targetPelajar.nama + "'s" + " grades.");
            return;
        }

        KeputusanExam removedExam = targetPelajar.keputusanExamTop;
        
        System.out.println("Removing last's exam's result: " + removedExam.subject + "from " + targetPelajar.nama + "'s" + " database");

    };


    //--- traverse list --- 

public void showAllPelajar() {
    Pelajar current = head;

    // --- CASE: EMPTY DATABASE ---
    if (current == null) {
        System.out.println("\n" + Colors.CYAN + "╔══════════════════════════════════════════════════╗");
        System.out.println("║ " + Colors.RED + "         NO STUDENTS IN THE DATABASE            " + Colors.CYAN + " ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Colors.RESET);
        return;
    }

    System.out.println("\n" + Colors.CYAN + Colors.BOLD + ">>> LIST OF STUDENTS GENERATING..." + Colors.RESET);

    // --- TRAVERSE STUDENTS ---
    while (current != null) {
        sleep(200); // Keep your delay effect
        
        // Top of the Student Card
        System.out.println("\n" + Colors.CYAN + "╔══════════════════════════════════════════════════╗");
        System.out.println("║ " + Colors.YELLOW + "STUDENT RECORD" + Colors.CYAN + "                                   ║");
        System.out.println("╠══════════════════════════════════════════════════╣" + Colors.RESET);
        
        // Student Details (Using printf for alignment)
        System.out.printf(Colors.CYAN + "║" + Colors.WHITE + " Name   : %-39s " + Colors.CYAN + "║\n", current.nama);
        System.out.printf(Colors.CYAN + "║" + Colors.WHITE + " ID     : %-39s " + Colors.CYAN + "║\n", current.idPelajar);
        System.out.printf(Colors.CYAN + "║" + Colors.WHITE + " Gender : %-39s " + Colors.CYAN + "║\n", current.jantina);


        // --- EXAM RESULTS SECTION ---
        if (current.keputusanExamTop != null) {
            KeputusanExam examCurrent = current.keputusanExamTop;
            
            // Table Header for Grades
            System.out.println(Colors.CYAN + "╠══════════════════════════════════════════════════╣");
            System.out.println("║ " + Colors.GREEN + "SUBJECT                MARK    GRADE             " + Colors.CYAN + "║");
            System.out.println("╠══════════════════════════════════════════════════╣" + Colors.RESET);

            sleep(500); // Slightly reduced sleep for smoother UX
            
            while (examCurrent != null) {
                // Formatting: Subject (22 chars), Mark (7 chars), Grade (15 chars)
                System.out.printf(Colors.CYAN + "║ " + Colors.WHITE + "%-22s %-7s %-15s " + Colors.CYAN + "  ║\n", 
                                  examCurrent.subject, 
                                  examCurrent.markah, 
                                  examCurrent.gred);
                examCurrent = examCurrent.next;
            }
        } else {
            // Case: Student exists but has no grades
            System.out.println(Colors.CYAN + "╠══════════════════════════════════════════════════╣");
            System.out.println("║ " + Colors.RED + "NO GRADE RECORDS FOUND                           " + Colors.CYAN + "║");
        }

        // Bottom of the Student Card
        System.out.println(Colors.CYAN + "╚══════════════════════════════════════════════════╝" + Colors.RESET);

        current = current.next; // Move to next student
    }
    System.out.println(Colors.CYAN + ">>> END OF LIST" + Colors.RESET);
}


    // --- sorting ---
    // rubrik : sorting  

    // Sort by Name
   public void sortPelajarByName() {
    if (head == null || head.next == null) {
        System.out.println("Empty list");
        // List is empty or ada 1 ja student.
        return;
    }

    boolean swapped;
    Pelajar current;
    Pelajar last = null; 

    do {
        swapped = false;
        current = head;

        while (current.next != last) {

            if (current.nama.compareToIgnoreCase(current.next.nama) > 0) {
                // Swap the data, bukan node.
                swapPelajarData(current, current.next);
                swapped = true;
            }
            current = current.next;
        }
        last = current; // After each pass, the largest element "bubbles" to the end
    } while (swapped);
}

// Sort by ID
public void sortPelajarByID() {
    if (head == null || head.next == null) {
        return;
    }

    boolean swapped;
    Pelajar current;
    Pelajar last = null;

    do {
        swapped = false;
        current = head;

        while (current.next != last) {
            // Compare current dan Student IDs yang seterusnya.
            if (current.idPelajar.compareTo(current.next.idPelajar) > 0) {
                swapPelajarData(current, current.next);
                swapped = true;
            }
            current = current.next;
        }
        last = current; // Largest ID bubbles to the end
    } while (swapped);
}

//Sort by Jantina
public void sortPelajarByJantina() {
    if (head == null || head.next == null) {
        return;
    }

    boolean swapped;
    Pelajar current;
    Pelajar last = null;

    do {
        swapped = false;
        current = head;

        while (current.next != last) {
            // Compare Jantina of student terkini ngan seterusnya.
            if (current.jantina.compareToIgnoreCase(current.next.jantina) > 0) {
                swapPelajarData(current, current.next);
                swapped = true;
            }
            current = current.next;
        }
        last = current; // "largest" jantina (P), moves to the end.
    } while (swapped);
}


// Method utk Swap data between dua node Pelajar
private void swapPelajarData(Pelajar p1, Pelajar p2) {

    // Swap  utk nama
    String tempNama = p1.nama;
    p1.nama = p2.nama;
    p2.nama = tempNama;

    // Swap utk idPelajar
    String tempId = p1.idPelajar;
    p1.idPelajar = p2.idPelajar;
    p2.idPelajar = tempId;

    // Swap utk alamatRumah
    String tempAlamat = p1.alamatRumah;
    p1.alamatRumah = p2.alamatRumah;
    p2.alamatRumah = tempAlamat;

    // Swap utk jantina
    String tempJantina = p1.jantina;
    p1.jantina = p2.jantina;
    p2.jantina = tempJantina;

    // Swap utk umur
    int tempUmur = p1.umur;
    p1.umur = p2.umur;
    p2.umur = tempUmur;

    // Swap utk penjagaObject
    Penjaga tempPenjaga = p1.penjagaObject;
    p1.penjagaObject = p2.penjagaObject;
    p2.penjagaObject = tempPenjaga;
}

// data dan utility dibawah

public void loadDummyData() {
// 1. Male student - Ahmad
    addPelajar("Ahmad bin Ali", "S001", "No. 12, Jalan Melati, Kuala Lumpur", "L", 15, new Penjaga("Ali bin Hassan", "012-3456789", "Bapa", "Engineer"));

    // 2. Female student - Siti
    addPelajar("Siti Nurhaliza", "S002", "Blok A-3-5, Taman Damai, Petaling Jaya", "P", 14, new Penjaga("Maimunah binti Ahmad", "013-9876543", "Ibu", "Teacher"));

    // 3. Male student - Kumar
    addPelajar("Kumar a/l Rajan", "S003", "15, Lorong Kenari 3, Shah Alam", "L", 16, new Penjaga("Rajan a/l Muthu", "019-2345678", "Bapa", "Accountant"));

    // 4. Female student - Mei Ling
    addPelajar("Tan Mei Ling", "S004", "88, Jalan Bunga Raya, Ipoh", "P", 15, new Penjaga("Tan Chee Keong", "016-7654321", "Bapa", "Businessman"));

    // 5. Male student - Danial
    addPelajar("Danial Izzat", "S005", "23-A, Taman Sri Muda, Selangor", "L", 13, new Penjaga("Zainab binti Osman", "017-8889999", "Ibu", "Nurse"));

    // 6. Female student - Aisha
    addPelajar("Aisha Sofea", "S006", "No. 7, Jalan Merbau, Johor Bahru", "P", 14, new Penjaga("Fatimah binti Yusof", "018-3334444", "Ibu", "Doctor"));

    // 7. Male student - Wei Jie
    addPelajar("Lim Wei Jie", "S007", "Block C-12-8, Plaza Indah, Penang", "L", 16, new Penjaga("Lim Ah Hock", "011-2223333", "Bapa", "Chef"));

    // 8. Female student - Priya
    addPelajar("Priya a/p Suresh", "S008", "45, Taman Sentosa, Klang", "P", 13, new Penjaga("Latha a/p Krishnan", "014-5556666", "Ibu", "Pharmacist"));

    // 9. Male student - Amin
    addPelajar("Amin Hakim", "S009", "78, Jalan Cempaka 5, Kuantan", "L", 15, new Penjaga("Hakim bin Razak", "015-7778888", "Bapa", "Pilot"));

    // 10. Female student - Nurul
    addPelajar("Nurul Aina", "S010", "32-B, Taman Melawati, Ampang", "P", 14, new Penjaga("Rozita binti Ibrahim", "010-1112222", "Ibu", "Lawyer"));


    // Student S001 - Ahmad (3 subjects)
    addKeputusanExam("S001", "Mathematics", 85, "A");
    addKeputusanExam("S001", "Science", 78, "B+");
    addKeputusanExam("S001", "English", 92, "A+");

    // Student S002 - Siti (4 subjects)
    addKeputusanExam("S002", "Mathematics", 90, "A+");
    addKeputusanExam("S002", "Bahasa Melayu", 88, "A");
    addKeputusanExam("S002", "History", 76, "B+");
    addKeputusanExam("S002", "Science", 82, "A-");

    // Student S003 - Kumar (3 subjects)
    addKeputusanExam("S003", "Physics", 95, "A+");
    addKeputusanExam("S003", "Chemistry", 89, "A");
    addKeputusanExam("S003", "Mathematics", 91, "A+");

    // Student S004 - Mei Ling (4 subjects)
    addKeputusanExam("S004", "English", 87, "A");
    addKeputusanExam("S004", "Chinese", 93, "A+");
    addKeputusanExam("S004", "Mathematics", 79, "B+");
    addKeputusanExam("S004", "Art", 85, "A");

    // Student S005 - Danial (3 subjects)
    addKeputusanExam("S005", "Science", 72, "B");
    addKeputusanExam("S005", "Mathematics", 68, "B-");
    addKeputusanExam("S005", "Geography", 75, "B+");

    // Student S006 - Aisha (5 subjects)
    addKeputusanExam("S006", "Biology", 94, "A+");
    addKeputusanExam("S006", "Chemistry", 91, "A+");
    addKeputusanExam("S006", "Physics", 88, "A");
    addKeputusanExam("S006", "Mathematics", 90, "A+");
    addKeputusanExam("S006", "English", 86, "A");

    // Student S007 - Wei Jie (3 subjects)
    addKeputusanExam("S007", "Economics", 80, "A-");
    addKeputusanExam("S007", "Business Studies", 83, "A-");
    addKeputusanExam("S007", "Accounting", 77, "B+");

    // Student S008 - Priya (4 subjects)
    addKeputusanExam("S008", "Tamil", 96, "A+");
    addKeputusanExam("S008", "Mathematics", 84, "A");
    addKeputusanExam("S008", "Science", 81, "A-");
    addKeputusanExam("S008", "Music", 89, "A");

    // Student S009 - Amin (3 subjects)
    addKeputusanExam("S009", "Islamic Studies", 92, "A+");
    addKeputusanExam("S009", "Arabic", 87, "A");
    addKeputusanExam("S009", "History", 79, "B+");

    System.out.println(Colors.YELLOW + "\n System : Loaded dummy data loaded successfully.");

}

public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}