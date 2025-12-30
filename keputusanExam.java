public class KeputusanExam { 
    
    // Nik Akmal Rc24116

    //Rubrik : Pengunaan variable
    public String subject;
    public int markah; 
    public String gred; 

    //Rubrik : node relationship
    public KeputusanExam next;

    public KeputusanExam(String subject, int markah, String gred) {
        this.subject = subject;
        this.markah = markah;
        this.gred = gred;
        this.next = null;
    }
}