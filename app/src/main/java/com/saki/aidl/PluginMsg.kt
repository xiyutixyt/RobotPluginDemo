package com.saki.aidl

import java.util.ArrayList
import java.util.HashMap

import android.os.Parcel
import android.os.Parcelable
import android.os.RemoteException
import saki.demo.Demo

class PluginMsg : Parcelable {
    enum class Key(val key : String) {
        Message("msg"),
        Xml("xml"),
        Json("json"),
        At("at"),
        Image("img")
    }

    enum class Type(val type : Int) {
        Data(-1),
        Group(0),
        Friend(1),
        Discussion(2),
        System(3),
        Temp(4),
        GroupList(5),
        GroupInfo(6),
        GroupMember(7),
        Favourite(8),
        MemberCard(9),
        MemberShutUp(10),
        GroupShutUp(11),
        RemoveMember(12),
        AgreeJoin(13),
        MemberInfo(14),
        RobotAccount(15),
        MemberExited(16),
        AdminChange(17),
        Reload(18)
    }

    companion object {
        //必须提供一个名为CREATOR的static final属性 该属性需要实现android.os.Parcelable.Creator<T>接口
        //这个对象必须被@JvmField注解
        @JvmField val CREATOR : Parcelable.Creator<PluginMsg> = object : Parcelable.Creator<PluginMsg> {
            override fun createFromParcel(source : Parcel) : PluginMsg = PluginMsg(source)
            override fun newArray(size : Int) : Array<PluginMsg?> = arrayOfNulls(size)
        }

        const val TYPE_DATA = -1 //日志消息
        const val TYPE_GROUP_MSG = 0 //群消息
        const val TYPE_BYDDY_MSG = 1 //好友消息
        const val TYPE_DIS_MSG = 2 //讨论组消息
        const val TYPE_SYS_MSG = 3 //系统消息
        const val TYPE_SESS_MSG = 4 //临时消息
        const val TYPE_GET_GROUP_LIST = 5 //群列表
        const val TYPE_GET_GROUP_INFO = 6 //群信息
        const val TYPE_GET_GROUP_MEBMER = 7 //群成员
        const val TYPE_FAVORITE = 8 //点赞
        const val TYPE_SET_MEMBER_CARD = 9 //设置群名片
        const val TYPE_SET_MEMBER_SHUTUP = 10 //成员禁言
        const val TYPE_SET_GROUP_SHUTUP = 11 //群禁言
        const val TYPE_DELETE_MEMBER = 12 //删除群成员
        const val TYPE_AGREE_JOIN = 13 //同意入群
        const val TYPE_GET_MEMBER_INFO = 14 //成员信息
        const val TYPE_GET_LOGIN_ACCOUNT = 15 //获取机器人QQ
        const val TYPE_MEMBER_DELETE = 16 // 退群
        const val TYPE_ADMIN_CHANGE = 17 // 管理员变更
        const val TYPE_STOP = 18 //插件停止（重载）
    }

    @JvmField var type : Type = Type.Group
    @JvmField var group : Long = 0
    @JvmField var code : Long = 0
    @JvmField var uin : Long = 0
    @JvmField var time : Long = 0
    @JvmField var value : Int = 0
    @JvmField var groupName : String? = null
    @JvmField var uinName : String? = null
    @JvmField var title : String? = null

    var groupid : Long
        get() = group
        set(value) { group = value }
    var data = HashMap<String, ArrayList<String>>()
    val textMsg : String get() = buildString { data["msg"]?.forEach { append(it) } }
    lateinit var msg : String

    constructor()
    constructor(source : Parcel) {
        readFromParcel(source)
    }

    override fun describeContents() : Int = 0

    fun clearMsg() {
        data = HashMap()
    }

    fun addMsg(key : Key, msg : String) =
        (data["index"] ?: ArrayList<String>().apply { data["index"] = this }).run {
            add(key.key)
            (data["key"] ?: ArrayList<String>().apply { data[key.key] = this }).run { add(msg) }
        }

    @Throws(RemoteException::class)
    fun send() = Demo.connection?.takeIf { it.service != null }?.run { service?.handlerMessage(this@PluginMsg) }


    override fun writeToParcel(dest : Parcel, flags : Int) {
        dest.writeInt(type.type)
        dest.writeLong(groupid)
        dest.writeLong(code)
        dest.writeLong(uin)
        dest.writeLong(time)
        dest.writeInt(value)
        dest.writeString(groupName)
        dest.writeString(uinName)
        dest.writeString(title)
        dest.writeMap(data)
    }

    private fun readFromParcel(source : Parcel) {
        type = Type.values()[source.readInt() + 1]      //This array starts from -1
        groupid = source.readLong()
        code = source.readLong()
        uin = source.readLong()
        time = source.readLong()
        value = source.readInt()
        groupName = source.readString()
        uinName = source.readString()
        title = source.readString()
        source.readMap(data, javaClass.classLoader)

        msg = textMsg
    }
}
