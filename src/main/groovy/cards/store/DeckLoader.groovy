package cards.store

import cards.model.Deck
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j

/**
 * Loads the cards for a deck from the content of the specified URL (generally a file on the system).
 */
@Slf4j @CompileStatic
class DeckLoader<T> {

    Deck<T> load(URL dataUri, Closure<T> cardFactory) {
        def cards = []

        dataUri.eachLine { line ->
            if (line) {
                cards << cardFactory(line as String)
            }
        }

        log.info 'Loaded {} {}.', cards.size(), cards[0].class.simpleName

        new Deck<T>(cards)
    }
}
