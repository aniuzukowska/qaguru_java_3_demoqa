import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Sklodowska");
        $("#userEmail").setValue("maria-sklodowska@gmail.com");
        $(".custom-control-label[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $$(".react-datepicker__month-select option").get(1).click();
        $(".react-datepicker__year-select").click();
        $$(".react-datepicker__year-select option").get(100).scrollIntoView(true).click();
        $(".react-datepicker__day--007").click();

        $("#subjectsInput").setValue("Physics");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/picture.jpg");
        $("#currentAddress").setValue("France, Paris");
        $("#state").scrollIntoView(true).click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Maria Sklodowska"));
        $(".modal-body").shouldHave(text("maria-sklodowska@gmail.com"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("07 February,2000"));
        $(".modal-body").shouldHave(text("Physics"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("France, Paris"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
    }
}
