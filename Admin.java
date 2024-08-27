import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Candidate> candidates;
    private List<User> voters;

    public Admin() {
        candidates = new ArrayList<>();
        voters = new ArrayList<>();
    }
    public void addCandidate(String name) {
        candidates.add(new Candidate(name));
        System.out.println("Candidate " + name + " added.");
    }

    public void removeCandidate(String name) {
        candidates.removeIf(candidate -> candidate.getName().equals(name));
        System.out.println("Candidate " + name + " removed.");
    }

    public void listCandidates() {
        System.out.println("List of Candidates:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName());
        }
    }

    public void addVoter(String username, String password) {
        voters.add(new User(username, password));
        System.out.println("Voter " + username + " added.");
    }

    public void removeVoter(String username) {
        voters.removeIf(voter -> voter.getUsername().equals(username));
        System.out.println("Voter " + username + " removed.");
    }

    public void listVoters() {
        System.out.println("List of Voters:");
        for (User voter : voters) {
            System.out.println(voter.getUsername());
        }
    }

    public void resetPassword(User user, String newPassword) {
        user.setPassword(newPassword);
        System.out.println("Password for " + user.getUsername() + " has been reset.");
    }

    public void showElectionResults() {
        System.out.println("Election Results:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes");
        }
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
}
