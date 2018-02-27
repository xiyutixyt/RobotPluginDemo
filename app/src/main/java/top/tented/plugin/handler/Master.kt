package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler

/**
 * Master
 * Created by hoshino on 18-2-26 下午4:43.
 */
object Master : Handler("主人系统", "1.0") {
    val menu =      //到时候要转卡片的话就分割Main.splitLine, 然后填入xml里
            """
                |$name
                |${Main.splitLine}
                |添加主人@
                |删除主人@
                |${Main.splitLine}
                |你%s是主人
            """.trimMargin()

    init {
        message(name) {
            addMsg(PluginMsg.Key.Message, menu.format(if(member.isMaster) "" else "不"))
        }

        message("主人列表") {
            addMsg(
                    PluginMsg.Key.Message,
                    member.group.masters.joinToString("\n") { it.id.toString() }
                    //joinToString: 把一个集合/数组转化为字符串
                    //separator: 分隔符
                    //prefix/postfix: 前缀和后缀
                    //limit: 最多的元素个数(默认为-1, -1是无限制)
                    //truncated: 多余元素的表示方式(一般只有在limit大于0的时候使用
                    //transform: lambda表达式, 传入一个对象, 返回一个字符串
            )
        }

        message("(添加|删除)主人@.*") {
            member.takeIf { it.isMaster }?.let { _ ->                 //takeIf: 当lambda表达式返回值为true时返回member, 否则返回null
                (it.group(1) == "添加").let { mod ->          //let: 把前面的对象作为lambda表达式的参数, 例如这里的mod指的就是it.group(1) == "添加", 不过这里的let很没有必要
                    ats.firstOrNull()?.isMaster = mod           //?. 如果前面的对象是null则返回null而不调用, 否则继续调用
                    addMsg(PluginMsg.Key.Message, "${it.group(1)}完成")
                }
            } ?: addMsg(PluginMsg.Key.Message, "很抱歉, 您没有权利执行这个操作")      // ?: 当前面的对象为null时返回后面的一个表达式的返回值, 否则返回前面的对象
        }
    }
}