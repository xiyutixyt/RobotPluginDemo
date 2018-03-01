package top.tented.util.auary

import java.sql.*

/**
 * Created by XYT on 2018/3/1.
 */

object sql {

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
