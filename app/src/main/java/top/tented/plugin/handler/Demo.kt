package top.tented.plugin.handler

import com.saki.aidl.Type
import top.tented.plugin.Handler

/**
 * Demo
 * Created by hoshino on 18-2-18 下午6:42.
 */
object Demo : Handler("插件测试", "Test") {
    init {      //所有的消息处理器在构造器里添加
        //添加消息处理器
        message("测试") {
            addMsg(Type.MSG, "测试失败")
        }

        //默认消息处理器的continue值为false
        //即：如果消息匹配, 执行完就退出本次处理
        message(".*") {
            addMsg(Type.MSG, "这条消息永远不可能为 `测试`")
        }
    }
}