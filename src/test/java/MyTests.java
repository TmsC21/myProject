import org.example.sk.controller.MyController;
import org.example.sk.utils.MyDatabase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyTests {

    MyDatabase myDatabase;
    MyController myController;


    @Before
    public void setUp() throws Exception {
        this.myDatabase = new MyDatabase();
        this.myDatabase.createConntection();
        this.myController = new MyController(myDatabase.getConnection());
    }

    @After
    public void tearDown() throws Exception {
        this.myDatabase.closeConnection();
    }

    @Test
    public void testAddUsers() {
        myController.addUser(1, "a1", "Robert");
        myController.addUser(2, "a2", "Martin");
        assertEquals(2, myController.getAll().size());
    }

    @Test
    public void testAddUsersOneBad() {
        myController.addUser(1, "a1", "Robert");
        myController.addUser(1, "a2", "Martin");
        assertEquals(1, myController.getAll().size());
    }

    @Test
    public void testDeleteUsers() {
        myController.addUser(1, "a1", "Robert");
        myController.addUser(2, "a2", "Martin");
        myController.deleteAll();
        assertEquals(0, myController.getAll().size());
    }

    @Test
    public void testGetAllUsers() {
        myController.addUser(1, "a1", "Robert");
        myController.addUser(2, "a2", "Martin");
        assertEquals(2, myController.getAll().size());
    }
}
