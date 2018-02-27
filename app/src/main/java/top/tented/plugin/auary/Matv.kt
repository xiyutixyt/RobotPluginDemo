package top.tented.plugin.auary

import top.tented.plugin.auary.Award
import java.util.ArrayList
import java.util.Random

/**
 * Created by XYT on 2018/2/25.
 */

object Matv {
    fun lottery(awards: List<Award>): Award? {
        var totalPro = 0f
        val proSection = ArrayList<Float>()
        proSection.add(0f)
        for (award in awards) {
            totalPro += award.probability * 10f * award.count.toFloat()
            proSection.add(totalPro)
        }
        val random = Random()
        val randomPro = random.nextInt(totalPro.toInt()).toFloat()
        var i = 0
        val size = proSection.size
        while (i < size) {
            if (randomPro >= proSection[i] && randomPro < proSection[i + 1]) {
                return awards[i]
            }
            i++
        }
        return null
    }
}
