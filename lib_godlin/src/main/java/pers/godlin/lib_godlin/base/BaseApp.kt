package pers.godlin.lib_godlin.base

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.FragmentActivity
import com.drake.brv.utils.BRV
import com.drake.debugkit.DevTool
import com.drake.debugkit.dev
import com.drake.net.NetConfig
import com.petterp.floatingx.FloatingX
import com.petterp.floatingx.assist.Direction
import pers.godlin.lib_godlin.R
import pers.godlin.lib_godlin.utils.MyActivityManager
import splitties.toast.longToast

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */
open class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        DevTool.enabled = true

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
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
}