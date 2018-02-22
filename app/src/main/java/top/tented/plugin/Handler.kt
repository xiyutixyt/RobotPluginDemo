package top.tented.plugin

import com.saki.aidl.PluginMsg
import org.intellij.lang.annotations.Language
import java.util.regex.Matcher

/**
 * Handler
 * Created by hoshino on 18-2-18 下午6:29.
 */
abstract class Handler( val name : String , val version : String ) {
    class MessageHandler(@Language("RegExp") val regex : String, val `continue` : Boolean, val handle : PluginMsg.(Matcher) -> Unit)

    val handlerList = ArrayList<MessageHandler>()

    protected fun message(@Language("RegExp") regex : String, `continue` : Boolean = false, handle: PluginMsg.(Matcher) -> Unit) =
            handlerList.add(MessageHandler(regex, `continue`, handle))
}