package top.tented.plugin.auary

import java.util.Date

/**
 * Created by XYT on 2018/2/26.
 */

//所有类名都大写
object Dada {

    val timePeriod: String
        get() = when(currentDateTime.hours) {
            in 0..5 -> "凌晨"
            in 6..7 -> "早上"
            in 8..11 -> "上午"
            in 12..17 -> "下午"

            else -> "晚上"
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
