package top.tented.util

import com.saki.aidl.PluginMsg

/**
 * Member
 * Created by hoshino on 18-2-25 上午4:47.
 */
class Member(val group : Group, val id : Long, val name : String?) {
    fun pluginMsg(apply : PluginMsg.() -> Unit) = PluginMsg().apply {
        group = this@Member.group.id
        uin = this@Member.id
        apply()
    }

    fun shutUp(time : Int) = pluginMsg {
        type = PluginMsg.Type.MemberShutUp
        value = time * 60
    }.send()

    fun remove() = pluginMsg {
        type = PluginMsg.Type.RemoveMember
    }.send()

    fun rename(newName : String) = pluginMsg {
        type = PluginMsg.Type.Rename
        title = newName
    }.send()

    fun favourite(times : Int) = pluginMsg {
        if (times in 1..10) {
            type = PluginMsg.Type.Favourite
            value = times
        }
    }.send()
}