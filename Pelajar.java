public class Pelajar { 

    // Nik Akmal Rc24116

    public String nama;
    public String idPelajar;

    // Rubric : node relationship

    public Penjaga penjagaObject;
    public keputusanExam keputusanExamTop; 

    // Rubric : Linked list, pointer node seterusnya. 

    public Pelajar next;

    public Pelajar(String nama, String idPelajar, Penjaga penjagaObject) { 
        this.nama = nama;
        this.idPelajar = idPelajar; 
        this.penjagaObject = penjagaObject;
        this.keputusanExamTop = null; // Initialize list keputusan untuk setiap student
        this.next = null;
        
    }
}