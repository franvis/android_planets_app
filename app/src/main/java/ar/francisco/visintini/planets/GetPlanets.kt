package ar.francisco.visintini.planets

import kotlin.random.Random

class GetPlanets {
    operator fun invoke(): List<Planet> {
        return listOf(
            Planet("Earth", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Saturn", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Jupiter", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Mercury", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Venus", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Neptune", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Mars", "Our home", distanceToTheSun = Random.nextDouble()),
            Planet("Uranus", "Our home", distanceToTheSun = Random.nextDouble())
        )
    }
}