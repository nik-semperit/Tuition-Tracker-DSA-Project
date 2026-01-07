enum ExamPhase {
    FIRST,
    MID,
    FINAL
}

public class KeputusanExam {
    public String subject;
    public int markah;
    public String gred;
    public ExamPhase examPhase;
    public KeputusanExam next;

    public KeputusanExam(String subject, int markah, String gred, ExamPhase examPhase) {
        this.subject = subject;
        this.markah = markah;
        this.gred = gred;
        this.examPhase = examPhase;
        this.next = null;
    }
}