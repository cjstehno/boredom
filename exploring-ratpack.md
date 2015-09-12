I have been wanting to give [Ratpack](http://ratpack.io) a try, and recently I had my opportunity. Ratpack is a light-weight server application framework primarily targeted at microservice development; however, it seems that it's potential goes well beyond that.

To explore it a little bit, I decided to take a riff on my favorite card game, [Cards Against Humanity](http://cardsagainsthumanity.com), and present a random set of cars as if you were playing the game. Basically in the game one person draws a black card which has a question or a fill-in-the-blank statement. The other players pick an appropriate number of white cards from their hands to answer the question or complete the sentence in the most amusing or shocking manner possible. The black card holder picks the winner. In this example, we are just going to pick a random black card and a set of one or more random white cards to create a "winning set" - but more on this later.

First, we need to get started with Ratpack. The Ratpack developers have provided an up-to-date project template via the [Lazybones](https://github.com/pledbrook/lazybones) template tool - if you have not used it before, I recommend looking into it.

Once you have lazybones installed, you can run the following to create your new project - we'll call it "boredom":

    lazybones ratpack create boredom
    
    
    
--------

project setup (lazybones)
default content description
build/run

about the game

wiring the module and service points
- a bit more "designed" that needs to be but trying to actually have something somewhat interesting and meaningful to
play with.

updating the template

(I went a bit far with bootstrap)

(extracting the handler)

unit testing the handler

pushing to heroku
- tool belt
- free account

ideas for future (hystrix, real database)