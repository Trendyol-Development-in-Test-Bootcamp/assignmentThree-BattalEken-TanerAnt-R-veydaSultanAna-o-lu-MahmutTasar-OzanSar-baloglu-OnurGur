package steps;

import org.testng.annotations.Test;
import pageModel.BasePage;
import pageModel.HomePage;
import pageModel.LoginPage;
import pageModel.LoginPage.*;
import pageModel.MyAccountPage;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;


public class AccountSteps {

    public String s  = "abcasdfghjklş+%^''++''^+gvhjbmkl(&%&+548596   ffh'^^+&%+^'54abcasdfghjklş+%^''++''^+gvhjbmkl(&%&+548596   ffh'^^+&%+^'54abcasdfghjklş+%^''++''^+gvhjbmkl(&%&+548596   ffh'^^+&%+^'54;abcasdfghjklş+%^''++''^+gvhjbmkl(&%&+548596   ffh'^^+&%+^'54";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void checkLogin() throws InterruptedException {

        homePage.goToPage();
        homePage.closePopup();
        homePage.clickAccountUser();

        loginPage.login();

        homePage.closeNotification();
        assertEquals("hesabım",loginPage.checkLogin().toLowerCase());

    }

    @Test(dependsOnMethods={"checkLogin"})
    public void updateUserInfo(){

        homePage.clickMyAccount();

        myAccountPage.clickAccountInfo();


        assertEquals("kullanıcı bilgilerim" , myAccountPage.getTitleMyAccountInfo().toLowerCase());

        myAccountPage.setUserNameInfo(s);
        myAccountPage.setUserLastNameInfo(s);
        myAccountPage.setUserPhoneInfo("5415555555");
        myAccountPage.clickActiveUpdateButton();


        String message = "Güncelleme Başarılı";
        assertEquals(message, myAccountPage.getMessage());

        assertEquals(s, myAccountPage.getUserNameInfo());
        assertEquals(s, myAccountPage.getUserLastNameInfo());
        assertEquals("5415555555" , myAccountPage.getUserPhoneInfo());
    }

}
