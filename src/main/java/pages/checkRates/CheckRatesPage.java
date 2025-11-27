package pages.checkRates;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import pages.base.BasePage;

public class CheckRatesPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cek Tarif\"]")
    private MobileElement chekRatesMenu;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtDestinationAddress")
    private MobileElement targetArea;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtOriginAddress")
    private MobileElement originArea;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.lionparcel.services.consumer:id/edtRouteSearch\"]")
    private MobileElement searchSubdistrict;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtTotalWeight")
    private MobileElement totalWeight;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtPackageType")
    private MobileElement inputTypeOfItem;

    @AndroidFindBy(xpath = "//*[@text=\"Pengiriman reguler\"]/following-sibling::*[@resource-id=\"com.lionparcel.services.consumer:id/txtEstimatedPrice\"]")
    private MobileElement regPackPrice;

    @AndroidFindBy(xpath = "//*[@text=\"Pengiriman termurah\"]/following-sibling::*[@resource-id=\"com.lionparcel.services.consumer:id/txtEstimatedPrice\"]")
    private MobileElement jagoPackPrice;

    @AndroidFindBy(xpath = "//*[@text=\"Pengiriman Besar & Cepat\"]/following-sibling::*[@resource-id=\"com.lionparcel.services.consumer:id/txtEstimatedPrice\"]")
    private MobileElement bigPackFastPrice;

    @AndroidFindBy(xpath = "//*[@text=\"Kirim paket hemat mulai dari 10kg\"]/following-sibling::*[@resource-id=\"com.lionparcel.services.consumer:id/txtEstimatedPrice\"]")
    private MobileElement bigPackPrice;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/txtTotalTariffEstimation")
    private MobileElement totalCost;

    public CheckRatesPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void selectRegPack() throws Exception {
        scrollToElement(regPackPrice,"up");
        click(regPackPrice);
    }

    public void selectJagoPack() throws Exception {
        scrollToElement(jagoPackPrice,"up");
        click(jagoPackPrice);
    }

    public void selectBigPackFast() throws Exception {
        scrollToElement(bigPackFastPrice,"up");
        click(bigPackFastPrice);
    }

    public void selectBigPack() throws Exception {
        scrollToElement(bigPackPrice,"up");
        click(bigPackPrice);
    }

    public String getRegPackPrice() throws Exception {
        scrollToElement(regPackPrice,"up");
        return getText(regPackPrice,"");
    }

    public String getJagoPackPrice() throws Exception {
        scrollToElement(jagoPackPrice,"up");
        return getText(jagoPackPrice,"");
    }

    public String getBigPackFastPrice() throws Exception {
        scrollToElement(bigPackFastPrice,"up");
        return getText(bigPackFastPrice,"");
    }

    public String getBigPackPrice() throws Exception {
        scrollToElement(bigPackPrice,"up");
        return getText(bigPackPrice,"");
    }

    public void clickTypeOfItem(){
        click(inputTypeOfItem);
    }

    public void inputTotalWeight(String text){
        sendKeys(totalWeight,text);
    }

    public void clickByText(String text){
        String xpath = "//*[@text='" + text + "']";
        By element = By.xpath(xpath);
        click(element,"");
    }

    public void clickButtonByText(String text){
        String xpath = "//android.widget.Button[@text='" + text + "']";
        By element = By.xpath(xpath);
        click(element,"");
    }

    public boolean isTextDisplayed(String text){
        String xpath = "//android.widget.TextView[@text='" + text + "']";
        By element = By.xpath(xpath);
        waitForVisibility(element);
        boolean isElementDisplayed = driver.findElement(element).isDisplayed();
        return isElementDisplayed;
    }

    public void clickByTextSearchSuggestion(String text){
        String xpath = "//android.widget.TextView[@text='" + text + "']";
        By element = By.xpath(xpath);
        click(element,"");
    }

    public void inputSubdistrict(String text){
        sendKeys(searchSubdistrict,text);
    }

    public void clickTargetArea(){
        click(targetArea);
    }

    public void clickOriginArea(){
        click(originArea);
    }

    public void clickCheckRatesMenu(){
        click(chekRatesMenu);
    }

    public String getTotalCost() throws Exception {
        scrollToElement(totalCost,"up");
        return getText(totalCost,"");
    }

    public boolean isUserAlreadyLogin(){
        boolean login = false;
        try {
            waitForVisibility(chekRatesMenu);
            login = true;
        }catch (Exception e){
            login = false;
        }
        return  login;
    }

}
