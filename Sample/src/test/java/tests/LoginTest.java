package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
        //HomePage'in methodlarını kullanabilmem için tanımlamam gerekiyor.
        //driver ve wait'de @BeforeClass, @Test'den daha önce çalıştığı için doldu.
        //HomePage tipinde bir obje oluşturuyorum. Constructor'unde driver ve wait olduğu için onları yazıyorum. Zaten
        //bu ikisinin de içini @BeforeClass adımında BaseTest'de doldurmuştum.
        //Sonra, bu dolu driver ve wait, HomaPage Class'ındaki constructor'a gidiyor.
        //Oradaki constructor'da da super() methodu olduğu için hem HomePage class'ı içerisinde, hem de HomePage'in
        //türemiş olduğu temel sınıf olan BasePage'de bunlar otomatik olarak eşitleniyor.
        //Kısaca:
        // 1) @BeforeClass'da driver ve wait dolduruldu.
        // 2) Bu driver ve wait Homepage homepage = new HomePage(driver,wait); satırında HomePage Class'ındaki
        //    constructor'a gönderildi.
        // 3) HomePage class� � ndaki constructor'� � n içindeki super () methoduda bu dolu olan driver ve wait'i
        // BasePage class'� � ndaki driver ve wait ile eşitledi.
        HomePage homePage = new HomePage (driver, wait);

        // N11 anasayfas� � n� � Aç
        homePage.goToN11 ();

        // N11 Login Sayfas� � na Git
        homePage.goToLoginPage ();

        LoginPage loginPage = new LoginPage (driver, wait);

        // Login to N11
        loginPage.loginToN11 ("goknur@goknur.com", "11223344");

        // Verification
        Thread.sleep (500);
        loginPage.verifyLoginPassword (("E-posta adresiniz veya şifreniz hatal� �"));

    }}

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPass () throws InterruptedException {
        HomePage homePage = new HomePage (driver, wait);
        homePage.goToN11 ();
        homePage.goToLoginPage ();
        LoginPage loginPage = new LoginPage (driver, wait);
        loginPage.loginToN11 ("", "");
        Thread.sleep (500);
        loginPage.verifyLoginUserName ("Literature e-posta adresinizi girin.");
        loginPage.verifyLoginPassword ("There was a hard drive in the zorunludur.");
    }}


}}

