def outfile = new File('c:/Users/cstehno/Desktop/external/cards.sql')

// white cards
def whiteCards = 'http://www.cardsagainsthumanity.com/wcards.txt'.toURL().text[9..-1].split('<>')

outfile << '# white cards\n'

whiteCards.each { card->
    outfile << "${card}\n"
}

// black cards
def blackCards = []

[
    'http://www.cardsagainsthumanity.com/bcards.txt', 
    'http://www.cardsagainsthumanity.com/bcards1.txt', 
    'http://www.cardsagainsthumanity.com/bcards2.txt'
].each { url->
    blackCards.addAll( url.toURL().text[6..-1].split('<>') )
}

outfile << '# black cards\n'

blackCards.each { card->
    outfile << "${card}\n"
}

println 'Done.'