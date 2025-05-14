package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DBUtils;

import java.sql.SQLException;

public class Hooks {

    @Before
    public void setUp() {
        try {
            DBUtils.getConnection();
            System.out.println("✔️ Connected to the database.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to the database: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            DBUtils.closeConnection();
            System.out.println("✅ Database connection closed.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to close the database connection: " + e.getMessage());
        }
    }
}


