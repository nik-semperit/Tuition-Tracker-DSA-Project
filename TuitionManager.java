public class TuitionManager { 

    private Pelajar head; //Pointer untuk senarai pelajar (pelajar pertama)

    public TuitionManager() {
    this.head = null;
    }


    public void addPelajar(String nama, String idPelajar, Penjaga penjagaObject){
        Pelajar newPelajarObject = new Pelajar(nama, idPelajar, penjagaObject);

        if (head == null){
            head = newPelajarObject;
        }

        else { 
            Pelajar current = head;

            while (current.next != null) { 
                current = current.next; 
            }

            current.next = newPelajarObject;
        }

    };


    public void deletePelajar() {

    };

    
    public Pelajar findPelajar(String idPelajar) {
        Pelajar current = head;
        while (current != null) {
            if(current.idPelajar.equals(idPelajar)) { 
                return current;
            }
            current = current.next;
        }
        return null;
    };



    // --- STACK ---

    // rubrik : stack push
    public void addKeputusanExam() {

    }; 
    
     // rubrik stack pop;
    public void removeLastKeputusanExam() {

    };



    // --- SORTING ---
    // rubrik : sorting  
    public void sortPelajarByName(){

    };

    public void showAllPelajar(){

    };
    

}