package pers.godlin.lib_own.adapter

import android.graphics.Color
import android.text.SpannableString
import android.text.style.*
import android.widget.TextView
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.drake.spannable.addSpan
import com.drake.spannable.replaceSpan
import com.drake.spannable.setSpan
import com.drake.spannable.span.CenterImageSpan
import com.drake.spannable.span.ColorSpan
import com.drake.spannable.span.HighlightSpan
import pers.godlin.lib_own.R
import pers.godlin.lib_own.ui.OnMyRecyclerViewItemClick
import splitties.resources.color

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