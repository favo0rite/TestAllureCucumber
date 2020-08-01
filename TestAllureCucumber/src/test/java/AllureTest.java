import managers.ManagerPages;
import org.junit.After;
import org.junit.Before;

import pages.MortgagePage;
import pages.MortgageReadyHousePage;
import steps.BaseSteps;
import steps.MortgagePageSteps;
import steps.MortgageReadyHousePageSteps;
import steps.StartPageSteps;


public class AllureTest {
    protected ManagerPages app = ManagerPages.getManagerPages();
    private StartPageSteps startPageSteps = new StartPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();
    private MortgageReadyHousePageSteps mortgageReadyHousePageSteps = new MortgageReadyHousePageSteps();
    @Before
    public void setUp() {
        BaseSteps.setUp();
    }

    @org.junit.Test
    public void testMortgage() {
        startPageSteps.moveToMortgage();

        mortgagePageSteps.chooseMortgageOnReadyHouse();

        mortgageReadyHousePageSteps.inputPriceRealty("5 180 000");
        mortgageReadyHousePageSteps.inputInitialPayment("3 058 000");
        mortgageReadyHousePageSteps.inputLoanPeriod("30");
        mortgageReadyHousePageSteps.clickCheckBoxLifeInsurance();
        mortgageReadyHousePageSteps.clickCheckBoxyYoungFamily();
        mortgageReadyHousePageSteps.assertFields("16 922 ₽", "2 122 000 ₽", "21 784 ₽");
        mortgageReadyHousePageSteps.assertInterestRate("11");

           }

    @After
    public void tearDown() {
        BaseSteps.tearDown();
    }
}
