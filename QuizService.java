import java.util.ArrayList;
import java.util.List;

public class QuizService {
    private List<Quiz> quizzes = new ArrayList<>();
    
    public QuizService() {
        // Sample questions
        quizzes.add(new Quiz("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 0));
        quizzes.add(new Quiz("Who wrote 'Hamlet'?", new String[]{"Shakespeare", "Dickens", "Austen", "Orwell"}, 0));
    }
    
    public List<Quiz> getQuizzes() {
        return quizzes;
    }
    
    public boolean checkAnswer(int quizIndex, int answerIndex) {
        return quizzes.get(quizIndex).getCorrectAnswer() == answerIndex;
    }
    
    // Other quiz-related methods
}
