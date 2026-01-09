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
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    if (head.idPelajar.equals(idPelajar)) {
        head = head.next; 
        System.out.println("Student has been removed from the system");
        return;
    }

    Pelajar current = head;
    Pelajar prev = null;

    while (current != null && !current.idPelajar.equals(idPelajar)) {
        prev = current;
        current = current.next;
    }

    if (current == null) {
        System.out.println("Student ID" + idPelajar + " cannot be found");
        return;
    }

    prev.next = current.next;
    System.out.println("Student has been removed from the system");
    };

    public void modifyPelajar(String idPelajar, String newAlamat, int newUmur) {

    Pelajar found = findPelajar(idPelajar);

    if (found != null) {
        found.alamatRumah = newAlamat;
        found.umur = newUmur;
        
        System.out.println("Student information updated successfully.");
    } else {
        System.out.println("Error: Student with ID " + idPelajar + " not found.");
    }
    };


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

    public void showAllPelajar()    {
        Pelajar current = head;

        if (current == null) { 
            System.out.println("No Students in the database");
        }

        System.out.println("List of students");

        //traverse

        while (current != null) {
            System.out.println(current.idPelajar);
            System.out.println(current.nama);
            
            while (current.keputusanExamTop != null) { 

                System.out.println("Latest Subject: " + current.keputusanExamTop.subject);
                System.out.println("Latest Markah: " + current.keputusanExamTop.markah);
                System.out.println("Latest Gred: " + current.keputusanExamTop.markah);  
                
            }

            current = current.next;
        }
    };


    // --- sorting ---
    // rubrik : sorting  

    // Sort by Name
   public void sortPelajarByName() {
    if (head == null || head.next == null) {
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