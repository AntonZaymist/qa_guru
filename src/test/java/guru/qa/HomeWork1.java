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
//      $x("//td[text()='Student Name']/following::td").shouldHave(text("Anton Jmishenko")); подсмотрелрешение через xpath
//      $("tbody").$(byText("Student Name")).parent().shouldHave(text("Anton Jmishenko"));
        $(".modal-body").shouldHave(text("Anton Jmishenko"));
        $(".modal-body").shouldHave(text("vakavaka@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9855553366"));
        $(".modal-body").shouldHave(text("18 March,1999"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("hqdefault-5.jpg"));
        $(".modal-body").shouldHave(text("Moscow Krasnopresnenskaya, 12"));
        $(".modal-body").shouldHave(text("NCR Delhi"));


    }
}


