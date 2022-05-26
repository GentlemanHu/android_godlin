package pers.godlin.lib_godlin.layouts

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * @author: gentlemanhu
 * @date: 2022/5/5
 */
inline fun Context.mConstraintLayout(init: ConstraintLayout.() -> Unit): ConstraintLayout {
    return ConstraintLayout(this).apply(init)
}