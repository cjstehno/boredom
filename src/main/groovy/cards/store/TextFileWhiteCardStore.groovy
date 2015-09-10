/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.store

import cards.model.WhiteCard
import groovy.util.logging.Slf4j

/**
 * Defines the text-file-based card store for white cards.
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
