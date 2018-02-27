package top.tented.util.auary

import android.os.Environment

import java.io.File

/**
 * Created by XYT on 2018/2/25.
 */

object file {
    fun getSD(path: String) = Environment.getExternalStorageDirectory()?.run {          //run: 把前面的对象作为this
        (toString() + path).apply {         //apply: 把前面的对象作为this, 然后返回这个对象
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
