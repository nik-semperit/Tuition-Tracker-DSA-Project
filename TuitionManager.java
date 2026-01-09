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


    public void deletePelajar() {

    };

    public void modifyPelajar() {

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