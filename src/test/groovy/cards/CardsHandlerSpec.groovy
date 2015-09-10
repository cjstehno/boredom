/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards

import cards.model.BlackCard
import cards.model.WhiteCard
import cards.store.BlackCardStore
import cards.store.WhiteCardStore
import ratpack.groovy.template.TextTemplate
import spock.lang.Specification

import static ratpack.groovy.test.handling.GroovyRequestFixture.handle

class CardsHandlerSpec extends Specification {

    private static final BlackCard BLACK_CARD = new BlackCard(text: 'Why am I sticky?', blanks: 1)
    private static final WhiteCard WHITE_CARD = new WhiteCard(text: 'Middle-class white guys.')

    private WhiteCardStore whiteCards = Mock(WhiteCardStore)
    private BlackCardStore blackCards = Mock(BlackCardStore)
    private CardHandler handler

    def setup() {
        handler = new CardHandler(whiteCards: whiteCards, blackCards: blackCards)
    }

    def 'handle'() {
        setup:
        1 * blackCards.draw() >> BLACK_CARD
        1 * whiteCards.draw(1) >> [WHITE_CARD]

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
