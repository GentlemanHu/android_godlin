package pers.godlin.lib_godlin.layouts

import android.content.Context
import android.view.ViewGroup

/**
 * @author: gentlemanhu
 * @date: 2022/5/5
 */

inline fun <reified T : ViewGroup> Context.layout(init: T.() -> Unit): T {
    return T::class.java.getConstructor(Context::class.java).newInstance(this).apply(init)
}