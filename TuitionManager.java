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
        System.out.println("Error: Student with ID " + idPelajar + " not found.");
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
            System.out.println("Error : Student ID " + idpelajar + "not found.");
            return;
        }

        //buat node keputusan 
        KeputusanExam keputusanPelajar = new KeputusanExam(subjectName, markah, gred);


        //sambungkan node keputusan baru ke keputusan lama  (insert at head)
        keputusanPelajar.next = targetPelajar.keputusanExamTop; 

        //keputusan pelajar swap most recent node at top
        targetPelajar.keputusanExamTop = keputusanPelajar;
        

        System.out.println("Exam result added for " + targetPelajar.nama);
    }; 
    
     // rubrik stack pop;
    public void removeLastKeputusanExam(String idpelajar) {
        Pelajar targetPelajar = findPelajar(idpelajar);
        
        if ( targetPelajar == null) { 
                System.out.println("Error : Student ID " + idpelajar + "not found.");
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

    if (current == null) { 
        System.out.println("No Students in the database");
        return; // Add return here to exit the method
    }

    System.out.println("List of students");

    // Traverse through all students
    while (current != null) {
        System.out.println("=======================================");
        System.out.println(" RECORD FOR STUDENT : " + current.nama + "  ID: " + current.idPelajar);
        System.out.println("=======================================");
        
        if (current.keputusanExamTop != null) {
            // Use a DIFFERENT variable for traversing exam results
            KeputusanExam examCurrent = current.keputusanExamTop;
            
            while (examCurrent != null) { 
                System.out.println("-------------------------------------------------");
                System.out.println("Subject: " + examCurrent.subject);
                System.out.println("Markah: " + examCurrent.markah);
                System.out.println("Gred: " + examCurrent.gred);  // Fixed: was showing markah twice
                
                examCurrent = examCurrent.next; // Move to next exam result
            }   
            
            System.out.println("End of report for : " + current.nama);
        } else { 
            System.out.println("Grade records for " + current.nama + "  ID: " + current.idPelajar + " not found.");
        }

        current = current.next; // Move to next student (OUTSIDE the exam loop)
    }
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
}