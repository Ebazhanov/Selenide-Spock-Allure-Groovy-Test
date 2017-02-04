package com.megacompany.test

import com.codeborne.selenide.Condition
import com.megacompany.Pages.AddNewComputerPage
import com.megacompany.Pages.MainPage
import ru.yandex.qatools.allure.annotations.Title
import spock.lang.Specification

@Title("Simple Specification")
class SimpleTest extends Specification {

    MainPage mainPage = new MainPage()
    AddNewComputerPage addNewComputerPage = new AddNewComputerPage()

    def "Ability to add new computer"() {
        String compName = "Megatron"
        given: "Open URL"
        mainPage.openMainPage()
        and: "Open Add new computer form"
        mainPage.clickAddNewComputerButton()
        when: "Fill all fields"
        addNewComputerPage.fillAddNewComputerForm(compName, "2016-01-01", "2016-01-05", "Timex Sinclair")
        then: "Accept message should be dislayed"
        mainPage.acceptMessage("Done! Computer " + compName + " has been created")
        cleanup: "Remove computer"
        mainPage.removeComputer(compName)
    }

    def "Ability to filter computers by name"() {
        given: "Open URL"
        mainPage.openMainPage()
        when: "Enter apple"
        mainPage.filterByName(name)
        then: "Result table should have 10 rows"
        mainPage.nameFilterResults.first().should(Condition.text(name))
        mainPage.companyFilterResults.first().should(Condition.text(company))

        where:
        name          || company
        "apple"       || "Apple Inc."
        "ASCI Purple" || "IBM"
        "Amiga"       || "Amiga Corporation"
    }

}
