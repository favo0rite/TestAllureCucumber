package steps;

import io.qameta.allure.Step;
import managers.ManagerPages;
import pages.MortgageReadyHousePage;
import utils.Utils;

public class MortgageReadyHousePageSteps extends BaseSteps {

    @Step("Вводим стоимость недвижимости")
    public void inputPriceRealty(String priceRealty) {
        app.getMortgageReadyHousePage().inputPriceRealty(priceRealty);
    }

    @Step("Вводим первоначальный взнос")
    public void inputInitialPayment(String initialPayment) {
        app.getMortgageReadyHousePage().inputInitialPayment(initialPayment);
    }

    @Step("Вводим срок кредита")
    public void inputLoanPeriod(String loanPeriod) {
        app.getMortgageReadyHousePage().inputLoanPeriod(loanPeriod);
    }

    @Step("Нажимаем на чекбокс: Страхование жизни")
    public void clickCheckBoxLifeInsurance() {
        app.getMortgageReadyHousePage().clickCheckboxLifeInsurance();
    }

    @Step("Нажимаем на чекбокс: Молодая семья")
    public void clickCheckBoxyYoungFamily() {
        app.getMortgageReadyHousePage().clickCheckBoxyYoungFamily();
    }

    @Step("Проверяем поля: ежемесяный платеж, сумма кредита, ежемесячный доход, процентная ставка")
    public void assertFields(String monthlyPaymentValue, String sumCreditValue, String requiredRevenueValue) {
        app.getMortgageReadyHousePage().assertFields(monthlyPaymentValue, sumCreditValue, requiredRevenueValue);
    }

    @Step("Проверяем поле: процентная ставка")
    public void assertInterestRate(String interestRate){
        app.getMortgageReadyHousePage().assertInterestRate(interestRate);
        Utils.addScreenshot();
    }

}
