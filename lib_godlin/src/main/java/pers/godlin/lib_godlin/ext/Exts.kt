package pers.godlin.lib_godlin.ext

import android.view.View
import android.view.ViewGroup

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */

/**
 * 添加到ViewGroup
 */
inline fun <reified T:View> T.addToViewGroup(viewGroup: ViewGroup):T {
    viewGroup.addView(this)
    return this
}