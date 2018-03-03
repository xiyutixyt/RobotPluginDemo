package top.tented.util.auary.sqs.time


import top.tented.util.auary.Dada
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by XYT on 2018/3/3.
 */

class MyTimerTask : TimerTask() {
    override fun run() {
        try {
            Thread.sleep(Ps.time.toLong())
        } catch (e: InterruptedException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
        val msg: String
        Dada.timePeriod = when(Dada.currentDateTime[Calendar.HOUR]) {
            in "凌晨" -> "大家都睡得好晚呢!看来都是同路人(修仙党)"
            in "早上" -> "大家早上好!一晚上睡得香吗?"
            in "下午" -> "大家下午好啊!似乎有点比中午凉了呢"
            else -> "晚上好啊,希酱有点困了呢~但是还是要修仙的!"
        }

            }
        }

        val df = SimpleDateFormat("POT综合插件希酱提醒你\n大家期待已久的整点到啦!\n当前时间为:yyyy-MM-dd HH:mm:ss\n$msg")
        df.format(scheduledExecutionTime())
    }

}
