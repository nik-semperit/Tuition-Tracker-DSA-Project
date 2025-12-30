public class keputusanExam { 
    
    // Nik Akmal Rc24116

    //Rubrik : Pengunaan variable
    public String subject;
    public int markah; 

    //Rubrik : node relationship
    public keputusanExam next;

    public keputusanExam(String subject, int markah) {
        this.subject = subject;
        this.markah = markah;
        this.next = null;
    }
}