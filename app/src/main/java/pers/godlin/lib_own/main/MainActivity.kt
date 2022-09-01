package pers.godlin.lib_own.main

import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.drake.brv.utils.addModels
import com.drake.brv.utils.linear
import com.drake.brv.utils.models
import com.drake.brv.utils.setup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pers.godlin.lib_godlin.ext.addToViewGroup
import pers.godlin.lib_godlin.ext.asSpecificLayoutParams
import pers.godlin.lib_godlin.ext.viewModel
import pers.godlin.lib_godlin.layouts.mLinearLayout
import pers.godlin.lib_godlin.views.mView
import pers.godlin.lib_own.R
import pers.godlin.lib_own.base.BaseActivity
import pers.godlin.lib_own.databinding.ActivityMainBinding
import pers.godlin.lib_own.job.scheduleRepeatedly
import pers.godlin.lib_own.model.Card
import pers.godlin.lib_own.ui.widget.MyView
import pers.godlin.lib_own.utils.eLog
import splitties.views.dsl.recyclerview.recyclerView
import java.util.*
import kotlin.random.Random

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = mLinearLayout {
            mView<TextView> {
                text = "第一"
            }
            mView<ImageView> {
                setImageResource(R.drawable.ic_launcher_background)
            }

            MyView(this@MainActivity).addToViewGroup(this)
//
//            mView<LinearLayout> {
//                orientation = LinearLayout.VERTICAL
//                repeat(20) {
//                    mView<TextView> {
//                        text = "----"
//                    }
//                }
//                mView<RecyclerView> {
//                    linear()
//                    setup {
//                        addType<Card>(R.layout.item_card)
//                        R.id.tvName.onClick {
//                            toast("JJJJJ")
//                            start<HomeActivity>()
//                        }
//                    }
//                    models =
//                        listOf(
//                            Card(1, "你好"),
//                            Card(2, "哈喽"),
//                            Card(3, "哈喽----666"),
//                            Card(4, "777----666")
//                        )
//                }
//                recyclerView().apply {
//                    linear()
//                    setup {
//                        addType<Card>(R.layout.item_card)
//                    }
//                    models =
//                        listOf(
//                            Card(1, "你好"),
//                            Card(2, "哈喽"),
//                            Card(3, "哈喽----666"),
//                            Card(4, "777----666")
//                        )
//                }.addToViewGroup(this)
//            }
//
//            mView<LinearLayout> {
//                orientation = LinearLayout.VERTICAL
//                repeat(20) {
//                    mView<TextView> {
//                        text = "----"
//                    }
//                }
//            }
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
            val nice = withContext(Dispatchers.IO) {

            }
//            container.addView(button { text = "" })
//            println("finish scheduler")
//            scheduleRepeatedly(Random.nextLong(500L, 2000L), 300) {
//                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString())))
//            }
            val p =
                binding.container.layoutParams.asSpecificLayoutParams<LinearLayout.LayoutParams>()

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

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        this eLog "MainActivity ----- MainActivityOnTouchEvent $event"
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        this eLog "MainActivity ----- MainActivityOnTouchEvent $event"
        return super.onTouchEvent(event)
    }
}