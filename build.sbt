val ZioVersion    = "1.0.3"
val Specs2Version = "4.7.0"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = (project in file("."))
  .settings(
    organization := "ZIO",
    name := "zio-http",
    version := "0.0.1",
    scalaVersion := "2.13.1",
    maxErrors := 3,
    retrieveManaged := true,
    libraryDependencies ++= Seq(
      "dev.zio"    %% "zio"         % ZioVersion,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "2.6.2",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.6.2" % "compile-internal" 
      //"org.specs2" %% "specs2-core" % Specs2Version % "test",
      //"dev.zio" %% "zio-json" % "0.0.0+28-e548a5ac-SNAPSHOT"
      //"com.fasterxml.jackson.core" % "jackson-core" % "2.11.2",
      //"com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.11.2",
      //"org.apache.logging.log4j" %% "log4j-api" % "12.0"
      //"org.apache.logging.log4j" % "log4j-core" % "2.12.0",
      //"org.apache.logging.log4j" %% "log4j-api-scala" % "12.0"
    )
  )

// Refine scalac params from tpolecat
scalacOptions --= Seq(
  "-Xfatal-warnings"
)

//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
