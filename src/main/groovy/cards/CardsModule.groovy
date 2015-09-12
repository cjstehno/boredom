/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards

import cards.model.BlackCard
import cards.model.WhiteCard
import cards.store.Deck
import cards.store.DeckLoader
import com.google.inject.AbstractModule
import com.google.inject.Provides
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j

/**
 * Guice module used to configure the CardStore instances.
 */
@Slf4j @TypeChecked @SuppressWarnings('GroovyUnusedDeclaration')
class CardsModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides Deck<WhiteCard> provideWhiteCardDeck() {
        new DeckLoader<WhiteCard>().load(
            CardsModule.getResource('/whitecards.txt'),
            WhiteCard.factory()
        )
    }

    @Provides Deck<BlackCard> provideBlackCardDeck() {
        new DeckLoader<BlackCard>().load(
            CardsModule.getResource('/blackcards.txt'),
            BlackCard.factory()
        )
    }
}