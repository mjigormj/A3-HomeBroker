package Mock;

import Model.User;
import java.sql.SQLException;

public class UserMock {
    private static User mockUser() throws SQLException{
        User user = new User("igor", "igor@gmail", "123"); 
        user.setIdUsuario("1");
        return user;
    }
}
