/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.store

import cards.model.WhiteCard

/**
 * Defines the requirements for a white card store.
 */
interface WhiteCardStore {

    /**
     * Randomly selects the given number of white cards.
     *
     * @param count the number of cards to select
     * @return the list of selected cards
     */
    List<WhiteCard> draw(int count)
}



