name := "spireworkshop"

scalaVersion := "2.12.2"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
	"org.typelevel" %% "spire" % "0.14.1",
	"com.github.ichoran" %% "thyme" % "0.1.2-SNAPSHOT" % "test",
	"org.scalacheck" %% "scalacheck" % "1.13.5" % "test"
)
