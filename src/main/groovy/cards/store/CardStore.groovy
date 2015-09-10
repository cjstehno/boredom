/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.store

/**
 * Defines the common storage and loading functionality for cards.
 */
trait CardStore<T> {

    private final List<T> cards = []
    private final Random rng = new Random()

    /**
     * Loads the cards from the text file at the provided path and uses the given closure to create new card
     * instances from each line of the file.
     *
     * @param path the file path
     * @param cardFactory the card factory closure (passed the line of the file)
     */
    void load(final String path, final Closure cardFactory) {
        CardStore.getResourceAsStream(path).eachLine { String line ->
            if (line) {
                cards << cardFactory(line)
            }
        }
    }

    /**
     * Randomly selects one card from the loaded set of cards and returns it.
     *
     * @return the randomly selected card
     */
    T draw() {
        cards[rng.nextInt(cards.size())]
    }

    /**
     * Retrieves a count of the number of cards loaded.
     *
     * @return the number of loaded cards
     */
    int count() {
        cards.size()
    }
}
