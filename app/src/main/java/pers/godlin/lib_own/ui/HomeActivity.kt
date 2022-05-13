package pers.godlin.lib_own.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.drake.tooltip.dialog.BubbleDialog
import com.drake.tooltip.longToast
import pers.godlin.lib_godlin.ext.delayTimeRun
import pers.godlin.lib_godlin.ext.viewModel
import pers.godlin.lib_own.R
import pers.godlin.lib_own.base.BaseActivity
import pers.godlin.lib_own.base.BaseViewModel
import pers.godlin.lib_own.databinding.ActivityMainBinding

/**
 * @author: gentlemanhu
 * @date: 2022/3/11
 */
class HomeActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override val vm by viewModel<HomeActivityVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLoading()
        delayTimeRun(6000) {
            hideLoading()
        }
    }
}