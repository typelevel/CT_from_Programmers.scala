enablePlugins(TutPlugin)

scalaVersion := "2.12.2"

scalacOptions in Tut ~= (_.filterNot(Set("-Ywarn-unused-import", "-Ywarn-dead-code")))
