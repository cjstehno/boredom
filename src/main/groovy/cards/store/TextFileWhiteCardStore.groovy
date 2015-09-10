package cards.store

import cards.WhiteCard
import groovy.util.logging.Slf4j

/**
 * FIXME: document me
 */
@Slf4j
class TextFileWhiteCardStore implements WhiteCardStore, CardStore<WhiteCard> {

    TextFileWhiteCardStore(final String path) {
        load(path) { line ->
            new WhiteCard(text: line.trim())
        }

        log.info 'Loaded {} white cards.', count()
    }

    @Override
    List<WhiteCard> draw(int count) {
        def drawn = []
        count.times {
            drawn << draw()
        }
        drawn
    }
}
