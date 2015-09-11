/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards

import cards.model.BlackCard
import cards.store.Deck
import cards.model.WhiteCard
import ratpack.groovy.template.TextTemplate
import spock.lang.Specification

import static ratpack.groovy.test.handling.GroovyRequestFixture.handle

class CardsHandlerSpec extends Specification {

    private static final BlackCard BLACK_CARD = new BlackCard(text: 'Why am I sticky?', blanks: 1)
    private static final WhiteCard WHITE_CARD = new WhiteCard(text: 'Middle-class white guys.')

    private Deck<WhiteCard> whiteCards = new Deck<>([WHITE_CARD])
    private Deck<BlackCard> blackCards = new Deck<>([BLACK_CARD])
    private CardHandler handler

    def setup() {
        handler = new CardHandler(whiteCards: whiteCards, blackCards: blackCards)
    }

    def 'handle'() {
        when:
        def result = handle(handler) {
            uri '/'
        }

        then:
        def template = result.rendered(TextTemplate)
        template.id == 'index.html'
        !template.type

        template.model.whites == [WHITE_CARD]
        template.model.black == BLACK_CARD
    }
}
