package top.tented.plugin.auary

import java.util.*

/**
 * Created by XYT on 2018/2/26.
 */

//所有类名都大写
object Dada {
    val currentDateTime get() = java.util.Calendar.getInstance()            //能用Calendar就别用Data
    val timePeriod: String
        get() = when(currentDateTime[Calendar.HOUR]) {
            in 0..5 -> "凌晨"
            in 6..7 -> "早上"
            in 8..11 -> "上午"
            in 12..17 -> "下午"

            else -> "晚上"
        }
    fun operatePI(z: Double): Double {
        var sum = 2.0
        var n = 1       //尽量不要用无意义的字符, 不会英文就 https://fanyi.baidu.com/
        var m = 3       //然后如果自己看不懂就把中文意思注释在旁边
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
