package qumu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Double.parseDouble;

public class SamplePage extends BasePage {

    @FindBy(id="user-name")
    private WebElement userNameInputField;

    @FindBy(id="password")
    private WebElement passwordInputField;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement sauceLabBackpackADDButton;

    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement sauceLabFleeceADDButton;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement sauceLabBoltTShirtADDButton;

    @FindBy(id="add-to-cart-sauce-labs-onesie")
    private WebElement sauceLabOnesieADDButton;

    @FindBy(id="shopping_cart_container")
    private WebElement shoppingCartButton;

    @FindBy(xpath="//*[@id='cart_contents_container']/div/div[1]/div[3]/div[1]")
    private WebElement firstItemCount;

    @FindBy(xpath="//*[@id='cart_contents_container']/div/div[1]/div[4]/div[1]")
    private WebElement secondItemCount;

    @FindBy(xpath="//*[@id='cart_contents_container']/div/div[1]/div[5]/div[1]")
    private WebElement thirdItemCount;

    @FindBy(xpath="//*[@id='cart_contents_container']/div/div[1]/div[6]/div[1]")
    private WebElement forthItemCount;

    @FindBy(id="remove-sauce-labs-fleece-jacket")
    private WebElement removeFleeceJacketButton;

    @FindBy(id="checkout")
    private WebElement checkoutButton;

    @FindBy(id="first-name")
    private WebElement firstNameOnCheckoutScreen;

    @FindBy(id="last-name")
    private WebElement lastNameOnCheckoutScreen;

    @FindBy(id="postal-code")
    private WebElement postalCodeOnCheckoutScreen;

    @FindBy(id="continue")
    private WebElement continueButtonOnCheckout;

    @FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement firstItemPrice;

    @FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    private WebElement secondItemPrice;

    @FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[5]/div[2]/div[2]/div")
    private WebElement thirdItemPrice;

    @FindBy(className="summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(className="summary_tax_label")
    private WebElement itemTax;

    public SamplePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterLoginDetails(String userName, String password){
        userNameInputField.sendKeys(userName);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public void addItemsInBasket(String item){
         if(item.equals("Sauce Labs Backpack")) {
             sauceLabBackpackADDButton.click();
         } else if(item.equals("Sauce Labs Fleece Jacket")) {
             sauceLabFleeceADDButton.click();
         } else if(item.equals("Sauce Labs Bolt T-Shirt")) {
             sauceLabBoltTShirtADDButton.click();
         } else if(item.equals("Sauce Labs Onesie")) {
             sauceLabOnesieADDButton.click();
         } else {
             System.out.println("Product not found.");
         }
    }

    public int getCartCount() {
        return Integer.valueOf(shoppingCartButton.getText());
    }

    public void clickOnShoppingCartButton() {
        shoppingCartButton.click();
    }

    public int verifyItemCount(int itemIndex) {
        switch (itemIndex) {
            case 1:
                return Integer.parseInt(firstItemCount.getText());
            case 2:
                return Integer.parseInt(secondItemCount.getText());
            case 3:
                return Integer.parseInt(thirdItemCount.getText());
            case 4:
                return Integer.parseInt(forthItemCount.getText());
            default:
                System.out.println("Item not found.");
                return -1;
        }
    }

    public void removeFleeceJacketFromCart(String item) {
        if(item.equals("Sauce Labs Fleece Jacket")) {
            removeFleeceJacketButton.click();
        }
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void addFirstName(String textToDisplay) {
        firstNameOnCheckoutScreen.sendKeys(textToDisplay);
    }

    public void addLastName(String textToDisplay) {
        lastNameOnCheckoutScreen.sendKeys(textToDisplay);
    }

    public void addPostalCode(String textToDisplay) {
        postalCodeOnCheckoutScreen.sendKeys(textToDisplay);
    }

    public void clickOnContinueButton() {
        continueButtonOnCheckout.click();
    }

    public float verifyItemPrice(int itemIndex) {
        switch (itemIndex) {
            case 1:
                return Float.parseFloat(firstItemPrice.getText().substring(1));
            case 2:
                return Float.parseFloat(secondItemPrice.getText().substring(1));
            case 3:
                return Float.parseFloat(thirdItemPrice.getText().substring(1));
            default:
                System.out.println("Item not found.");
                return -1;
        }
    }

    public Float getItemTotal() {
        String itemTotalText = itemTotal.getText();
        return  Float.parseFloat(itemTotalText.substring(itemTotalText.indexOf("$")+1));
    }

    public double getItemTax() {
        String itemTaxText = itemTax.getText();
        return  parseDouble(itemTaxText.substring(itemTaxText.indexOf("$")+1));
    }

/**
 * You can use this class to add page objects and methods.
 */
}
