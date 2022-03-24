package pers.godlin.lib_own.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.drake.debugkit.dev
import com.drake.engine.base.EngineSwipeActivity
import com.drake.engine.base.EngineToolbarActivity
import com.drake.engine.keyboard.hideKeyboard
import com.drake.statusbar.immersive
import com.drake.statusbar.setActionBarBackgroundRes
import com.drake.statusbar.setFullscreen

/**
 * @author: gentlemanhu
 * @date: 2022/3/11
 */
abstract class BaseActivity<BV : ViewDataBinding>(@LayoutRes protected val layoutId: Int) :
    EngineSwipeActivity<BV>(layoutId) {
    override fun initData() {

    }

    override fun initView() {
        immersive()
        setFullscreen()
    }
}