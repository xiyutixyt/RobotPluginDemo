package top.tented.plugin.auary

import java.util.Date

/**
 * Created by XYT on 2018/2/26.
 */

object dade {

    val timePeriod: String
        get() {
            var period = ""
            val now = currentDateTime
            val hour = now.hours
            if (hour >= 0 && hour < 6) period = "凌晨"
            if (hour >= 6 && hour < 8) period = "早上"
            if (hour >= 8 && hour < 12) period = "上午"
            if (hour >= 12 && hour < 18) period = "下午"
            if (hour >= 18) period = "晚上"
            return period
        }
    val currentDateTime: Date
        get() {
            val calNow = java.util.Calendar.getInstance()
            return calNow.time
        }
    fun jishuPI(z: Double): Double {
        var sum = 2.0
        var n = 1
        var m = 3
        var t = 2.0
        while (t > z) {
            t = t * n / m
            sum = sum + t
            n++
            m += 2
        }
        return sum
    }
}
