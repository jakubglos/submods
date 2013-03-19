import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "subtest"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.scalatest" %% "scalatest" % "1.8" % "test",
      "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.28" % "test",
      "com.mongodb.casbah" %% "casbah" % "2.1.5-1",
      "com.novus" %% "salat-core" % "0.0.8-SNAPSHOT",
      "org.webjars" % "webjars-play" % "2.0",
      "org.webjars" % "bootstrap" % "2.2.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      testOptions in Test := Nil,
      resolvers ++= Seq(
        "repo.novus snaps"    at "http://repo.novus.com/snapshots/",
        "ex scala-tools repo" at "https://oss.sonatype.org/content/groups/scala-tools/"
      )
    )

}
