package top.tented.plugin.auary

import java.util.Date

/**
 * Created by XYT on 2018/2/26.
 */

//所有类名都大写
object Dada {

    val timePeriod: String
        get() {
            var period = ""
            val now = currentDateTime
            val hour = now.hours
            if (hour in 0..5) period = "凌晨"     //可以使用 in
            if (hour in 6..7) period = "早上"
            if (hour in 8..11) period = "上午"
            if (hour in 12..17) period = "下午"
            if (hour >= 18) period = "晚上"
            return period
        }
    val currentDateTime: Date get() = java.util.Calendar.getInstance().time
    fun operatePI(z: Double): Double {
        var sum = 2.0
        var n = 1
        var m = 3
        var t = 2.0
        while (t > z) {
            t = t * n / m
            sum += t
            n++
            m += 2
        }
        return sum
    }
}
