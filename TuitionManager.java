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

        System.out.println("List of students with their respective grades");

        //while student linked list tak habis lagi
        while (current != null) {

            System.out.println("===================================");
            System.out.println(current.idPelajar + "-" + current.nama);
            System.out.println("===================================");

                //check kalau student ada grades atau tidak, kalau tak print "end of grades"

                // traverse satu stack grade student, printing detail dia dan pergi ke node seterusnya, ulang selagi ada
              while (current.keputusanExamTop != null) { 


                if (current.keputusanExamTop.subject != null) { 
                System.out.println("--------------------------------");
                System.out.println("Subject: " + current.keputusanExamTop.subject);
                System.out.println("Markah: " + current.keputusanExamTop.markah);
                System.out.println("Gred: " + current.keputusanExamTop.markah);  
                System.out.println("--------------------------------");
                current = current.next; // go to next node 

                } else {
                    System.out.println("End Of Grades");
                }

            } 

            if (current.keputusanExamTop == null) {
                System.out.println("No grades found for " + current.nama);
            }
            //traversing keputusan exam stack
            
        //goto next student
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