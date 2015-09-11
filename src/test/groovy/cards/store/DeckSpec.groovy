package cards.store

import cards.model.WhiteCard
import cards.store.Deck
import spock.lang.Specification

class DeckSpec extends Specification {

    private static final List<WhiteCard> CARDS = [
        new WhiteCard(text: 'alpha'),
        new WhiteCard(text: 'bravo'),
        new WhiteCard(text: 'charlie')
    ]

    private Deck deck = new Deck<WhiteCard>(CARDS)

    def 'draw one'(){
        when:
        def card = deck.draw()

        then:
        card in CARDS
    }

    def 'draw four'(){
        when:
        def cards = deck.draw(4)

        then:
        cards.size() == 4
        cards[0] in CARDS
        cards[1] in CARDS
        cards[2] in CARDS
        cards[3] in CARDS
    }
}
