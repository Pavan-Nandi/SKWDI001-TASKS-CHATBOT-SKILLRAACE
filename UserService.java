import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    
    public UserService() {
        // Initialize with a default user
        users.put("admin", new User("admin", "admin123", "admin@example.com"));
    }
    
    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    public boolean updateProfile(String username, String newPassword, String newEmail) {
        User user = users.get(username);
        if (user != null) {
            user.setPassword(newPassword);
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }
    
    // Other user-related methods
}