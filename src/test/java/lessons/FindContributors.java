package lessons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
     void findContributorsterst() {

        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div")
                .$("ul li").hover();
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        sleep(5000);
    }
}
