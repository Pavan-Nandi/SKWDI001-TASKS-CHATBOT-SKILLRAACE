import java.util.HashMap;
import java.util.Map;

public class SessionService {
    private Map<String, User> sessions = new HashMap<>();
    
    public void login(String sessionId, User user) {
        sessions.put(sessionId, user);
    }
    
    public User getUser(String sessionId) {
        return sessions.get(sessionId);
    }
    
    public void logout(String sessionId) {
        sessions.remove(sessionId);
    }
    
    // Other session-related methods
}