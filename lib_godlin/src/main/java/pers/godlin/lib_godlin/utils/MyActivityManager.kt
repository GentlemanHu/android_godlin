package pers.godlin.lib_godlin.utils

import android.app.Activity
import pers.godlin.lib_godlin.utils.MyActivityManager
import java.lang.ref.WeakReference

/**
 * @author: gentlemanhu
 * @date: 2022/2/21
 */
class MyActivityManager private constructor() {
    private var sCurrentActivityWeakRef: WeakReference<Activity>? = null
    var currentActivity: Activity?
        get() {
            var currentActivity: Activity? = null
            if (sCurrentActivityWeakRef != null) {
                currentActivity = sCurrentActivityWeakRef!!.get()
            }
            return currentActivity
        }
        set(activity) {
            sCurrentActivityWeakRef = WeakReference(activity)
        }

    companion object {
        val instance = MyActivityManager()
    }
}