import cards.store.BlackCardStore
import cards.CardsModule
import cards.store.WhiteCardStore
import ratpack.groovy.template.TextTemplateModule

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module TextTemplateModule
        module CardsModule
    }

    handlers {
        get { WhiteCardStore whiteCards, BlackCardStore blackCards->
            def black = blackCards.draw()
            def whites = whiteCards.draw(black.blanks)

            render groovyTemplate("index.html", black: black, whites: whites)
        }

        files { dir "public" }
    }
}
