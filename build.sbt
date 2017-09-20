name := "spireworkshop"

scalaVersion := "2.12.1"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.typelevel" %% "spire" % "0.14.1",
  "org.typelevel" %% "spire-extras" % "0.14.1",
  "org.typelevel" %% "spire-laws" % "0.14.1" % "test",
  "org.typelevel" %% "cats-core" % "0.9.0",
  "com.github.ichoran" %% "thyme" % "0.1.2-SNAPSHOT" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.5" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

initialCommands in console += """
import spire.math._
import spire.algebra._
import spire.implicits._
"""
