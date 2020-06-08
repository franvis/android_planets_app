package ar.francisco.visintini.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.francisco.visintini.planets.item.PlanetItem

class PlanetsViewModel : ViewModel() {

    private val getPlanets = GetPlanets()
    private val _planets = MutableLiveData<List<PlanetItem.ViewState>>()
    val planets: LiveData<List<PlanetItem.ViewState>>
        get() = _planets

    fun start() {
        _planets.value = getPlanets().map { PlanetItem.ViewState(it.name, it.description, it.imageUrl) }
    }
}
