package com.utaf.desktopSteps;

import DataProviders.ExcelReader;
import PageObjects.NotePadPage;
import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    TestContext testContext;
    NotePadPage loginPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {
        loginPage.sampleTest();
    }

    @When("Input {string} as email, {string} as password, {string} as account type")
    public void inputAsEmailAsPasswordAsAccountType(String email, String password, String account) {
        System.out.println("---" + email);
        System.out.println("---" + password);
        System.out.println("---" + account);
    }

    @When("Input credentials to login")
    public void inputCredentialsToLoginWithoutHeaders(DataTable dataTable) {
        List<String> dataRow = dataTable.row(0);
        String email = dataRow.get(0);
        String password = dataRow.get(1);
        String userProfile = dataRow.get(2);
        String username;

        switch (email){
            case "Home":
                username = ExcelReader.readUserData("Home","Email");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + email);
        }
    }

    @When("Input credentials to login with headers table")
    public void inputCredentialsToLoginWithHeadersTable(DataTable dataTable) {
        List<Map<String,String>> dataRow = dataTable.asMaps(String.class,String.class);

        //Use for...loop if you have multiple data table
        for (Map<String, String> dataMap : dataRow) {
            String email = dataMap.get("Email");
            String password = dataMap.get("Password");
            //loginPage.login(email, password);
            System.out.println("row header email " + email);
            System.out.println("row index 1 --- " + dataMap.get("Password"));
            System.out.println("row index 2 --- " + dataMap.get("Account Type"));
        }
    }
}
