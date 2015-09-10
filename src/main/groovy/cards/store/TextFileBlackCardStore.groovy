/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.store

import cards.model.BlackCard
import groovy.util.logging.Slf4j

/**
 * Defines the text-file-based card store for black cards.
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
