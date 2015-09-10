import cards.CardHandler
import cards.CardsModule
import ratpack.groovy.template.TextTemplateModule

import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module TextTemplateModule
        module CardsModule

        bindInstance(new CardHandler())
    }

    handlers {
        get CardHandler

        files { dir "public" }
    }
}

