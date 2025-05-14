package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DBUtils;

import java.sql.*;

public class CustomerSteps {

    private Connection connection;
    private String fullName;
    private String actualEmail;
    private boolean isActive;
    private int storeId;


    @Given("I connect to the Sakila database")
    public void connectToDB() throws SQLException {
        // Get the connection using DBUtils
        connection = DBUtils.getConnection();
    }

    @When("I search for a customer named {string}")
    public void iSearchForACustomerNamed(String name) throws SQLException {

        // Split full name into first and last names
        String[] parts = name.split(" ");

        // SQL query with placeholders (?) for parameters to prevent SQL injection
        String query = "SELECT first_name, last_name FROM customer WHERE first_name = ? AND last_name = ?";

        // Create a PreparedStatement using the connection object
        // PreparedStatement helps in executing parameterized queries securely
        PreparedStatement stmt = connection.prepareStatement(query);

        // Set the first parameter (first_name) using parts[0], typically the first name of the customer
        stmt.setString(1, parts[0]);
        // Set the second parameter (last_name) using parts[1], typically the last name of the customer
        stmt.setString(2, parts[1]);

        // Execute the query
        ResultSet rs = stmt.executeQuery();
        rs.next();
        fullName = rs.getString("first_name") + " " + rs.getString("last_name");

        rs.close();
        stmt.close();

    }

    @Then("I should find the customer")
    public void iShouldFindTheCustomer() {

        Assert.assertNotNull("customer not found",fullName);
    }


    @When("I search for the customer {string}")
    public void iSearchForTheCustomer(String name) throws SQLException {


        String[] parts = name.split(" ");

        String query = "SELECT email FROM customer WHERE first_name = ? AND last_name = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, parts[0]);
        stmt.setString(2, parts[1]);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        actualEmail = rs.getString("email");

        rs.close();
        stmt.close();

    }

    @Then("the email should be {string}")
    public void theEmailShouldBe(String expectedEmail) {

        Assert.assertEquals(expectedEmail,actualEmail);

    }

    @When("I check the status of {string}")
    public void iCheckTheStatusOf(String name) throws SQLException {

        String[] parts = name.split(" ");

        String query = "SELECT active FROM customer WHERE first_name = ? AND last_name = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, parts[0]);
        stmt.setString(2, parts[1]);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        isActive = rs.getBoolean("active");

        rs.close();
        stmt.close();

    }

    @Then("the customer should be active")
    public void theCustomerShouldBeActive() {

        Assert.assertTrue(isActive);
    }

    @When("I look up the store for customer {string}")
    public void iLookUpTheStoreForCustomer(String name) throws SQLException {

        String[] parts = name.split(" ");
        String query = "SELECT store_id FROM customer WHERE first_name = ? AND last_name = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, parts[0]);
        stmt.setString(2, parts[1]);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            storeId = rs.getInt("store_id");
        }
        rs.close();
        stmt.close();

    }

    @Then("the store ID should be {int}")
    public void theStoreIDShouldBe(int expectedStoreId) {

        Assert.assertEquals(expectedStoreId, storeId);
    }
}
