package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler

/**
 * Master
 * Created by hoshino on 18-2-26 下午4:43.
 */
object Master : Handler("主人系统", "1.0") {
    val menu =
            """
                |$name
                |添加主人@
                |删除主人@
                |你%s是主人
            """.trimMargin()

    init {
        message(name) {
            addMsg(PluginMsg.Key.Message, menu.format(if(member.isMaster) "" else "不"))
        }

        message("(添加|删除)主人@.*") {
            member.takeIf { it.isMaster }?.let { member ->      //takeIf: 当lambda表达式返回值为true时返回member, 否则返回null
                (it.group(1) == "添加").let { mod ->
                    ats.firstOrNull()?.isMaster = mod
                    addMsg(PluginMsg.Key.Message, "操作完成")
                }
            } ?: addMsg(PluginMsg.Key.Message, "很抱歉, 您没有权利执行这个操作")
        }
    }
}