package pers.godlin.lib_own.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import pers.godlin.lib_own.utils.eLog

/**
 * (     (   ((      (   (    ((     .  (   ((    ((
 * )\    )\ (\()     )\  )\  (\()     . )\  ))\  (\()
 *((_)  ((())(_)    (_()((_)))(_)      ((_)((_))))(_)
 *\ \    / / __|    /   \ _ \ __|     / _ \| \| | __|
 * \ \/\/ /| _|     | - |   / _|     | (_) | .  | _|
 *  \_/\_/ |___|    |_|_|_|_\___|     \___/|_|\_|___|
 * Author: Gentleman.Hu
 * Date: 2022/6/12 9:30 下午
 * Email: justfeelingme@gamil.com
 * Home: https://crushing.xyz
 * Description:
 */
class MyLinearLayout : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        this eLog "MyLinearLayout ----- onTouchEvent $event"
        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        this eLog "onInterceptTouchEvent ----- onTouchEvent $ev"
        return super.onInterceptTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        this eLog "MyLinearLayout ----- dispatchTouchEvent $ev"
        return super.dispatchTouchEvent(ev)
    }
}