package top.tented.util

import com.saki.aidl.PluginMsg
import top.tented.utils.toInt

/**
 * Group
 * Created by hoshino on 18-2-25 上午4:48.
 */
class Group(val id : Long) {
    val members get() = pluginMsg { type = PluginMsg.Type.GroupMember }.send()?.data?.get(PluginMsg.Key.Member.key)

    fun pluginMsg(apply : PluginMsg.() -> Unit) = PluginMsg().apply {
        group = this@Group.id
        apply()
    }

    /**
     * True -> shut up
     * False -> release
     */
    fun shutUp(mod : Boolean) = pluginMsg {
        type = PluginMsg.Type.GroupShutUp
        value = (!mod).toInt()
    }.send()
}