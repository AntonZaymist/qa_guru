package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;

import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork1 {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Jmishenko");
        $("#userEmail").setValue("vakavaka@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9855553366");

        $("#dateOfBirthInput").click(); // Можно ли проверить дату рождения, вручную заполнив поле?
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--018").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click(); // Можно ли выделить 2 чекбокса
        $("#hobbiesWrapper").$(byText("Reading")).click();// одной строкой?

        File file = new File("src/test/resources/hqdefault-5.jpg");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Moscow Krasnopresnenskaya, 12");

        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();

        $("#submit").click();

//      Проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//      $x("//td[text()='Student Name']/following::td").shouldHave(text("Anton Jmishenko")); подсмотрел решение через xpath
        $("tbody").$(byText("Student Name")).parent().shouldHave(text("Anton Jmishenko"));
        $("tbody").$(byText("Student Email")).parent().shouldHave(text("vakavaka@gmail.com"));
        $("tbody").$(byText("Gender")).parent().shouldHave(text("Male"));
        $("tbody").$(byText("Mobile")).parent().shouldHave(text("9855553366"));
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text("18 March,1999"));
        $("tbody").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $("tbody").$(byText("Picture")).parent().shouldHave(text("hqdefault-5.jpg"));
        $("tbody").$(byText("Address")).parent().shouldHave(text("Moscow Krasnopresnenskaya, 12"));
        $("tbody").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

// Пытался запустить тесты без метода .parent(), тест падал, долго ломал голову в итоге подсомотрел решение.
// Почитал про родительский селектор, понял не особо много. Хотелось бы узнать зачем он нужен и можно ли обойтись без
// вызова этого метода?


    }
}


