package cards

import cards.store.BlackCardStore
import cards.store.TextFileBlackCardStore
import cards.store.TextFileWhiteCardStore
import cards.store.WhiteCardStore
import com.google.inject.AbstractModule

/**
 * FIXME: document me
 */
class CardsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WhiteCardStore)
            .toInstance(new TextFileWhiteCardStore('/whitecards.txt'))

        bind(BlackCardStore)
            .toInstance(new TextFileBlackCardStore('/blackcards.txt'))
    }
}