import com.typesafe.config.ConfigFactory
import scala.util.{Try, Success, Failure}

val btVersion: String = {
  Try(ConfigFactory.load.getString("version")) match {
    case Success(ver) => ver
    case Failure(_) => "INVALID_RELEASE_VERSION"
  }
}

name := "logging"
version := btVersion
scalaVersion := "2.11.11"
organization := "com.cjww-dev.libs"

val codeDep: Seq[ModuleID] = Seq("com.typesafe.play" % "play_2.11" % "2.5.14")
val testDep: Seq[ModuleID] = Seq("org.scalatestplus.play" % "scalatestplus-play_2.11" % "2.0.0")

libraryDependencies ++= codeDep
libraryDependencies ++= testDep

bintrayOrganization := Some("cjww-development")
bintrayReleaseOnPublish in ThisBuild := false
bintrayRepository := "releases"
bintrayOmitLicense := true
