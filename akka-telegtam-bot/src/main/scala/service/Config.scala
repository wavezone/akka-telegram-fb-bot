package service

import com.typesafe.config.ConfigFactory

trait Config {
  private val config = ConfigFactory.load()
  private val httpConfig = config.getConfig("http")
  private val databaseConfig = config.getConfig("database")
  val httpInterface: String = httpConfig.getString("interface")
  val httpPort: Int = httpConfig.getInt("port")

  private lazy val facebookConfig = config.getConfig("api.facebook")
  lazy val fbAccessToken: String = facebookConfig.getString("appToken")

  val databaseUrl: String = databaseConfig.getString("url")
  val databaseUser: String = databaseConfig.getString("user")
  val databasePassword: String = databaseConfig.getString("password")

}
