package pers.hu.lib_ksp

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

/**
 * (     (   ((      (   (    ((     .  (   ((    ((
 * )\    )\ (\()     )\  )\  (\()     . )\  ))\  (\()
 *((_)  ((())(_)    (_()((_)))(_)      ((_)((_))))(_)
 *\ \    / / __|    /   \ _ \ __|     / _ \| \| | __|
 * \ \/\/ /| _|     | - |   / _|     | (_) | .  | _|
 *  \_/\_/ |___|    |_|_|_|_\___|     \___/|_|\_|___|
 * Author: Gentleman.Hu
 * Date: 2022/6/21 11:45 下午
 * Email: justfeelingme@gamil.com
 * Home: https://crushing.xyz
 * Description:
 */
class NiceProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return NiceProcessor(environment.codeGenerator, environment.logger, environment.options)
    }
}