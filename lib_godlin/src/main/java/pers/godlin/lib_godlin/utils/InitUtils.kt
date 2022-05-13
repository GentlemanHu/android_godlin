package pers.godlin.lib_godlin.utils

import android.content.Context
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
import com.elvishew.xlog.interceptor.BlacklistTagsFilterInterceptor
import com.elvishew.xlog.printer.AndroidPrinter
import com.elvishew.xlog.printer.ConsolePrinter


/**
 * (     (   ((      (   (    ((     .  (   ((    ((
 * )\    )\ (\()     )\  )\  (\()     . )\  ))\  (\()
 *((_)  ((())(_)    (_()((_)))(_)      ((_)((_))))(_)
 *\ \    / / __|    /   \ _ \ __|     / _ \| \| | __|
 * \ \/\/ /| _|     | - |   / _|     | (_) | .  | _|
 *  \_/\_/ |___|    |_|_|_|_\___|     \___/|_|\_|___|
 * Author: Gentleman.Hu
 * Date: 2022/4/9 11:27 下午
 * Email: justfeelingme@gamil.com
 * Home: https://crushing.xyz
 * Description:
 */

/**
 * @param level
 * @see LogLevel
 */
fun Context.initLogger(
    level: Int = LogLevel.ALL, config: LogConfiguration = LogConfiguration.Builder()
//    .logLevel(
//        if (BuildConfig.DEBUG) LogLevel.ALL // 指定日志级别，低于该级别的日志将不会被打印，默认为 LogLevel.ALL
//        else LogLevel.NONE
//    )
        .tag("GOD_LIN_LOGGER") // 指定 TAG，默认为 "X-LOG"
        .enableThreadInfo() // 允许打印线程信息，默认禁止
        .enableStackTrace(2) // 允许打印深度为 2 的调用栈信息，默认禁止
        .enableBorder() // 允许打印日志边框，默认禁止
//    .jsonFormatter(MyJsonFormatter()) // 指定 JSON 格式化器，默认为 DefaultJsonFormatter
//    .xmlFormatter(MyXmlFormatter()) // 指定 XML 格式化器，默认为 DefaultXmlFormatter
//    .throwableFormatter(MyThrowableFormatter()) // 指定可抛出异常格式化器，默认为 DefaultThrowableFormatter
//    .threadFormatter(MyThreadFormatter()) // 指定线程信息格式化器，默认为 DefaultThreadFormatter
//    .stackTraceFormatter(MyStackTraceFormatter()) // 指定调用栈信息格式化器，默认为 DefaultStackTraceFormatter
//    .borderFormatter(MyBoardFormatter()) // 指定边框格式化器，默认为 DefaultBorderFormatter
//    .addObjectFormatter(
//        Object::class.java,  // 为指定类型添加对象格式化器
//    ) // 默认使用 Object.toString()
        .addInterceptor(
            BlacklistTagsFilterInterceptor( // 添加黑名单 TAG 过滤器
                "blacklist1", "blacklist2", "blacklist3"
            )
        )
//    .addInterceptor(MyInterceptor()) // 添加一个日志拦截器
        .build()
) {
    XLog.init(level, config)
}