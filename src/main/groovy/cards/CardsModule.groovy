/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards

import cards.model.BlackCard
import cards.store.Deck
import cards.model.WhiteCard
import cards.store.DeckLoader
import com.google.inject.AbstractModule
import com.google.inject.Provides

/**
 * Guice module used to configure the CardStore instances.
 */
class CardsModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    Deck<WhiteCard> provideWhiteCardDeck() {
        new DeckLoader<WhiteCard>().load(
            CardsModule.getResource('/whitecards.txt'),
            WhiteCard.factory()
        )
    }

    @Provides
    Deck<BlackCard> provideBlackCardDeck() {
        new DeckLoader<BlackCard>().load(
            CardsModule.getResource('/blackcards.txt'),
            BlackCard.factory()
        )
    }
}