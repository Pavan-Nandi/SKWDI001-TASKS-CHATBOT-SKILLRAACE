public class User {
    private String username;
    private String password;
    private boolean hasVoted;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.hasVoted = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile updated successfully.");
    }
}