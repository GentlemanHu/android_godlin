package pers.godlin.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import javax.inject.Inject

/**
 * @author: gentlemanhu
 * @date: 2022/5/19
 */
class MyPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create<MyExtension>("god")
        target.afterEvaluate {
            println("Hello From Extension ${extension.yyds}")
        }
    }
}