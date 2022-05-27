package pers.godlin.lib_own.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * (     (   ((      (   (    ((     .  (   ((    ((
 * )\    )\ (\()     )\  )\  (\()     . )\  ))\  (\()
 *((_)  ((())(_)    (_()((_)))(_)      ((_)((_))))(_)
 *\ \    / / __|    /   \ _ \ __|     / _ \| \| | __|
 * \ \/\/ /| _|     | - |   / _|     | (_) | .  | _|
 *  \_/\_/ |___|    |_|_|_|_\___|     \___/|_|\_|___|
 * Author: Gentleman.Hu
 * Date: 2022/3/25 10:50 下午
 * Email: justfeelingme@gamil.com
 * Home: https://crushing.xyz
 * Description:
 */
open class BaseViewModel :ViewModel() {
    val loading by lazy{ MutableLiveData<Boolean>() }


}