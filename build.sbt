organization := "com.ticketfly"

name := "querulous"

version := "1.2.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "mysql"         % "mysql-connector-java"  % "5.1.24",
  "commons-dbcp"  % "commons-dbcp"          % "1.4",
  "commons-pool"  % "commons-pool"          % "1.5.4",
  "org.specs2"    %% "specs2"               % "2.3.13"  % Test,
  "org.mockito"   % "mockito-all"           % "1.9.5"   % Test
)


publishTo := {
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("tfly-snaps" at "http://build.ticketfly.com/artifactory/libs-snapshot-local")
  else
    Some("tfly-release" at "http://build.ticketfly.com/artifactory/libs-release-local")
}

