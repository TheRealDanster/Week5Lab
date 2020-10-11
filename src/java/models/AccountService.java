package models;

/**
 *
 * @author cprg352
 */
public class AccountService {
    
    public User login(String username, String password) {
	if (username.equals("abe") || username.equals("barb") && password.equals("password")) {
	    User user = new User();
	    user.setUsername(username);
	    user.setPassword(null);
	    return user;
	}
	return null;
    }
}
