package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler

/**
 * Created by XYT on 2018/2/25.
 */
object Main : Handler("插件信息", "1.0") {
    init {
        message(name) {
            addMsg(PluginMsg.Key.Message, "本插件没有信息")
        }
    }
}