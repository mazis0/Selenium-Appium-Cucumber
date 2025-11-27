package steps.checkRates;
import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.checkRates.CheckRatesPage;
import java.io.IOException;
import java.util.HashMap;

public class CheckRatesStep {

    private final AndroidDriver<AndroidElement> driver;

    public CheckRatesStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    static HashMap<String, String> value = new HashMap<>();

    @Given("the user is already logged in to the application")
    public void input_valid_username_and_password() {
        CheckRatesPage cekTarifPage = new CheckRatesPage(driver);
        Assert.assertTrue(cekTarifPage.isUserAlreadyLogin());
    }

    @And("the user clicks the check rates menu")
    public void clickCheckRatesMenu(){
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        checkRatesPage.clickCheckRatesMenu();
    }

    @And("the user enters the origin area as {string}")
    public void enterTheOriginArea(String origin){
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        checkRatesPage.clickOriginArea();
        checkRatesPage.inputSubdistrict(origin);
        checkRatesPage.clickByTextSearchSuggestion(origin);
    }

    @And("the user enters the destination as {string}")
    public void enterTheDestinations(String destinations){
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        checkRatesPage.clickTargetArea();
        checkRatesPage.inputSubdistrict(destinations);
        checkRatesPage.clickByTextSearchSuggestion(destinations);
    }

    @And("the user clicks the {string} button")
    public void clickButton(String button) throws InterruptedException {
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        checkRatesPage.clickButtonByText(button);
    }

    @And("the user enters the item weight as {string} kg")
    public void inputTotalWeight(String weight){
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        checkRatesPage.inputTotalWeight(weight);
    }

    @And("the user enters the item type as {string}")
    public void enterItemType(String text){
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        checkRatesPage.clickTypeOfItem();
        checkRatesPage.clickByText(text);
    }

    @And("the user selects the delivery method {string}")
    public void selectDeliveryMethod(String text) throws Exception {
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        if (text.equals("regpack")){
            checkRatesPage.selectRegPack();
            value.put("deliveryMethod",text);
        } else if (text.equals("jagopack")){
            checkRatesPage.selectJagoPack();
            value.put("deliveryMethod",text);
        } else if (text.equals("bigfastpack")){
            checkRatesPage.selectBigPackFast();
            value.put("deliveryMethod",text);
        } else if (text.equals("bigpack")){
            checkRatesPage.selectBigPack();
            value.put("deliveryMethod",text);
        }
    }

    @And("the shipping rate should be displayed correctly")
    public void verifyShippingRate() throws Exception {
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        String text = value.get("deliveryMethod");
        if (text.equals("regpack")){
            Assert.assertEquals(checkRatesPage.getRegPackPrice(),checkRatesPage.getTotalCost());
        } else if (text.equals("jagopack")){
            Assert.assertEquals(checkRatesPage.getJagoPackPrice(),checkRatesPage.getTotalCost());
        } else if (text.equals("bigpackfast")){
            Assert.assertEquals(checkRatesPage.getBigPackFastPrice(),checkRatesPage.getTotalCost());
        } else if (text.equals("bigpack")){
            Assert.assertEquals(checkRatesPage.getBigPackPrice(),checkRatesPage.getTotalCost());
        }
    }

    @And("the error message {string} should be displayed")
    public void isMessageDisplayed(String text){
        CheckRatesPage checkRatesPage = new CheckRatesPage(driver);
        Assert.assertTrue(checkRatesPage.isTextDisplayed(text));
    }

}
