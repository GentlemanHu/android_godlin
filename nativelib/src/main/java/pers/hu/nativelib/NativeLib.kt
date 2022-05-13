package pers.hu.nativelib

object NativeLib {
    init {
        System.loadLibrary("nativelib")
    }
    /**
     * A native method that is implemented by the 'nativelib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
}