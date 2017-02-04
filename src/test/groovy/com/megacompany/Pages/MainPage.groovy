package com.megacompany.Pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.ElementsCollection
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.By
import ru.yandex.qatools.allure.annotations.Step

import static com.codeborne.selenide.Selenide.*

class MainPage {

    @Step
    openMainPage() {
        Configuration.browser = "Chrome"
        ChromeDriverManager.getInstance().setup()
        open("http://computer-database.gatling.io/")
    }

    @Step
    ElementsCollection filterByName(String name) {
        $("#searchbox").val(name)
        $("#searchsubmit").click()
    }

    @Step
    ElementsCollection getNameFilterResults() {
        return $$(By.xpath(".//tbody/tr/td[1]/a"))
    }

    @Step
    ElementsCollection getCompanyFilterResults() {
        return $$(By.xpath(".//tbody/tr/td[4]"))
    }

    @Step
    clickAddNewComputerButton() {
        $("#add").click()
    }

    @Step("Should have text: {0}")
    acceptMessage(String text) {
        return $(".alert-message").shouldHave(Condition.text(text))
    }

    @Step
    removeComputer(String name) {
        filterByName(name)
        getNameFilterResults().first().click()
        $(".btn.danger").click()
        acceptMessage("Done! Computer has been deleted")
    }

}
