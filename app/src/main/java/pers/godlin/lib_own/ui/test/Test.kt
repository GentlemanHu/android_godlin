package pers.godlin.lib_own.ui.test

import android.os.Handler
import android.os.Looper
import android.os.Message

/**
 * @author: gentlemanhu
 * @date: 2022/5/19
 */
object Test : Thread() {
    private val mHandler: MHandler by lazy { MHandler() }

    override fun run() {
        Looper.prepare()
        Looper.loop()
    }

    class MHandler() : Handler() {
        override fun handleMessage(msg: Message) {
           when(msg.what){

           }
        }
    }
}