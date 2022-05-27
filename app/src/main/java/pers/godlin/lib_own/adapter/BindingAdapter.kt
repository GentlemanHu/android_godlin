package pers.godlin.lib_own.adapter

import android.graphics.Color
import android.text.SpannableString
import android.text.style.DrawableMarginSpan
import android.text.style.URLSpan
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.BindingAdapter
import com.drake.spannable.addSpan
import com.drake.spannable.replaceSpan
import com.drake.spannable.setSpan
import com.drake.spannable.span.HighlightSpan
import pers.godlin.lib_own.R

/**
 * @author: gentlemanhu
 * @date: 2022/3/25
 */
object BindingAdapter {

    @BindingAdapter("tvTextSpannable")
    @JvmStatic
    fun TextView.tvSpannable(text: String) {
        this.text = text
            .replaceSpan("1") {
                URLSpan("https://www.baidu.com").apply {

                }
            }
            .replaceSpan("6") {
                HighlightSpan(Color.YELLOW)
            }
            .replaceSpan("line"){
                HighlightSpan(Color.RED)
            }
            .addSpan(SpannableString("").setSpan(DrawableMarginSpan(R.drawable.close.toDrawable())))
    }
}