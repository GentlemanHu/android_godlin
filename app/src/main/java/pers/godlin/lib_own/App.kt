package pers.godlin.lib_own

import android.app.Activity
import android.app.Application
import android.os.Bundle

import android.view.Gravity
import androidx.appcompat.app.AlertDialog

import androidx.fragment.app.FragmentActivity
import com.drake.brv.utils.BRV
import com.drake.debugkit.DevTool
import com.drake.debugkit.dev
import com.petterp.floatingx.FloatingX
import com.petterp.floatingx.assist.Direction


import pers.godlin.lib_godlin.base.BaseApp
import pers.godlin.lib_godlin.utils.MyActivityManager
import pers.godlin.lib_godlin.utils.initLogger
import splitties.init.injectAsAppCtx

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        BRV.modelId = BR.m

        initLogger()
        DevTool.enabled = true

        FloatingX.init {
            setLayout(R.layout.item_floating_view)
            setEnableAllBlackClass(true)
            setEnableLog(true)
            setEnableEdgeAdsorption(true)
            setEnableAssistDirection(0f, 100f, 0f, 0f)
            setGravity(Direction.RIGHT_OR_CENTER)
            setEnableTouch(true)
            setOnClickListener {
                (MyActivityManager.instance.currentActivity as? FragmentActivity)?.let {
//                    it.dev {
//                        function {
//                            longToast("哈哈哈")
//                        }
//                    }
                    val dialog = AlertDialog.Builder(it).create()

                }
            }
            enableFx()
        }

        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {
                MyActivityManager.instance.currentActivity = activity
            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {
            }
        })

    }
    companion object {
        val mApplication = this
    }
}