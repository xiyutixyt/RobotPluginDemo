package top.tented.util

import top.tented.file.Config

/**
 * Path
 * Created by hoshino on 18-2-25 下午8:37.
 */

val rootPath = android.os.Environment.getExternalStorageDirectory().toString() + "/matc/data/"

/**
 * 获取rootPath下的文件Config对象
 */
fun Config.Companion.extraConfig( extra : String ) = Config("$rootPath$extra.properties")

object GlobalConfig {
    operator fun get(key : String) = Config.extraConfig("config")[key]
}