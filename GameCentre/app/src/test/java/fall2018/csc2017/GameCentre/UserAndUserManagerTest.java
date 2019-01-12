package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import fall2018.csc2017.GameCentre.DataManagers.User;
import fall2018.csc2017.GameCentre.DataManagers.UserManager;

import static org.junit.Assert.*;

public class UserAndUserManagerTest {
    /** The user manager to be used for testing purposes. */
    private UserManager userDatabase = new UserManager();
    /** The user to be used for testing purposes. */
    private User testUser = new User("OriginalTester", "TesterPassword");

    /**
     * Test that adding a user correctly changes the number of people in the database.
     */
    @Test
    public void testAddUser(){
        setUpDatabase();
        assertEquals(4, userDatabase.getTotalUsers());
    }

    /**
     * Test that adding a user correctly stores the user.
     */
    @Test
    public void testHasUser(){
        User alex = new User("Alex", "123");
        userDatabase.addUser(alex);
        User alex2 = new User("Alex", "123");
        assertTrue(userDatabase.hasUser(alex2));
    }

    /**
     * Test that the database distinguishes from users not currently stored.
     */
    @Test
    public void testGetUserEmpty(){
        User testUser = new User("Tester", "123");
        testUser = userDatabase.getUser(testUser);
        assertNull(testUser);
    }

    /**
     * Test that we can retrieve a user's data from the database.
     */
    @Test
    public void testGetUser(){
        User testUser = new User("Tester", "123");
        userDatabase.addUser(testUser);
        User loggedInUser = userDatabase.getUser(testUser);
        assertNotNull(loggedInUser);
    }

    /**
     * Test that you can replace the user in the database, with equivalent user(user names).
     */
    @Test
    public void testReplaceUser(){
        User alex = new User("Alex", "123");
        userDatabase.addUser(alex);
        User newAlex = new User("Alex", "69");
        userDatabase.replaceUser(newAlex);
        assertEquals(alex, newAlex);
    }

    /**
     * Tests the iterator for the board.
     */
    @Test
    public void testUserManagerIterator() {
        setUpDatabase();
        Iterator<User> it = userDatabase.iterator();
        StringBuilder combinedNames = new StringBuilder();
        for (int i = 0; i != userDatabase.getTotalUsers(); i++){
            combinedNames.append(it.next().getUsername());
        }
        assertEquals("ZuhabJimmyFredAlex", combinedNames.toString());
    }

    /**
     * Set up the database for use in various tests.
     */
    private void setUpDatabase() {
        User alex = new User("Alex", "123");
        User zuhab = new User("Zuhab", "333");
        User jimmy = new User("Jimmy", "999");
        User fred = new User("Fred", "69");
        userDatabase.addUser(zuhab);
        userDatabase.addUser(jimmy);
        userDatabase.addUser(fred);
        userDatabase.addUser(alex);
    }

    /**
     * Tests the iterator for the board after no such element exists.
     */
    @Test(expected = NoSuchElementException.class)//IndexOutOfBoundsException.class)
    public void testPowersPlusBoardIteratorHasNext() {
        setUpDatabase();
        Iterator<User> it = userDatabase.iterator();
        for (int i = 0; i != userDatabase.getTotalUsers() + 1; i++) {
            it.next();
        }
    }

    /**
     * Tests that getting the user's password is correct.
     */
    @Test
    public void testGetPassword(){
        assertEquals("TesterPassword", testUser.getPassword());
    }

    /**
     * Tests that we can create the correct number of saved games.
     */
    @Test
    public void testCreateSavedGames(){
        testUser.createSavedGames();
        assertEquals(3, testUser.userSavedGames.size());
    }

    /**
     * Tests that we can correctly add saves to a user's saved games.
     */
    @Test
    public void testAddMineSweeperSaveAndAddPowersPlusSave(){
        testUser.addSave("PowersPlus");
        testUser.addSave("MineSweeper");
        assertEquals(2, testUser.userSavedGames.size());
    }

    /**
     * Test equality with self, for users.
     */
    @Test
    public void testEqualsSame(){
        assertEquals(testUser, testUser);
    }

    /**
     * Test inequality between users.
     */
    @Test
    public void testEqualsDifferent(){
        User alex = new User("Alex", "123");
        assertNotEquals(testUser, alex);
    }
}
