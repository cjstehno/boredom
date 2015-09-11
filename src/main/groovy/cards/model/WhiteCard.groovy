/*
    Licensed under:
    Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic
    https://creativecommons.org/licenses/by-nc-sa/2.0/
*/
package cards.model

import groovy.transform.Immutable

/**
 * Represents a white (answer) card.
 */
@Immutable
class WhiteCard implements Card {

    String text

    static Closure factory(){
        return { line->
            new WhiteCard(text: line.trim())
        }
    }
}

