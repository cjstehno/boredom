package cards

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