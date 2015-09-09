import cards.CardSelector
import cards.CardsModule
import ratpack.groovy.template.TextTemplateModule

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module TextTemplateModule
        module CardsModule
    }

    handlers {
        get { CardSelector cards ->
            def black = cards.drawBlack()
            def whites = cards.drawWhite(black.blanks)

            render groovyTemplate("index.html", black: black, whites: whites)
        }

        files { dir "public" }
    }
}
