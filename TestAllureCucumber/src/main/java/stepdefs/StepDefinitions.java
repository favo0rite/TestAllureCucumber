package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.MortgagePageSteps;
import steps.MortgageReadyHousePageSteps;
import steps.StartPageSteps;

public class StepDefinitions {
    private StartPageSteps startPageSteps = new StartPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();
    private MortgageReadyHousePageSteps mortgageReadyHousePageSteps = new MortgageReadyHousePageSteps();

    @When("курсор наведен на элемент меню: Ипотека")
    public void moveToMortgage() {
        startPageSteps.moveToMortgage();
    }

    @Then("нажимаем на элемент меню: ипотека на готовое жилье и переходим на вкладку ипотечных условий")
    public void chooseMortgageOnReadyHouse() {
        mortgagePageSteps.chooseMortgageOnReadyHouse();
    }

    @When("Заполнены поля:")
    public void inputFields(String priceRealty, String initialPayment, String loanPeriod) {
        mortgageReadyHousePageSteps.inputPriceRealty(priceRealty);
        mortgageReadyHousePageSteps.inputInitialPayment(initialPayment);
        mortgageReadyHousePageSteps.inputLoanPeriod(loanPeriod);
    }

    @Then("Значения полей равны:")
    public void assertFields(String priceRealty, String initialPayment, String loanPeriod, String interestRate) {
        mortgageReadyHousePageSteps.assertFields(priceRealty, initialPayment, loanPeriod );
        mortgageReadyHousePageSteps.assertInterestRate(interestRate);
    }





}
