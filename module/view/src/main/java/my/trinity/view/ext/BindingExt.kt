package my.trinity.view.ext

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("onSwipe")
fun SwipeRefreshLayout.onSwipe(onSwipe: () -> Unit) {
    this.setOnRefreshListener {
        onSwipe()
    }
}