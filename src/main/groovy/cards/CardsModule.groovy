package cards

import com.google.inject.AbstractModule

/**
 * FIXME: document me
 */
class CardsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind CardSelector to InMemoryCardSelector
    }
}
