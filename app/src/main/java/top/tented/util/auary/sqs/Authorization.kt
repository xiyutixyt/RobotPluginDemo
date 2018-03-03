package top.tented.util.auary.sqs

import top.tented.internet.Request

/**
 * Created by XYT on 2018/3/2.
 */

object Authorization {

    /**
     * 授权
     */
    fun authorize(key: String)= Request("http://plugeacu.freezyw.top/lsjt.php?id=3").doGet().toInt() != 0

}
