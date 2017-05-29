import com.typesafe.config.ConfigFactory
import scala.util.{Try, Success, Failure}

val btVersion: String = {
  Try(ConfigFactory.load.getString("version")) match {
    case Success(ver) => ver
    case Failure(e) => "0.1.0"
  }
}

name := "logging"
version := btVersion
scalaVersion := "2.11.11"
organization := "com.cjww-dev.libs"

val codeDep: Seq[ModuleID] = Seq("com.typesafe.play" % "play_2.11" % "2.5.15")

libraryDependencies ++= codeDep

bintrayOrganization := Some("cjww-development")
bintrayReleaseOnPublish in ThisBuild := true
bintrayRepository := "releases"
bintrayOmitLicense := true
