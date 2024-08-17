import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Candidate> candidates;

    public Admin() {
        candidates = new ArrayList<>();
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
}