package pers.godlin.lib_own.model

import pers.godlin.lib_own.ui.OnMyRecyclerViewItemClick
import pers.godlin.lib_own.ui.RecyclerViewListLoadData

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */
data class  RecyclerViewData<T>(
    val id: Int,
    val name: String,
    val listDataLoad: RecyclerViewListLoadData<T>? = null,
    val onItemClickListener: OnMyRecyclerViewItemClick<T>? = null
)
