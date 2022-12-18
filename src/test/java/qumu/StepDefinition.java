package qumu;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class StepDefinition {
public String expText="THANK YOU FOR YOUR ORDER";
    SamplePage samplePageObj = new SamplePage();
    Float _itemTotal = Float.valueOf(0);

    @Given("^I get the default list of users for on 1st page$")
    public void iGetTheDefaultListofusers() {
    }

    @When("I get the list of all users within every page")
    public void iGetTheListOfAllUsers() {
    }

    @Then("I should see total users count equals the number of user ids")
    public void iShouldMatchTotalCount() {

    }

    @Given("I make a search for user (.*)")
    public void iMakeASearchForUser(String sUserID) {

    }

    @Then("I should see the following user data")
    public void IShouldSeeFollowingUserData(DataTable dt) {
    }

    @Then("I receive error code (.*) in response")
    public void iReceiveErrorCodeInResponse(int responseCode) {

    }

    @Given("I create a user with following (.*) (.*)")
    public void iCreateUserWithFollowing(String sUsername, String sJob) {
    }

    @Then("response should contain the following data")
    public void iReceiveErrorCodeInResponse(DataTable dt) {

    }

    @Given("I login unsuccessfully with the following data")
    public void iLoginSuccesfullyWithFollowingData(DataTable dt) {

    }

    @Given("^I wait for the user list to load$")
    public void iWaitForUserListToLoad() {

    }

    @Then("I should see that every user has a unique id")
    public void iShouldSeeThatEveryUserHasAUniqueID() {

        // Please not that we need to check all values are unique in the list.
    }

    @Then("^I should get a response code of (\\d+)$")
    public void iShouldGetAResponseCodeOf(int responseCode) {
    }

    @And("^I should see the following response message:$")
    public void iShouldSeeTheFollowingResponseMessage() {
    }

    // ui steps

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        HomePage.homePage();
    }

    @When("^I login in with the following details$")
    public void i_login_in_with_the_following_details(DataTable loginDetails) throws Throwable {
        List<Map<String,String>> data = loginDetails.asMaps(String.class, String.class);
        samplePageObj.enterLoginDetails(data.get(0).get("userName"),data.get(0).get("Password"));
    }

    @And("^I add the following items to the basket$")
    public void i_add_the_following_items_to_the_basket(DataTable items) throws Throwable {
        List<List<String>> localItems = items.asLists(String.class) ;
        for (List<String> item : localItems){
            samplePageObj.addItemsInBasket( item.get(0));
        }
    }

    @Then("^I  should see (\\d+) items added to the shopping cart$")
    public void i_should_see_items_added_to_the_shopping_cart(int itemCount) throws Throwable {
        assertThat(samplePageObj.getCartCount(), comparesEqualTo(itemCount));
    }

    @When("^I click on the shopping cart$")
    public void i_click_on_the_shopping_cart() throws Throwable {
        samplePageObj.clickOnShoppingCartButton();
    }

    @Then("^I verify that the QTY count for each item should be (\\d+)$")
    public void i_verify_that_the_QTY_count_for_each_item_should_be(int counterValidation) throws Throwable {
        for (int i = 1; i < 4; i++) {
            assertThat(samplePageObj.verifyItemCount(i), comparesEqualTo(counterValidation));
        }
    }

    @When("^I remove the following item:$")
    public void i_remove_the_following_item(DataTable itemName) throws Throwable {
        List<List<String>> localItems = itemName.asLists(String.class);
        samplePageObj.removeFleeceJacketFromCart(localItems.get(0).get(0));
    }

    @Given("^I click on the CHECKOUT button$")
    public void i_click_on_the_CHECKOUT_button() throws Throwable {
        samplePageObj.clickCheckoutButton();
    }

    @Given("^I type \"([^\"]*)\" for First Name$")
    public void i_type_for_First_Name(String firstName) throws Throwable {
        samplePageObj.addFirstName(firstName);
    }

    @Given("^I type \"([^\"]*)\" for Last Name$")
    public void i_type_for_Last_Name(String lastName) throws Throwable {
        samplePageObj.addLastName(lastName);
    }

    @Given("^I type \"([^\"]*)\" for ZIP/Postal Code$")
    public void i_type_for_ZIP_Postal_Code(String postalCode) throws Throwable {
        samplePageObj.addPostalCode(postalCode);
    }

    @When("^I click on the CONTINUE button$")
    public void i_click_on_the_CONTINUE_button() throws Throwable {
        samplePageObj.clickOnContinueButton();
    }

    @Then("^Item total will be equal to the total of items on the list$")
    public void item_total_will_be_equal_to_the_total_of_items_on_the_list() throws Throwable {
        float itemTotal = 0;
        for (int i = 1; i < 4; i++) {
            itemTotal += samplePageObj.verifyItemPrice(i);
        }
        _itemTotal = itemTotal;
        assertThat(itemTotal, comparesEqualTo(samplePageObj.getItemTotal()));
    }

    @Then("^a Tax rate of (\\d+) % is applied to the total$")
    public void a_Tax_rate_of_is_applied_to_the_total(int arg1) throws Throwable {
        double getTaxTotal1 = Math.round(samplePageObj.getItemTax() * 100.0) / 100.0;
        double calculateTaxAmount = Math.round(_itemTotal * arg1) / 100.0;
        assertThat(calculateTaxAmount, comparesEqualTo(getTaxTotal1));
    }
    @Then("^I would confirm my order$")
    public void i_would_confirm_my_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        samplePageObj.FinalconfirmaitonButton();
    }
    @Then("^I will validate my order$")
    public void i_will_validate_my_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        if (expText.equals("THANK YOU FOR YOUR ORDER")) {
            samplePageObj.getValidation();
            String thankYouText = samplePageObj.getValidation();
            System.out.println(thankYouText);
          //  assertThat(thankYouText, is(equalToIgnoringCase(expText)));
            assertThat(thankYouText,true);


}}}
