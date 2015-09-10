/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.store

import cards.model.BlackCard

/**
 * Defines the requirements for a black card store.
 */
interface BlackCardStore {

    /**
     * Randomly selects one black card.
     *
     * @return the selected black card
     */
    BlackCard draw()
}
