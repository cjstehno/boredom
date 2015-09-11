/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.model

import groovy.transform.Immutable

/**
 * Represents a black (question) card.
 */
@Immutable
class BlackCard implements Card {

    String text

    /**
     * The number of answer blanks presented by the question.
     */
    int blanks

    static Closure factory(){
        return { line->
            new BlackCard(text: line.trim(), blanks: line.count('__________') ?: 1)
        }
    }
}
