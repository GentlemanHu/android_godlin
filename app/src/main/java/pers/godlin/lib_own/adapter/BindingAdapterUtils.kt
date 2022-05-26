package pers.godlin.lib_own.adapter

import com.drake.brv.BindingAdapter
import pers.godlin.lib_own.ui.OnMyRecyclerViewItemClick

/**
 * @author: gentlemanhu
 * @date: 2022/5/13
 */
fun <DT> BindingAdapter.BindingViewHolder.setOnItemClickDispatcherListener(listener: OnMyRecyclerViewItemClick<DT>?) {
    this.itemView.setOnClickListener {
        listener?.onClick(it, getModel() as DT)
    }
}