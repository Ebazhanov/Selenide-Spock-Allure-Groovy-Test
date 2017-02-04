package com.megacompany.Pages

import ru.yandex.qatools.allure.annotations.Step

import static com.codeborne.selenide.Selenide.$

class AddNewComputerPage {

    @Step
    fillAddNewComputerForm(String name, String introducedDate, String discontinuedDate, String company) {
        $("#name").val(name)
        assert introducedDate ==~ /\d{4}\-\d{2}\-\d{2}/
        $("#introduced").val(introducedDate)
        assert discontinuedDate ==~ /\d{4}\-\d{2}\-\d{2}/
        $("#discontinued").val(discontinuedDate)
        $("#company").selectOption(company)
        $("input.btn").click()
    }
}
