package top.tented.plugin.handler

import com.saki.aidl.Type
import top.tented.plugin.Handler

/**
 * Demo
 * Created by hoshino on 18-2-18 下午6:42.
 */
object Demo : Handler("插件测试", "Test") {
    init {      //必须在init块内执行
        //新建一个消息处理器
        //消息处理器的默认continue值为false, 也就是说如果这一条消息为 测试, 则永远进不到下面的那个判断里, 也包括在这个Handler之后的其他Handler
        //所以需要continue的Handler记得放在不可continue的Handler之前
        message(Regex("测试")) {
            it.addMsg(Type.MSG, "测试成功")
        }

        message(Regex(".*")) {
            it.addMsg(Type.MSG, "这条消息永远不可能是`测试`")
        }
    }
}