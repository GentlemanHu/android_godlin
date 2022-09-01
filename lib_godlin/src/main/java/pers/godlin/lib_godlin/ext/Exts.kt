package pers.godlin.lib_godlin.ext

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import com.drake.net.log.LogRecorder
import pers.godlin.lib_godlin.R

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */

/**
 * 添加到ViewGroup
 */
inline fun <reified T : View> T.addToViewGroup(viewGroup: ViewGroup): T {
    viewGroup.addView(this)
    return this
}


/**
 * 延迟执行
 */
inline fun delayTimeRun(delay: Long = 500L, crossinline action: () -> Unit = {}) {
    Handler(Looper.getMainLooper()).postDelayed({
        try {
            action()
        } catch (e: Exception) {
            Log.e("延迟执行", "delayTimeRun: ${e.stackTrace}")
        }
    }, delay)
}

inline fun <reified R:ViewGroup.LayoutParams> ViewGroup.LayoutParams.asSpecificLayoutParams():R{
    return this as R
}