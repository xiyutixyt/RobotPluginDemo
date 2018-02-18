package top.tented.plugin

import com.saki.aidl.PluginMsg
import top.tented.plugin.handler.Demo

/**
 * HandlerLoader
 * Created by hoshino on 18-2-18 下午6:28.
 */
object HandlerLoader {
    val handlerArray = arrayOf(
            Demo
    )

    val handlerList = handlerArray.toList()

    fun load(msg : PluginMsg) {
        handlerList.forEach {
            it.handlerList.forEach {
                if(msg.msg.matches(it.regex)) {
                    msg.clearMsg()
                    it.handle(msg)
                    msg.send()
                    if(! it.`continue`) return
                }
            }
        }
    }
}