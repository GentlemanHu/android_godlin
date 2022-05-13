package pers.godlin.lib_own

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drake.brv.utils.linear
import com.drake.brv.utils.models
import com.drake.brv.utils.setup
import com.drake.tooltip.toast
import pers.godlin.lib_godlin.ext.addToViewGroup
import pers.godlin.lib_godlin.layouts.mLinearLayout
import pers.godlin.lib_godlin.views.mView
import pers.godlin.lib_own.base.BaseActivity
import pers.godlin.lib_own.databinding.ActivityMainBinding
import pers.godlin.lib_own.model.Card
import pers.godlin.lib_own.ui.HomeActivity
import splitties.activities.start

import splitties.views.dsl.recyclerview.recyclerView

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
                        listOf(Card(1, "你好"), Card(2, "哈喽"), Card(3, "哈喽----666"), Card(4, "777----666"))
                }
                recyclerView().apply {
                    linear()
                    setup {
                        addType<Card>(R.layout.item_card)
                    }
                    models =
                        listOf(Card(1, "你好"), Card(2, "哈喽"), Card(3, "哈喽----666"), Card(4, "777----666"))
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
}