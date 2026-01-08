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
    public void removeLastKeputusanExam() {

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
    public void sortPelajarByName(){

    };

    public void sortPelajarByID(){

    };
}