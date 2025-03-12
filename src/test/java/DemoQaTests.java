import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest(){
        open("automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(Condition.text("Student Name Test Test"));
        $(".table-responsive").shouldHave(Condition.text("Student Email test@test.com"));
        $(".table-responsive").shouldHave(Condition.text("Gender Male"));
        $(".table-responsive").shouldHave(Condition.text("Mobile 1111111111"));
        $(".table-responsive").shouldHave(Condition.text("Date of Birth 02 January,2000"));
        $(".table-responsive").shouldHave(Condition.text("Subjects Computer Science"));
        $(".table-responsive").shouldHave(Condition.text("Hobbies Reading"));
        $(".table-responsive").shouldHave(Condition.text("Picture test.jpg"));
        $(".table-responsive").shouldHave(Condition.text("Address Some street 1"));
        $(".table-responsive").shouldHave(Condition.text("State and City NCR Delhi"));
    }
}
