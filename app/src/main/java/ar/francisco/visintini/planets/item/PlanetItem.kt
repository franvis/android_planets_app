package ar.francisco.visintini.planets.item

import ar.francisco.visintini.planets.R
import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_planet.*

data class PlanetItem(val viewState: ViewState) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            view_planet_name.text = viewState.name
            view_planet_description.text = viewState.description
            Glide.with(itemView.context).load(viewState.imageUrl).into(view_planet_image)
        }
    }

    override fun getLayout() = R.layout.item_planet

    override fun isSameAs(other: com.xwray.groupie.Item<*>): Boolean {
        return other is PlanetItem && other.viewState == this.viewState
    }

    data class ViewState(val name: String, val description: String, val imageUrl: String)
}
