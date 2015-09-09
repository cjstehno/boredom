package cards

/**
 * FIXME: document me
 */
class InMemoryCardSelector implements CardSelector {

    private blacks = [
        "In the new Disney Channel Original Movie, Hannah Montana struggles with __________ for the first time.",
        "What's my secret power?",
        "What's the new fad diet?",
        "What did Vin Diesel eat for dinner?",
        "When Pharaoh remained unmoved, Moses called down a Plague of __________.",
        "How am I maintaining my relationship status?",
        "What's the crustiest?",
        "In L.A. County Jail, word is you can trade 200 cigarettes for __________.",
        "After the earthquake, Sean Penn brought __________ to the people of Haiti.",
        "Instead of coal, Santa now gives the bad children __________.",
        "Life for American Indians was forever changed when the White Man introduced them to __________.",
        "What's Teach for America using to inspire inner city students to succeed?",
        "Maybe she's born with it. Maybe it's __________.",
        "In Michael Jackson's final moments, he thought about __________."
    ]

    private whites = [
        '72 virgins.',
        'A drive-by shooting.',
        'A time travel paradox.',
        'Authentic Mexican cuisine.',
        'Bling.',
        'Consultants.',
        'Crippling debt.',
        'Daddy issues.'
    ]

    private Random rng = new Random()

    @Override
    List<WhiteCard> drawWhite(int count) {
        def cards = []
        count.times {
            cards << new WhiteCard(text: whites[rng.nextInt(whites.size())])
        }
        cards
    }

    @Override
    BlackCard drawBlack() {
        def blackCard = blacks[rng.nextInt(blacks.size())]
        int blanks = blackCard.count('__________') ?: 1

        new BlackCard(text: blackCard, blanks: blanks)
    }
}
