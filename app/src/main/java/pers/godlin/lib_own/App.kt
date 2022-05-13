package pers.godlin.lib_own

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.drake.brv.utils.BRV
import com.drake.debugkit.DevTool
import com.drake.debugkit.dev
import com.petterp.floatingx.FloatingX
import com.petterp.floatingx.assist.Direction
import pers.godlin.lib_godlin.base.BaseApp
import pers.godlin.lib_godlin.utils.MyActivityManager
import pers.godlin.lib_godlin.utils.initLogger
import splitties.init.injectAsAppCtx
import splitties.toast.longToast

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */
class App : BaseApp(){
    override fun onCreate() {
        super.onCreate()
        BRV.modelId = BR.m
        initLogger()
    }

    companion object {
        val mApplication = this
    }
}