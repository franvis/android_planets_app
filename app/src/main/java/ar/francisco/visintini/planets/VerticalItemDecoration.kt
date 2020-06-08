package ar.francisco.visintini.planets

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class VerticalItemDecoration : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val dividerLeft = parent.paddingLeft
        val dividerRight = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val lineHeight =
                parent.context.resources.getDimensionPixelSize(R.dimen.item_decoration_height)

            val dividerTop = child.bottom + params.bottomMargin
            val dividerBottom = dividerTop + lineHeight

            val paint = Paint()
            paint.color = ContextCompat.getColor(parent.context, R.color.blueGreySoft)

            c.drawRect(Rect(dividerLeft, dividerTop, dividerRight, dividerBottom), paint)
        }
    }
}
