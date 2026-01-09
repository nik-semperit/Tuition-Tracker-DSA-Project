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
    public void addKeputusanExam() {

    }; 
    
     // rubrik stack pop;
    public void removeLastKeputusanExam() {

    };

    //--- traverse list --- 

    public void showAllPelajar()    {

    };


    // --- sorting ---
    // rubrik : sorting  
    public void sortPelajarByName(){

    };

    public void sortPelajarByID(){

    };
}