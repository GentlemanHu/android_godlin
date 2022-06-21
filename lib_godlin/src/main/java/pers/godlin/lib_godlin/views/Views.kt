package pers.godlin.lib_godlin.views

import android.content.Context
import android.os.Build.VERSION_CODES.P
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import pers.godlin.lib_godlin.annotation.ViewDslMaker
import pers.godlin.lib_godlin.layouts.layout
import java.lang.reflect.Constructor

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
 * OnClick
 */
fun View.onClick(clickListener: () -> Unit) {
    this.setOnClickListener {
        clickListener()
    }
}


inline val <reified T : ViewGroup> T.groupParams
    get() = layoutParams

//
//context(VG) inline fun <reified T : View, reified VG : ViewGroup> T.mLayoutParams( receiver: VG.LayoutParams.() -> Unit) {
//    layoutParams = ViewGroup.LayoutParams(context,null).apply(receiver)
//}

context(LinearLayout)
inline fun <reified T : View> T.layoutParams(receiver: LinearLayout.LayoutParams.() -> Unit) {
    layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply(receiver)
}

context(RelativeLayout)
inline fun <reified T : View> T.layoutParams(receiver: RelativeLayout.LayoutParams.() -> Unit) {
    layoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    ).apply(receiver)
}

context(ConstraintLayout)
inline fun <reified T : View> T.layoutParams(receiver: ConstraintLayout.LayoutParams.() -> Unit) {
    layoutParams = ConstraintLayout.LayoutParams(
        ConstraintLayout.LayoutParams.WRAP_CONTENT,
        ConstraintLayout.LayoutParams.WRAP_CONTENT
    ).apply(receiver)
}


//inline fun <reified LT : ViewGroup.LayoutParams> ViewGroup.getTypedLayoutParams():LT {
//    return when (this::class.java) {
//        LinearLayout::class.java -> LinearLayout.LayoutParams(context, null)
//        else -> ViewGroup.LayoutParams(context, null)
//    }
//}

/**
 * 添加view
 *
 */
inline fun <reified T : View> ViewGroup.mView(init: (@ViewDslMaker T).() -> Unit) {
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
        else -> T::class.java.viewConstructor().newInstance(this.context)
    }
    view?.let {
        addView((it as T).apply(init))
    }
}

@Suppress("UNCHECKED_CAST")
fun <V : View> Class<V>.viewConstructor(): Constructor<V> {
    return cachedViewConstructors[this] as Constructor<V>?
        ?: getConstructor(Context::class.java).also { cachedViewConstructors[this] = it }
}

private val cachedViewConstructors by lazy(LazyThreadSafetyMode.PUBLICATION) {
    mutableMapOf<Class<out View>, Constructor<out View>>()
}
