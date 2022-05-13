package pers.godlin.lib_own.main

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.drake.brv.utils.addModels
import com.drake.brv.utils.linear
import com.drake.brv.utils.models
import com.drake.brv.utils.setup
import kotlinx.coroutines.launch
import me.zhanghai.android.fastscroll.FastScrollerBuilder
import pers.godlin.lib_godlin.ext.addToViewGroup
import pers.godlin.lib_godlin.ext.delayTimeRun
import pers.godlin.lib_godlin.ext.viewModel
import pers.godlin.lib_godlin.layouts.MLinearLayout
import pers.godlin.lib_godlin.views.MView
import pers.godlin.lib_own.R
import pers.godlin.lib_own.base.BaseActivity
import pers.godlin.lib_own.base.BaseViewModel
import pers.godlin.lib_own.databinding.ActivityMainBinding
import pers.godlin.lib_own.job.scheduleRepeatedly
import pers.godlin.lib_own.model.Card
import pers.godlin.lib_own.ui.HomeActivity
import pers.hu.nativelib.NativeLib
import splitties.activities.start
import splitties.bundle.BundleSpec
import splitties.bundle.withExtras
import splitties.views.dsl.core.button
import splitties.views.dsl.recyclerview.recyclerView
import kotlin.random.Random

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = MLinearLayout {
            MView<TextView> {
                val start = System.currentTimeMillis()
                val jniStr = NativeLib.stringFromJNI()
                val usedTime = System.currentTimeMillis() - start
                text = "$jniStr -- usedTime $usedTime"
            }

            MView<TextView> {
                val start = System.currentTimeMillis()
                val jniStr = "Hello Kotlin String"
                val usedTime = System.currentTimeMillis() - start
                text = "$jniStr --- used Time $usedTime"
            }
            MView<ImageView> {
                setImageResource(R.drawable.ic_launcher_background)
            }
        }

        val rv = recyclerView().apply {
            linear()
            setup {
                addType<Card>(R.layout.item_card)
                R.id.tvName.onClick {
                    start<HomeActivity>()
                }
            }
        }

        val container = findViewById<LinearLayout>(R.id.container).apply {
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

        delayTimeRun(10000) {
            rv.adapter?.itemCount?.let {
                rv.smoothScrollToPosition(it)
            }
        }
    }

    override val vm by viewModel<MainActivityVM>()
}