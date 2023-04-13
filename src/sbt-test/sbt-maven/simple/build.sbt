lazy val root = project
  .in(file("."))
  .enablePlugins(SbtMavenPlugin)
  .settings(
    libraryDependencies += "org.apache.maven.plugin-tools" % "maven-plugin-annotations" % "3.8.1" % Provided,
    libraryDependencies += "org.apache.maven" % "maven-core" % "3.8.1" % Provided,

    libraryDependencies += "com.typesafe.play" %% "twirl-compiler" % "1.5.2",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",

    name := "Simple",

    mavenPluginGoalPrefix := "twirl",
    mavenClasspath := (`maven-launcher` / Compile / externalDependencyClasspath).value.map(_.data),
    mavenTestArgs += s"-Dtest.version=${version.value}"
  )

lazy val `maven-launcher` = project
  .in(file("launcher"))
  .settings(
    name := "maven-launcher",
    description := "Dummy project, exists only to resolve the maven launcher classpath",
    libraryDependencies := Seq("org.apache.maven" % "apache-maven" % "3.8.1")
  )
