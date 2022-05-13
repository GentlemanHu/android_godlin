package pers.godlin.lib_own.base

import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import com.drake.debugkit.dev
import com.drake.engine.base.EngineSwipeActivity
import com.drake.engine.base.EngineToolbarActivity
import com.drake.engine.keyboard.hideKeyboard
import com.drake.statusbar.immersive
import com.drake.statusbar.setActionBarBackgroundRes
import com.drake.statusbar.setFullscreen
import com.drake.tooltip.dialog.BubbleDialog
import com.elvishew.xlog.Logger
import com.elvishew.xlog.XLog

/**
 * @author: gentlemanhu
 * @date: 2022/3/11
 */
abstract class BaseActivity<BV : ViewDataBinding>(@LayoutRes protected val layoutId: Int) :
    EngineSwipeActivity<BV>(layoutId) {
    protected val loadingView by lazy { BubbleDialog(this, "加载中...") }

    protected abstract val vm: BaseViewModel

    protected val logger: Logger by lazy { XLog.tag(this.javaClass.simpleName).build() }

    override fun initData() {

    }

    override fun initView() {
        immersive()
        setFullscreen()

        vm.loading.observeForever {
            when (it) {
                true -> loadingView.show()
                false -> loadingView.dismiss()
            }
        }
    }

    protected fun showLoading() {
        vm.loading.value = true
    }

    protected fun hideLoading() {
        vm.loading.value = false
    }
}