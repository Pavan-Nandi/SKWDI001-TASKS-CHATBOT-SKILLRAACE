public class Quiz {
    private String question;
    private String[] options;
    private int correctAnswer;
    public Quiz(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String[] getOptions() {
        return options;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    // Constructors, getters, and setters
}
