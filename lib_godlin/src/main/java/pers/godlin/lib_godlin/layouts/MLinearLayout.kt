package pers.godlin.lib_godlin.layouts

import android.content.Context
import android.widget.LinearLayout

/**
 * @author: gentlemanhu
 * @date: 2022/3/9
 */
/**
 * 返回线性布局
 */
inline fun Context.mLinearLayout(
    mOrientation: Int = LinearLayout.HORIZONTAL,
    init: LinearLayout.() -> Unit
): LinearLayout {
    return LinearLayout(this).apply {
        orientation = mOrientation
        init()
    }
}