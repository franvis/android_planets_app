package ar.francisco.visintini.planets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ar.francisco.visintini.planets.item.PlanetItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_planets.*
import kotlinx.android.synthetic.main.fragment_planets.view.view_planets

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PlanetsFragment : Fragment(R.layout.fragment_planets) {

    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel: PlanetsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.view_planets.adapter = adapter
        view.view_planets.addItemDecoration(VerticalItemDecoration())
    }

    override fun onStart() {
        super.onStart()
        viewModel.planets.observe(viewLifecycleOwner, Observer(::render))
        viewModel.start()
    }

    private fun render(planetsViewState: PlanetsViewState) {
        view_planets.isVisible = !planetsViewState.isLoading
        view_loader.isVisible = planetsViewState.isLoading
        adapter.update(planetsViewState.planets.map(::PlanetItem))
    }
}

data class PlanetsViewState(val isLoading: Boolean, val planets: List<PlanetItem.ViewState>)