package lessons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideRepository() {
        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        SelenideElement firstLinkFound = $$(".repo-list li").first().$("a"); // Почему не работает var
        firstLinkFound.click();
        $("h1").shouldHave(text("selenide / selenide"));


    }
}
