package top.tented.plugin.auary

/**
 * Created by XYT on 2018/2/25.
 */

class Award {

    var id: String = ""

    var probability: Float = 0.toFloat()

    var count: Int = 0

    constructor(id: String, probability: Float, count: Int) : super() {
        this.id = id // 编号
        this.probability = probability // 抽中的概率
        this.count = count // 总共的数量
    }

    constructor() {

    }
}
