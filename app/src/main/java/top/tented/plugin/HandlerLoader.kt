package top.tented.plugin

import com.saki.aidl.PluginMsg
import top.tented.plugin.handler.Main
import top.tented.plugin.handler.Robo
import top.tented.utils.matches

/**
 * HandlerLoader
 * Created by hoshino on 18-2-18 下午6:28.
 */
object HandlerLoader {
    val handlerArray = arrayOf(
            Main,
            Robo
    )       //这里最好换行

    val handlerList = handlerArray.toList()

    fun load(msg : PluginMsg) {
        handlerList.forEach {
            it.handlerList.forEach {
                msg.msg.matches(it.regex)?.run {
                    msg.clearMsg()
                    it.handle(msg, this)
                    msg.send()
                    if(! it.`continue`) return
                }
            }
        }
    }
}