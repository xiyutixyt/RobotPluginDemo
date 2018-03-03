package top.tented.util.auary.sqs.time

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by XYT on 2018/3/3.
 */

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val timer = Timer()
        val timeTask = MyTimerTask()
        val calendar = Calendar.getInstance()
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        println("current time is " + df.format(calendar.time))
        timer.schedule(timeTask, calendar.time)
    }
}
