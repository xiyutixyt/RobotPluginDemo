package top.tented.util

import com.saki.aidl.PluginMsg
import top.tented.utils.toInt

/**
 * Group
 * Created by hoshino on 18-2-25 上午4:48.
 */
class Group(val id : Long) {
    val members get() = sendWith(PluginMsg.Type.GroupMember)?.data?.get(PluginMsg.Key.Member.key)
    val groups get() = sendWith(PluginMsg.Type.GroupList)?.data?.get(PluginMsg.Key.Group.key)

    fun sendWith(type : PluginMsg.Type, apply : PluginMsg.() -> Unit = {}) = PluginMsg(type).apply { group = this@Group.id }.apply(apply).send()

    /**
     * True -> shut up
     * False -> release
     */
    fun shutUp(mod : Boolean) = sendWith(PluginMsg.Type.GroupShutUp) { value = (!mod).toInt() }

    override fun equals(other : Any?) = (other as? Group)?.hashCode() == hashCode()
    override fun hashCode() = id.hashCode()
    override fun toString() = id.toString()
}