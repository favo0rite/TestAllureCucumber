package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.MortgageReadyHousePageSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static steps.BaseSteps.getDriver;
import static utils.Utils.addScreenshot;

public class MortgageReadyHousePage extends BasePage {
    private @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']/input[@class='dc-input__input-4-6-1']")
    WebElement priceRealtyInput;

    private @FindBy(xpath = "//iframe[@title='Основной контент']")
    WebElement frameInputs;

    private @FindBy(xpath = "//div[@data-label='Первоначальный взнос']/input")
    WebElement initialPaymentInput;

    private @FindBy(xpath = "//div[@data-label='Срок кредита']/input")
    WebElement loanPeriodInput;

    private @FindBy(xpath = "//input[@aria-checked='true' and @data-e2e-id='mland-calculator/discount-item-2-switcher']")
    WebElement lifeInsuranceCheckBox;

    private @FindBy(xpath = "//span[text()='Молодая семья']/parent::div//following-sibling::span//input")
    WebElement youngFamilyCheckBox;

    private @FindBy(xpath = "//span[text()='Ежемесячный платеж']/parent::li[@class='styles_listItem__2oHcd']/span[@class='styles_value__uesGj styles_value--large__2lbF2']/span")
    List<WebElement> monthlyPayment;

    private @FindBy(xpath = "//span[text()='Сумма кредита']/parent::li[@class='styles_listItem__2oHcd']/span[@class='styles_value__uesGj']/span")
    List<WebElement> sumCredit;

    private @FindBy(xpath = "//span[text()='Необходимый доход']/parent::li/span/span")
    List<WebElement> requiredRevenue;

    private @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/main-result-credit-rate']/span")
    List<WebElement> interestRate;


    public MortgageReadyHousePage inputPriceRealty(String value) {
        scrollToElementJs(frameInputs);
        getDriver().switchTo().frame(frameInputs);
        inputTextToFrame(priceRealtyInput, value);
        return this;
    }

    public MortgageReadyHousePage inputInitialPayment(String value) {
        int length = initialPaymentInput.getAttribute("value").length();
        initialPaymentInput.click();
        for (int i = 0; i < length; i++){
            initialPaymentInput.sendKeys(Keys.BACK_SPACE);
        }
        initialPaymentInput.sendKeys(value);
        return this;
    }

    public MortgageReadyHousePage inputLoanPeriod(String value) {
        inputTextToFrame(loanPeriodInput, value);
        return this;
    }

    public MortgageReadyHousePage clickCheckboxLifeInsurance() {
        scrollToElementJs(lifeInsuranceCheckBox);
        clickElementJs(lifeInsuranceCheckBox);
        return this;
    }

    public MortgageReadyHousePage clickCheckBoxyYoungFamily() {
        clickElementJs(youngFamilyCheckBox);
        return this;
    }

    public MortgageReadyHousePage assertFields(String monthlyPaymentValue, String sumCreditValue, String requiredRevenueValue) {
        scrollToElementJs(monthlyPayment.get(1));


        elementTextToBePresent(monthlyPayment.get(1), monthlyPaymentValue);
        elementTextToBePresent(sumCredit.get(1), sumCreditValue);
        elementTextToBePresent(requiredRevenue.get(1), requiredRevenueValue);
        String monthlyPaymentString = monthlyPayment.get(1).getText();
        String sumCreditString = sumCredit.get(1).getText();
        String requiredRevenueString = requiredRevenue.get(1).getText();

        assertEquals("Ежемесяный платет не совпал", monthlyPaymentValue, monthlyPaymentString );
        assertEquals("Сумма кредита не совпала", sumCreditValue, sumCreditString);
        assertEquals("Ежмесячный доход не совпал", requiredRevenueValue, requiredRevenueString);
        return this;
    }

    public MortgageReadyHousePage assertInterestRate(String interestRateValue){
        String interestRateString = interestRate.get(1).getText().replaceAll("%", "");
        assertEquals("Процентная ставка не совпадает", interestRateValue, interestRateString);
        addScreenshot();
        return this;
    }
}
