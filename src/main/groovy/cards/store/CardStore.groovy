package cards.store

/**
 * FIXME: document me
 */
trait CardStore<T> {

    private final List<T> cards = []
    private final Random rng = new Random()

    void load(final String path, final Closure cardFactory) {
        CardStore.getResourceAsStream(path).eachLine { String line ->
            if (line) {
                cards << cardFactory(line)
            }
        }
    }

    T draw() {
        cards[rng.nextInt(cards.size())]
    }

    int count() {
        cards.size()
    }
}
