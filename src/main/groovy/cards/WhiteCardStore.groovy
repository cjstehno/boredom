package cards

import groovy.util.logging.Slf4j

/**
 * FIXME: document me
 */
interface WhiteCardStore {

    List<WhiteCard> draw(int count)
}

@Slf4j
class TextFileWhiteCardStore implements WhiteCardStore {

    private final List<WhiteCard> cards = []
    private final Random rng = new Random()

    TextFileWhiteCardStore(final String path){
        TextFileWhiteCardStore.getResourceAsStream(path).eachLine { String line->
            if( line ){
                cards << new WhiteCard(text: line.trim())
            }
        }

        log.info 'Loaded {} white cards.', cards.size()
    }

    @Override
    List<WhiteCard> draw(int count) {
        def drawn = []
        count.times {
            drawn << cards[rng.nextInt(cards.size())]
        }
        drawn
    }
}

@Slf4j
class TextFileBlackCardStore implements BlackCardStore {

    private final List<BlackCard> cards = []
    private final Random rng = new Random()

    TextFileBlackCardStore(final String path){
        TextFileBlackCardStore.getResourceAsStream(path).eachLine { String line->
            if( line ){
                cards << new BlackCard(text: line.trim(), blanks: line.count('__________') ?: 1)
            }
        }

        log.info 'Loaded {} black cards.', cards.size()
    }

    @Override
    BlackCard draw() {
        cards[rng.nextInt(cards.size())]
    }
}