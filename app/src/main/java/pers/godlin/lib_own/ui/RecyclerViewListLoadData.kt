package pers.godlin.lib_own.ui

import androidx.recyclerview.widget.RecyclerView

/**
 * @author: gentlemanhu
 * @date: 2022/5/13
 */
interface RecyclerViewListLoadData<T> {
    fun loadData(recyclerView: RecyclerView): List<T>
}