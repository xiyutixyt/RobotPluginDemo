package top.tented.util

import com.saki.aidl.PluginMsg
import top.tented.file.Config

/**
 * Member
 * Created by hoshino on 18-2-25 上午4:47.
 */
class Member(val group : Group, val id : Long, val name : String?) {

    //群成员的金钱
    var money
        get() = group.moneyConfig[id.toString()]?.toLong() ?: 0L
        set(value) {
            group.moneyConfig[id.toString()] = value
        }

    //是否为机器人管理员
    var isMaster
        get() = group.masterConfig[id.toString()] == "true"
        set(value) {
            group.masterConfig.let {
                if (value) it[id.toString()] = value else it.remove(id.toString())      //如果是添加就赋值, 否则直接删除, 这里是为了Group的masters而这样写的
            }
        }

    fun sendWith(type : PluginMsg.Type, apply : PluginMsg.() -> Unit = {}) = group.sendWith(type) {
        uin = this@Member.id
        apply()
    }

    /**
     * 禁言
     * @param time 禁言时长(分钟)
     */
    fun shutUp(time : Int) = sendWith(PluginMsg.Type.MemberShutUp) { value = time * 60 }

    /**
     * 踢人
     */
    fun remove() = sendWith(PluginMsg.Type.RemoveMember)

    /**
     * 重命名
     * @param newName 新名字
     */
    fun rename(newName : String) = sendWith(PluginMsg.Type.Rename) { title = newName }

    /**
     * 点赞
     * @param times 点赞次数, 必须在1~10之间才有效
     */
    fun favourite(times : Int) = sendWith(PluginMsg.Type.Favourite) { if (times in 1..10) value = times }

    override fun equals(other : Any?) = (other as? Member)?.hashCode() == hashCode()
    override fun hashCode() = group.hashCode() * 31 + id.hashCode()
    override fun toString() = "$name($id)"
}