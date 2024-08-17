import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingSystem {
    private List<User> users;
    private User loggedInUser;
    private Admin admin;

    public VotingSystem() {
        users = new ArrayList<>();
        loggedInUser = null;
        admin = new Admin();  // Initialize Admin
    }

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
        System.out.println("User registered successfully!");
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.validatePassword(password)) {
                loggedInUser = user;
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logoutUser() {
        if (loggedInUser != null) {
            System.out.println("User " + loggedInUser.getUsername() + " logged out.");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void castVote(String candidateName) {
        if (loggedInUser != null && !loggedInUser.hasVoted()) {
            for (Candidate candidate : admin.getCandidates()) {
                if (candidate.getName().equals(candidateName)) {
                    candidate.addVote();
                    loggedInUser.setVoted(true);
                    System.out.println("Vote cast successfully!");
                    return;
                }
            }
            System.out.println("Candidate not found.");
        } else {
            System.out.println("You have already voted or are not logged in.");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding some candidates for demonstration
        system.admin.addCandidate("Alice");
        system.admin.addCandidate("Bob");
        system.admin.addCandidate("Charlie");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Vote\n4. Show Results\n5. Admin\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    system.registerUser(username, password);
                    break;
                case 2:
                    System.out.println("Enter username:");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Enter password:");
                    String loginPassword = scanner.nextLine();
                    system.loginUser(loginUsername, loginPassword);
                    break;
                case 3:
                    if (system.loggedInUser != null && !system.loggedInUser.hasVoted()) {
                        System.out.println("Enter candidate name to vote for:");
                        String candidateName = scanner.nextLine();
                        system.castVote(candidateName);
                    } else {
                        System.out.println("Please login first or you have already voted.");
                    }
                    break;
                case 4:
                    system.admin.showElectionResults();
                    break;
                case 5:
                    System.out.println("Admin Section (Only for demonstration):");
                    system.admin.listCandidates();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
