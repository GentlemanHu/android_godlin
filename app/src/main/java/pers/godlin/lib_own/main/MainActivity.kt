package pers.godlin.lib_own.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.drake.brv.utils.addModels
import com.drake.brv.utils.linear
import com.drake.brv.utils.models
import com.drake.brv.utils.setup
import com.drake.tooltip.toast

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pers.godlin.lib_godlin.ext.addToViewGroup
import pers.godlin.lib_godlin.ext.viewModel
import pers.godlin.lib_godlin.layouts.mLinearLayout
import pers.godlin.lib_godlin.views.layoutParams

import pers.godlin.lib_godlin.views.mView
import pers.godlin.lib_own.R
import pers.godlin.lib_own.base.BaseActivity
import pers.godlin.lib_own.databinding.ActivityMainBinding
import pers.godlin.lib_own.job.scheduleRepeatedly
import pers.godlin.lib_own.model.Card
import pers.godlin.lib_own.ui.HomeActivity
import splitties.activities.start
import splitties.coroutines.suspendLazy
import splitties.init.injectAsAppCtx

import splitties.views.dsl.recyclerview.recyclerView
import kotlin.random.Random
import kotlin.reflect.KProperty

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = mLinearLayout {
            mView<TextView> {
                text = "第一"
                layoutParams {
                    width = LinearLayout.LayoutParams.MATCH_PARENT
                    height = LinearLayout.LayoutParams.MATCH_PARENT
                }
            }

            mView<ImageView> {
                setImageResource(R.drawable.ic_launcher_background)
            }

            mView<LinearLayout> {
                orientation = LinearLayout.VERTICAL
                repeat(20) {
                    mView<TextView> {
                        text = "----"
                    }
                }
                mView<RecyclerView> {
                    linear()
                    setup {
                        addType<Card>(R.layout.item_card)
                        R.id.tvName.onClick {
                            toast("JJJJJ")
                            start<HomeActivity>()
                        }
                    }
                    models =
                        listOf(
                            Card(1, "你好"),
                            Card(2, "哈喽"),
                            Card(3, "哈喽----666"),
                            Card(4, "777----666")
                        )
                }
                recyclerView().apply {
                    linear()
                    setup {
                        addType<Card>(R.layout.item_card)
                    }
                    models =
                        listOf(
                            Card(1, "你好"),
                            Card(2, "哈喽"),
                            Card(3, "哈喽----666"),
                            Card(4, "777----666")
                        )
                }.addToViewGroup(this)
            }

            mView<LinearLayout> {
                orientation = LinearLayout.VERTICAL
                repeat(20) {
                    mView<TextView> {
                        text = "----"
                    }
                }
            }
        }


        val rv = recyclerView().apply {
            linear()
            setup {
                addType<Card>(R.layout.item_card)
            }
            models =
                listOf(Card(1, "你好"), Card(2, "哈喽"), Card(3, "哈喽----666"), Card(4, "777----666"))
        }

        container.apply {
            view.addToViewGroup(this)
            rv.addToViewGroup(this)
            rv.models = listOf(Card(1, "你好"), Card(2, "哈喽"))
        }


        lifecycleScope.launch {
            scheduleRepeatedly(1, 300) {
                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString())))
                logger.e("${Card(Random.nextInt(), Random.nextBytes(5).toString())}")
            }
//            container.addView(button { text = "" })
//            println("finish scheduler")
//            scheduleRepeatedly(Random.nextLong(500L, 2000L), 300) {
//                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString())))
//            }
        }


//        lifecycleScope.launch {
//            scheduleRepeatedly(Random.nextLong(500L, 2000L), 30) {
//                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString(Charsets.UTF_8))))
//            }
//            container.addView(button { text = "" })
//            println("finish scheduler")
//            scheduleRepeatedly(Random.nextLong(500L, 2000L), 300) {
//                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString(Charsets.UTF_8))))
//            }
//        }

    }

    override val vm by viewModel<MainActivityVM>()
}