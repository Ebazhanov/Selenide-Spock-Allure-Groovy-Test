package com.megacompany.base

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class GlobalSpecExtension implements IGlobalExtension {

    @Override
    void start() {}

    @Override
    void visitSpec(SpecInfo spec) {
        spec.addListener(new CustomListener()) //add screenshot listener
    }

    @Override
    void stop() {}

}
