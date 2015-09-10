/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.model

import groovy.transform.Canonical

/**
 * Represents a black (question) card.
 */
@Canonical
class BlackCard implements Card {

    /**
     * The number of answer blanks presented by the question.
     */
    int blanks
}
