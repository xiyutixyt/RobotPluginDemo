package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler

/**
 * Money
 * Created by hoshino on 18-2-25 下午9:50.
 */
object Money : Handler("金币系统", "1.0") {
    val moneyName = "金币"
    val moneyUnit = "枚"

    init {
        message("钱包|积分") {
            at(member)
            addMsg(PluginMsg.Key.Message, "\n你有${member.money}$moneyUnit$moneyName")
        }
    }
}