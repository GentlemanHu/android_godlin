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
fun Context.MLinearLayout(
    mOrientation: Int = LinearLayout.HORIZONTAL,
    init: LinearLayout.() -> Unit
): LinearLayout {
    return LinearLayout(this).apply {
        orientation = mOrientation
        init()
    }
}