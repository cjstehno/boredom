/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards

import cards.store.BlackCardStore
import cards.store.TextFileBlackCardStore
import cards.store.TextFileWhiteCardStore
import cards.store.WhiteCardStore
import com.google.inject.AbstractModule

/**
 * Guice module used to configure the CardStore instances.
 */
class CardsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WhiteCardStore).toInstance(new TextFileWhiteCardStore('/whitecards.txt'))

        bind(BlackCardStore).toInstance(new TextFileBlackCardStore('/blackcards.txt'))

    }
}