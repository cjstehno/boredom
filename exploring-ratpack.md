title=Exploring Ratpack
date=2015-09-12
type=post
tags=blog,groovy
status=published
~~~~~~
I have been wanting to give [Ratpack](http://ratpack.io) a try, and recently I had my opportunity. Ratpack is a light-weight server application framework primarily targeted at microservice development; however, it seems that it's potential goes well beyond that.

To explore it a little bit, I decided to take a riff on my favorite card game, [Cards Against Humanity](http://cardsagainsthumanity.com), and present a random set of cars as if you were playing the game. Basically in the game one person draws a black card which has a question or a fill-in-the-blank statement. The other players pick an appropriate number of white cards from their hands to answer the question or complete the sentence in the most amusing or shocking manner possible. The black card holder picks the winner. In this example, we are just going to pick a random black card and a set of one or more random white cards to create a "winning set" - but more on this later.

First, we need to get started with Ratpack. The Ratpack developers have provided an up-to-date project template via the [Lazybones](https://github.com/pledbrook/lazybones) template tool - if you have not used it before, I recommend looking into it.

Once you have lazybones installed, you can run the following to create your new project - we'll call it "boredom" (short for Cards Against Boredom):

    lazybones ratpack create boredom

Notice that what you end up with is a standard Gradle project with all the Ratpack configurations baked in. You can run:

    ./gradlew run

at this point to build the project and start of the server (embedded), which will simply render a default welcome page. 
    
The project layout is mostly standard for a Java/Groovy project; however, they have added a second source directory, the `ratpack` directory which contains the configuration and web content for the project. The `public` directory contains the static resources for the web layer, while the `templates` directory is where the view templates are stored for use by the handlers. The other artifact in the directory is the `Ratpack.groovy` file, which is the main configuration point for the application, where your bindings and handlers are configured.


> FIXME: figure out whether to go full tutorial or just discuss the app here...

In the interest of time, I am not going to walk through a whole development tutorial here, but will rather discuss the application that I created, what the parts are and why they were created. You will want to refer to the source code for the "Cards Against Boredom" application ([boredom](https://github.com/cjstehno/boredom)) for more details going forward.

wiring
templates (+bootstrap)
handlers
unit testing


Once your application is done you can deploy it to one of the many PaaS offerings, such as [Heroku](http://heroku.com). I chose Heroku due to it's moderatly useful free-tier option, and it's pretty simple to use.

download their tools
login
push (make sure everything is checked in)
    

The application I created serves no purpose other than random humor, but it does provide a glimse into what can be done very quickly with Ratpack. The project has matured quite a bit over the past year and they are rolling in a lot more supported modules for things like security, Spring integration and reliability services - again mostly targeting the microservice aspect, but still useful in general for quick web-based projects.
