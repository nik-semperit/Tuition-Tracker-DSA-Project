public class KeputusanExam { 
    
    // Nik Akmal Rc24116

    //Rubrik : Pengunaan variable
    public String subject;
    public int markah; 

    //Rubrik : node relationship
    public KeputusanExam next;

    public KeputusanExam(String subject, int markah) {
        this.subject = subject;
        this.markah = markah;
        this.next = null;
    }
}