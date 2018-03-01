package top.tented.util.auary

import java.sql.*

/**
 * Created by XYT on 2018/3/1.
 */

object sql {

    // 就是这个数据库这个配置我就看懂127.0.0.1和root和那个password分别是数据库地址，账号，密码
    // 似乎没有看到数据库名 所以帮我配置下吧
    // 账号:plugeacu密码lbCD52ulYC
    // 数据库地址：localhost
    // 数据库端口：3306
    // 数据库名：plugeacu
    @Throws(Exception::class)
    fun sql(sql: String) {

        Class.forName("com.mysql.jdbc.Driver")
        val jdbc = "jdbc:mysql://127.0.0.1:3306/mydb?characterEncoding=GBK"
        val conn = DriverManager.getConnection(jdbc, "root", "")
        val state = conn.createStatement()
        state.executeUpdate(sql)

        conn.close()

    }
}
