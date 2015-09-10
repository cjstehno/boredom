package cards.store

import cards.BlackCard
import groovy.util.logging.Slf4j

/**
 * FIXME: document me
 */
@Slf4j
class TextFileBlackCardStore implements BlackCardStore, CardStore<BlackCard> {

    TextFileBlackCardStore(final String path) {
        load(path) { line ->
            new BlackCard(text: line.trim(), blanks: line.count('__________') ?: 1)
        }

        log.info 'Loaded {} black cards.', count()
    }
}
