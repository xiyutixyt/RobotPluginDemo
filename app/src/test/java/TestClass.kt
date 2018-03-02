import org.junit.Test
import top.tented.plugin.Handler

/**
 * Created by XYT on 2018/3/2.
 */
class TestClass {
    @Test
    fun doTest() {
        object : Handler("", "" ) {
            init {
                message("") {

                }
            }
        }
    }

    @Test
    fun 测试函数() {
        //TODO
    }
}