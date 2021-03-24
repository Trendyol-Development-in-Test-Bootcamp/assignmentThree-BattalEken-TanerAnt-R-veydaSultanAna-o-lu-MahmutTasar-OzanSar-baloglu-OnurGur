package pageModel;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MyAccountPage extends BasePage {
    String btnAccountInfo = ".account-menu-button>a[href^=\"/Hesabim/KullaniciBilgileri\"]";
    String titleMyAccountInfo = ".my-account-title";
    String userNameInfo ="UserModel_FirstName";
    String userLastNameInfo ="UserModel_LastName";
    String userPhoneInfo = "UserModel_HiddenPhone";
    String updateButton = ".updateBtn.active";
    String message = ".toast-message";


    public void clickAccountInfo(){
        findByCss(btnAccountInfo).click();
    }

    public String getTitleMyAccountInfo(){
        return findByCss(titleMyAccountInfo).getText();
    }

    public void setUserNameInfo(String name){
         findById(userNameInfo).setValue(name);
    }

    public String getUserNameInfo(){
        return findById(userNameInfo).getValue();
    }

    public void setUserLastNameInfo(String lastName){
        findById(userLastNameInfo).setValue(lastName);
    }

    public String getUserLastNameInfo(){
        return  findById(userLastNameInfo).getValue();
    }
    public void setUserPhoneInfo(String phone){
        findById(userPhoneInfo).setValue(phone);
    }

    public String getUserPhoneInfo(){
        return findById(userPhoneInfo).getValue();
    }

    public void clickActiveUpdateButton(){
        findByCss(updateButton).click();
    }

    public String getMessage(){
        switchTo().frame(findByCss(message));
        return findByCss(message).getText();
    }

    public SelenideElement getMessageElement(){
        return findByClassName(message);
    }

}
