import java.util.Scanner;

public class Main {
    private static UserService userService = new UserService();
    private static QuizService quizService = new QuizService();
    private static SessionService sessionService = new SessionService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String sessionId = "default-session"; // This can be a unique identifier in a real application
        
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Take Quiz");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    login(sessionId);
                    break;
                case 2:
                    updateProfile(sessionId);
                    break;
                case 3:
                    takeQuiz(sessionId);
                    break;
                case 4:
                    logout(sessionId);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    
    private static void login(String sessionId) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        User user = userService.login(username, password);
        if (user != null) {
            sessionService.login(sessionId, user);
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
    
    private static void updateProfile(String sessionId) {
        User user = sessionService.getUser(sessionId);
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }
        
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();
        
        if (userService.updateProfile(user.getUsername(), newPassword, newEmail)) {
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Profile update failed!");
        }
    }
    
    private static void takeQuiz(String sessionId) {
        User user = sessionService.getUser(sessionId);
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }
        
        for (int i = 0; i < quizService.getQuizzes().size(); i++) {
            Quiz quiz = quizService.getQuizzes().get(i);
            System.out.println((i + 1) + ". " + quiz.getQuestion());
            for (int j = 0; j < quiz.getOptions().length; j++) {
                System.out.println("   " + (char)('A' + j) + ". " + quiz.getOptions()[j]);
            }
            System.out.print("Your answer: ");
            char answer = scanner.nextLine().toUpperCase().charAt(0);
            int answerIndex = answer - 'A';
            
            if (quizService.checkAnswer(i, answerIndex)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer is: " + quiz.getOptions()[quiz.getCorrectAnswer()]);
            }
        }
    }
    
    private static void logout(String sessionId) {
        sessionService.logout(sessionId);
        System.out.println("Logged out successfully!");
    }
}