package ar.francisco.visintini.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.francisco.visintini.planets.item.PlanetItem
import domain.interactor.GetPlanets

class PlanetsViewModel : ViewModel() {

    private val getPlanets = GetPlanets()
    private val _planets = MutableLiveData<PlanetsViewState>()
    val planets: LiveData<PlanetsViewState>
        get() = _planets

    fun start() {
        _planets.postValue(PlanetsViewState(true, emptyList()))
        getPlanets.invoke { planets ->
            _planets.postValue(PlanetsViewState(false, planets.map {
                PlanetItem.ViewState(
                    it.name,
                    it.shortDescription,
                    it.imageUrl
                )
            }))
        }
    }
}
