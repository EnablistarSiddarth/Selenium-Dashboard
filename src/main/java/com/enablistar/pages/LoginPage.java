package com.enablistar.pages;

import com.enablistar.utils.OllamaLocatorHelper;
import org.openqa.selenium.By;

import static com.enablistar.utils.SeleniumUtils.click;
import static com.enablistar.utils.SeleniumUtils.sendkeys;

public class LoginPage {
//    private By USERNAME;
//    private By PASSWORD;
//    private By BUTTON;
//        WebElement form = Drivermanager.getDriver().findElement(By.tagName("form"));
//        String html = form.getAttribute("outerHTML");
//
//        Map<String, String> locators = ChatGPTLocatorHelper.getParsedLocators(html);
//        System.out.println("🔍 Locators returned by ChatGPT: " + locators);
//
//        Optional<String> usernameKey = locators.keySet().stream()
//                .filter(k -> k.toLowerCase().contains("username"))
//                .findFirst();
//
//        Optional<String> passwordKey = locators.keySet().stream()
//                .filter(k -> k.toLowerCase().contains("password"))
//                .findFirst();
//
//        Optional<String> submitKey = locators.keySet().stream()
//                .filter(k -> k.toLowerCase().contains("login") || k.toLowerCase().contains("submit"))
//                .findFirst();
//
//        if (usernameKey.isEmpty() || passwordKey.isEmpty() || submitKey.isEmpty()) {
//            throw new RuntimeException("❌ One or more locators were not found by ChatGPT.");
//        }
//
//        String usernameLocator = locators.get(usernameKey.get()).replace("`", "").trim();
//        String passwordLocator = locators.get(passwordKey.get()).replace("`", "").trim();
//        String submitLocator = locators.get(submitKey.get()).replace("`", "").trim();
//
//        USERNAME = usernameLocator.startsWith("/") ? By.xpath(usernameLocator) : By.cssSelector(usernameLocator);
//        PASSWORD = passwordLocator.startsWith("/") ? By.xpath(passwordLocator) : By.cssSelector(passwordLocator);
//        BUTTON = submitLocator.startsWith("/") ? By.xpath(submitLocator) : By.cssSelector(submitLocator);
//    }


        private static final By USERNAME = By.id("username");
        private static final By PASSWORD = By.xpath("//*[@placeholder='Enter Password']");
        private static final By BUTTON = By.xpath("//button[@type='submit']");

//      String prompt = "Give XPath for a button with the text 'Login'";
//       String Loginbutton = OllamaLocatorHelper.getDynamicXPath(prompt);
//
//    String prompt1 = "Give XPath for a textbox with the text 'Email Address'";
//    String Emailid = OllamaLocatorHelper.getDynamicXPath(prompt1);
//
//    String prompt2 = "Give XPath for a textbox with the text 'Password'";
//    String password = OllamaLocatorHelper.getDynamicXPath(prompt2);




//        private final By USERNAME = By.xpath(Emailid);;
//        private  final By PASSWORD = By.xpath(password);
//        private  final By BUTTON = By.xpath(Loginbutton);

    public LoginPage() throws Exception {
    }


    private LoginPage setUsername (String username){
            sendkeys(USERNAME, username, "Username");
            return this;
        }

        private LoginPage setPassword (String password){
            sendkeys(PASSWORD, password, "Password");
            return this;
        }

        private HomePage setButton () throws InterruptedException {
            click(BUTTON, "LoginButton");
            return new HomePage();
        }

        public HomePage LoginApp (String username, String password) throws InterruptedException {
            return setUsername(username)
                    .setPassword(password)
                    .setButton();


        }

    }
