package pers.godlin.lib_godlin.views

import android.view.View
import android.view.ViewGroup
import android.widget.*
import pers.godlin.lib_godlin.annotation.ViewDslMaker

/**
 * @author: gentlemanhu
 * @date: 2022/3/9
 */


/**
 * ImageView
 */
fun ViewGroup.MImageView(init: (@ViewDslMaker ImageView).() -> Unit) {
    addView(ImageView(context).apply(init))
}


/**
 * 添加view
 * TODO: null处理
 */
inline fun <reified T : View> ViewGroup.MView(init: (@ViewDslMaker T).() -> Unit) {
    val view = when (T::class.java) {
        TextView::class.java -> TextView(context)
        Button::class.java -> Button(context)
        ImageView::class.java -> ImageView(context)
        EditText::class.java -> EditText(context)
        Spinner::class.java -> Spinner(context)
        ImageButton::class.java -> ImageButton(context)
        CheckBox::class.java -> CheckBox(context)
        RadioButton::class.java -> RadioButton(context)
        CheckedTextView::class.java -> CheckedTextView(context)
        AutoCompleteTextView::class.java -> AutoCompleteTextView(context)
        MultiAutoCompleteTextView::class.java -> MultiAutoCompleteTextView(context)
        RatingBar::class.java -> RatingBar(context)
        SeekBar::class.java -> SeekBar(context)
        else -> null
    }
    view?.let {
        addView((it as T).apply(init))
    }
}
