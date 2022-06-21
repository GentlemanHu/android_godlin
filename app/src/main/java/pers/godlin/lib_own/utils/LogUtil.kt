package pers.godlin.lib_own.utils

import com.elvishew.xlog.XLog

/**
 * (     (   ((      (   (    ((     .  (   ((    ((
 * )\    )\ (\()     )\  )\  (\()     . )\  ))\  (\()
 *((_)  ((())(_)    (_()((_)))(_)      ((_)((_))))(_)
 *\ \    / / __|    /   \ _ \ __|     / _ \| \| | __|
 * \ \/\/ /| _|     | - |   / _|     | (_) | .  | _|
 *  \_/\_/ |___|    |_|_|_|_\___|     \___/|_|\_|___|
 * Author: Gentleman.Hu
 * Date: 2022/6/12 9:35 下午
 * Email: justfeelingme@gamil.com
 * Home: https://crushing.xyz
 * Description:
 */

infix fun Any?.eLog(log: String) {
    XLog.e(log)
}
