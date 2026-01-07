public class KeputusanExam {
    public String subject;
    public int markah;
    public String gred;
    public KeputusanExam next;

    public KeputusanExam(String subject, int markah, String gred) {
        this.subject = subject;
        this.markah = markah;
        this.gred = gred;
        this.next = null;
    }
}