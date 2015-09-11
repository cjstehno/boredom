/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards

import cards.model.BlackCard
import cards.model.Deck
import cards.model.WhiteCard
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler

import javax.inject.Inject

import static ratpack.groovy.Groovy.groovyTemplate

/**
 * Ratpack handler used to handle card requests.
 */
class CardHandler extends GroovyHandler {

    @Inject Deck<WhiteCard> whiteCards
    @Inject Deck<BlackCard> blackCards

    @Override
    protected void handle(GroovyContext context) {
        context.with {
            def black = blackCards.draw()
            def whites = whiteCards.draw(black.blanks)

            render groovyTemplate('index.html', black: black, whites: whites)
        }
    }
}