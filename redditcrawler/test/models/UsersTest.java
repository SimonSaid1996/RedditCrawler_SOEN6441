package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test the users class
 * @author Ziran Cao
 * @version v1
 */
class UsersTest {
    /**
     * test getuser function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getUser() {
        User u = Users.getUser("test");
        assertNotNull(u);
    }
}