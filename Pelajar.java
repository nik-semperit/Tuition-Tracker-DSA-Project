public class Pelajar { 

    // Nik Akmal Rc24116

    public String nama;
    public String idPelajar;
    public String alamatRumah;
    public String jantina;
    public int umur;
    

    // Rubric : node relationship

    public Penjaga penjagaObject;
    public KeputusanExam keputusanExamTop; 

    // Rubric : Linked list, pointer node seterusnya. 

    public Pelajar next;

    
    public Pelajar(String nama, String idPelajar, String alamatRumah, String jantina, int umur, Penjaga penjagaObject) { 
        this.nama = nama;
        this.idPelajar = idPelajar; 
        this.alamatRumah = alamatRumah;
        this.jantina = jantina;
        this.umur = umur;

        this.penjagaObject = penjagaObject;
        this.keputusanExamTop = null; // Initialize list keputusan untuk setiap student
        this.next = null;

    }

    public String getIdPelajar() {
        return idPelajar;
    }

}