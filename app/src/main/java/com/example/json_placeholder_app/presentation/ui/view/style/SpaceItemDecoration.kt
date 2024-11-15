package com.example.json_placeholder_app.presentation.ui.view.style

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space
        }
    }
}
