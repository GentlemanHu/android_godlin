package pers.godlin.lib_own

import androidx.appcompat.app.AppCompatActivity
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
import pers.godlin.lib_godlin.ext.addToViewGroup
import pers.godlin.lib_godlin.layouts.MLinearLayout
import pers.godlin.lib_godlin.views.MView
import pers.godlin.lib_own.job.scheduleRepeatedly
import pers.godlin.lib_own.model.Card
import pers.godlin.lib_own.ui.HomeActivity
import splitties.activities.start
import splitties.views.dsl.core.button
import splitties.views.dsl.recyclerview.recyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = MLinearLayout {
            MView<TextView> {
                text = "第一"
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
            scheduleRepeatedly(Random.nextLong(500L, 2000L), 30) {
                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString())))
            }
            container.addView(button { text = "" })
            println("finish scheduler")
            scheduleRepeatedly(Random.nextLong(500L, 2000L), 300) {
                rv.addModels(listOf(Card(Random.nextInt(), Random.nextBytes(5).toString())))
            }
        }
    }
}