package com.megacompany.base

import com.codeborne.selenide.Screenshots
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.BlockInfo
import org.spockframework.runtime.model.ErrorInfo
import org.spockframework.runtime.model.FeatureInfo
import ru.yandex.qatools.allure.Allure
import ru.yandex.qatools.allure.events.AddParameterEvent
import ru.yandex.qatools.allure.events.MakeAttachmentEvent


class CustomListener extends AbstractRunListener {
    void afterFeature(FeatureInfo feature) {
        for (BlockInfo block : feature.getBlocks()) {
            Allure.LIFECYCLE.fire(new AddParameterEvent(block.getKind().name(), block.getTexts().toString()))
        }
    }

    void error(ErrorInfo error) {
        makeAttachment(Screenshots.getLastScreenshot(), "image/png")
    }

    private void makeAttachment(File file, String type) {
        Allure.LIFECYCLE.fire(new MakeAttachmentEvent(file.bytes, file.name, type))
    }
}
