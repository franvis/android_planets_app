package ar.francisco.visintini.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.francisco.visintini.planets.item.PlanetItem
import domain.interactor.GetPlanets

class PlanetsViewModel : ViewModel() {

    private val getPlanets = GetPlanets()
    private val _planets = MutableLiveData<List<PlanetItem.ViewState>>()
    val planets: LiveData<List<PlanetItem.ViewState>>
        get() = _planets

    fun start() {
        getPlanets.invoke { planets ->
            _planets.value = planets.map {
                PlanetItem.ViewState(
                    it.name,
                    it.shortDescription,
                    it.imageUrl
                )
            }
        }
    }
}
