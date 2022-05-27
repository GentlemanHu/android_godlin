package pers.godlin.lib_own.job

import kotlinx.coroutines.*
import pers.godlin.lib_own.App

/**
 * @author: gentlemanhu
 * @date: 2022/3/10
 */

/**
 * 周期循环执行
 */
suspend fun scheduleRepeatedly(
    delayTimeMillis: Long,
    counts: Int = 0,
    action: suspend CoroutineScope.() -> Unit
) = coroutineScope {
    if (counts != 0) {
        repeat(counts) {
            delay(delayTimeMillis)
            launch { action() }
        }
        cancel("结束")
    } else {
        while (true) {
            delay(delayTimeMillis)
            launch { action() }
        }
    }
}