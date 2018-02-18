package top.tented.plugin

import com.saki.aidl.PluginMsg

/**
 * Handler
 * Created by hoshino on 18-2-18 下午6:29.
 */
open class Handler( val name : String , val version : String ) {
    class MessageHandler(val regex : Regex, val `continue` : Boolean, val handle : (PluginMsg) -> Unit)

    val handlerList = ArrayList<MessageHandler>()

    protected fun message(regex : Regex, `continue` : Boolean = false, handle: (PluginMsg) -> Unit) =
            handlerList.add(MessageHandler(regex, `continue`, handle))
}