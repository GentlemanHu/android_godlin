package pers.godlin.lib_own.ui

import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.drake.brv.utils.*
import com.drake.tooltip.toast
import kotlinx.coroutines.launch
import pers.godlin.lib_godlin.ext.viewModel
import pers.godlin.lib_godlin.views.mView
import pers.godlin.lib_own.R
import pers.godlin.lib_own.adapter.setOnItemClickDispatcherListener
import pers.godlin.lib_own.base.BaseActivity
import pers.godlin.lib_own.base.BaseViewModel
import pers.godlin.lib_own.databinding.ActivityMainBinding
import pers.godlin.lib_own.job.scheduleRepeatedly
import pers.godlin.lib_own.model.Card
import pers.godlin.lib_own.model.RecyclerViewData
import pers.godlin.lib_own.ui.HomeActivity.HomeUI.loadRecyclerView


/**
 * @author: gentlemanhu
 * @date: 2022/3/11
 */
class HomeActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    RecyclerViewListLoadData<Card> {
    override val vm by viewModel<HomeActivityVM>()
    private var count = 0

    override fun initView() {
        super.initView()

        loadRecyclerView(container) { rv ->
            rv.models = listOf(
                RecyclerViewData(6, "fd", this@HomeActivity) { v, data ->
                    toast("${v.id}---${data.id}")
                }
            )
            lifecycleScope.launch {
                scheduleRepeatedly(2000L, 30) {
                    rv.addModels(listOf(
                        RecyclerViewData(6, "fd", this@HomeActivity) { v, data ->
                            toast("${v.id}---${data.id}")
                        }
                    ))
                    rv.adapter?.itemCount?.let {
                        rv.smoothScrollToPosition(it - 1)
                    }
                }
            }
        }

        while (true){
            println("xxxx---无限循环")
        }
    }

    override fun initData() {
        super.initData()
    }


    private object HomeUI {
        inline fun loadRecyclerView(container: ViewGroup, dataLoad: (RecyclerView) -> Unit) {
            container.apply {
                mView<RecyclerView> {
                    linear()
                    setup {
                        addType<Card>(R.layout.item_card)
                        addType<RecyclerViewData<Card>>(R.layout.item_recyclerview)

                        onBind {
                            when (itemViewType) {
                                R.layout.item_recyclerview -> {
                                    val model =
                                        getModel<RecyclerViewData<Card>>()
                                    findView<RecyclerView>(R.id.rv_container).apply {
                                        linear().setup {
                                            addType<Card>(R.layout.item_card)
                                            onBind {
                                                setOnItemClickDispatcherListener(model.onItemClickListener)
                                            }
                                        }.models = model.listDataLoad?.loadData(this)
                                    }
                                }
                                R.layout.item_card -> {

                                }
                            }
                        }
                    }
                    dataLoad(this)
                }
            }
        }


    }

    override fun loadData(recyclerView: RecyclerView): List<Card> {
        count++
        return listOf(
            Card(1, "你好"),
            Card(2, "哈喽"),
            Card(3, "哈喽----666"),
            Card(4, "777----666"),
            Card(count,"--------${count}--line--${count}--------")
        )
    }


}

