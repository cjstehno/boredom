package cards.model

import groovy.transform.CompileStatic

import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * FIXME: document me
 */
@CompileStatic
class Deck<T> {

    private final ReadWriteLock locker = new ReentrantReadWriteLock()
    private final List<T> cards = []
    private int nextCard = 0

    Deck(final Collection<T> cards) {
        this.cards = new LinkedList<T>(cards)
        shuffle()
    }

    T draw() {
        locker.readLock().lock()
        try {
            if (nextCard >= cards.size()) {
                locker.readLock().unlock()
                locker.writeLock().lock()
                try {
                    if (nextCard >= cards.size()) {
                        shuffle()
                    }
                    locker.readLock().lock()

                } finally {
                    locker.writeLock().unlock()
                }
            }

            cards[nextCard++]

        } finally {
            locker.readLock().unlock()
        }
    }

    List<T> draw(int count) {
        (1..count).collect {
            draw()
        }
    }

    private void shuffle() {
        Collections.shuffle(cards)
        nextCard = 0
    }
}
