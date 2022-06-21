package pers.godlin.lib_own.ui.widget

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import pers.godlin.lib_own.utils.eLog

/**
 * (     (   ((      (   (    ((     .  (   ((    ((
 * )\    )\ (\()     )\  )\  (\()     . )\  ))\  (\()
 *((_)  ((())(_)    (_()((_)))(_)      ((_)((_))))(_)
 *\ \    / / __|    /   \ _ \ __|     / _ \| \| | __|
 * \ \/\/ /| _|     | - |   / _|     | (_) | .  | _|
 *  \_/\_/ |___|    |_|_|_|_\___|     \___/|_|\_|___|
 * Author: Gentleman.Hu
 * Date: 2022/6/12 8:31 下午
 * Email: justfeelingme@gamil.com
 * Home: https://crushing.xyz
 * Description:
 */
class MyView : View {
    constructor(context: Context) : super(context)
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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // Try for a width based on our minimum
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = View.resolveSizeAndState(minw, widthMeasureSpec, 1)

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        val minh: Int = View.MeasureSpec.getSize(w) - textWidth.toInt() + paddingBottom + paddingTop
        val h: Int = View.resolveSizeAndState(minh, heightMeasureSpec, 0)

        setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val data =

            canvas.apply {
                // Draw the shadow
                drawOval(RectF().also {
                    it.bottom = 10F
                    it.left = 10F
                    it.right = 10F
                    it.top = 10F
                }, shadowPaint)

                // Draw the label text
                drawText("nice", 10F, 10F, textPaint)

//            // Draw the pie slices
//            data.forEach {
//                piePaint.shader = it.mShader
//                drawArc(
//                    bounds,
//                    360 - it.endAngle,
//                    it.endAngle - it.startAngle,
//                    true, piePaint
//                )
//            }
//
//            // Draw the pointer
//            drawLine(textX, pointerY, pointerX, pointerY, textPaint)
//            drawCircle(pointerX, pointerY, pointerSize, mTextPaint)
            }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }


    private var textHeight: Float = 3F
    private var textWidth: Float = 5F
    private var showText = false
    private val textPaint = Paint(ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        if (textHeight == 0f) {
            textHeight = textSize
        } else {
            textSize = textHeight
        }
    }

    private val piePaint = Paint(ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textSize = textHeight
    }

    private val shadowPaint = Paint(0).apply {
        color = 0x101010
        maskFilter = BlurMaskFilter(8f, BlurMaskFilter.Blur.NORMAL)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // Account for padding
        var xpad = (paddingLeft + paddingRight).toFloat()
        val ypad = (paddingTop + paddingBottom).toFloat()

// Account for the label
        if (showText) xpad += textWidth

        val ww = w.toFloat() - xpad
        val hh = h.toFloat() - ypad

// Figure out how big we can make the pie.
        val diameter = Math.min(ww, hh)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this eLog "MyView ----- onTouchEvent $event"
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        this eLog "MyView ----- dispatchTouchEvent $event"
        return super.dispatchTouchEvent(event)
    }
}