
import sbt._
import Keys._

object Querulous extends Build {

	lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    	organization := "com.github.bigtoast",
    	version      := "1.1.0",
    	scalaVersion := "2.10.3",
    	crossPaths   := true )

	val mysql = "mysql"        % "mysql-connector-java" % "5.1.24"
  val dbcp  = "commons-dbcp" % "commons-dbcp"         % "1.4"
  val pool  = "commons-pool" % "commons-pool"         % "1.5.4"

  val specs2    = "org.specs2"   %% "specs2"              % "2.1.1"   % "test"
  val mockito   = "org.mockito"  %  "mockito-all"         % "1.9.5"   % "test"
  //val dbcpTests = "commons-dbcp" % "commons-dbcp"         % "20030818.201141" % "test" //%  "commons-dbcp-tests"  % "1.4"     % "test"


	lazy val core = Project("querulous-core",
		base     = file("querulous-core"),
		settings = buildSettings ++ Seq(
      libraryDependencies ++= mysql :: dbcp :: pool :: specs2 :: mockito :: Nil,
      publishTo := Some(Resolver.file("ticketfly.github.com", file(sys.env.get("TICKETFLY_HOME").getOrElse(Path.userHome) + "/ticketfly.github.com/repo")))
      ))


}
