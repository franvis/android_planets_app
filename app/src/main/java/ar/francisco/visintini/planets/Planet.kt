package ar.francisco.visintini.planets

data class Planet(
    val name: String,
    val description: String,
    val imageUrl: String = "https://swift-training.s3-eu-west-1.amazonaws.com/Earth.png",
    val distanceToTheSun: Double
)
