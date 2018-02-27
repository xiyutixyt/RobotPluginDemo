package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler
import top.tented.plugin.auary.*
import java.io.File


/**
 * Created by XYT on 2018/2/25.
 */
object Robo : Handler("基础服务", "1.0") {
    val path = file.getSD("WOKT")

    init {
        message("抽奖") {
            val awards = listOf(
                Award("通用货币-60000", 0.1f, 100),
                Award("通用货币-40000", 0.2f, 100),
                Award("通用货币-30000", 0.3f, 100),
                Award("通用货币-300000", 0.05f, 100),
                Award("通用货币-35000", 0.2f, 100)
            )
            val hb = Matv.lottery(awards)!!.id.split("-")[1].toInt()            //尽量别用!!, 或者说是禁止
            File("$path/基础数据/${this.group}/${this.uin}/通用货币.txt").run {
                writeText((readText().toInt() + hb).toString())
            }       //.run {} 是一个扩展函数
                    //this指.前面的对象
                    //例如上面的writeText, 是可以写成this.writeText的, 但是this可以被省略, 所以写成了writeText
            addMsg(PluginMsg.Key.Message,"恭喜您，抽到了：${Matv.lottery(awards)?.id}")
        }

        message("圆周率 (\\d+\\.\\d+)") {
            val precision = it.group(1).toDouble()
            addMsg(PluginMsg.Key.Message,"在精度为${precision}的情况下圆周率为${Dada.operatePI(precision)}")
        }
    }
}