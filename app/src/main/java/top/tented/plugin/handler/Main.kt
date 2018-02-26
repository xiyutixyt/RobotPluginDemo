package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler
import top.tented.util.GlobalConfig
import top.tented.utils.times

/**
 * Created by XYT on 2018/2/25.
 */
object Main : Handler("插件信息", "1.0") {
    //这些会在插件启动的时候就读取, 所以要修改需要重启插件
    val splitChar = GlobalConfig["splitChar"] ?: "-"        //分隔符
    val splitTimes = GlobalConfig["splitTimes"]?.toInt() ?: 10      //分割符的个数
    val splitLine = splitChar * splitTimes      //分割线

    init {
        message(name) {
            addMsg(PluginMsg.Key.Message, "本插件没有信息")
        }
    }
}