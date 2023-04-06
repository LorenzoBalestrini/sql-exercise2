import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



    fun main(){
        var connection : Connection? = null
        try{

            val url = "jdbc:mysql://localhost:3306/newdb"
            val user = "developer"
            val password = "1234"

            connection = DriverManager.getConnection(url, user, password)
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("select * from students")

            while(resultSet.next()) {
                val metaData = resultSet.metaData
                for(i in 1..metaData.columnCount) {
                    println(resultSet.getObject(i))
                }
            }
        }catch (e: SQLException){
            println(e.message)
        } finally {
            try {
                connection?.close()
            }catch (ex: SQLException) {
                println(ex.message)
            }
        }

    }
