package top.tented.plugin.auary

import android.os.Environment

import java.io.File

/**
 * Created by XYT on 2018/2/25.
 */

object file {
    fun getSD(path: String) = Environment.getExternalStorageDirectory()?.run {
        (toString() + path).apply {
            File(this).takeIf { ! it.exists() }?.parentFile?.mkdirs()
        }
    }
//        val file = Environment.getExternalStorageDirectory()
//        if (file != null) {
//            val sdpath = file.toString() + path
//            val file2 = File(sdpath)
//            if (!file2.exists()) {
//                file2.parentFile.mkdirs()
//            }
//
//            return sdpath
//        }
//        return null
//    }
}
