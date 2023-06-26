// scalabix

// ===========================================================================
ThisBuild / version      := "0.1.0"
ThisBuild / scalaVersion := "2.13.11"

// ===========================================================================
lazy val `scalabix-core`     = project.dependsOn(RootProject(file("../../aptus/aptus-core" )))        

  lazy val `scalabix-genomics` = project.dependsOn(`scalabix-core`)
  lazy val `scalabix-variants` = project.dependsOn(`scalabix-genomics`)

// ===========================================================================
lazy val uTestVersion      = "0.8.1"
lazy val enumeratumVersion = "1.5.13" 
lazy val samToolsVersion   = "2.9.1"

// ===========================================================================
ThisBuild / libraryDependencies ++=
  Seq(        
    //"io.github.aptusproject" %% "aptus-core"    % "0.3.0",
    "com.beachape"        %% "enumeratum" % enumeratumVersion withSources() withJavadoc(),
    "com.github.samtools"  % "htsjdk"     % samToolsVersion   withSources() withJavadoc() )

// ===========================================================================
// testing

ThisBuild / libraryDependencies += "com.lihaoyi" %% "utest" % uTestVersion % "test" withSources() withJavadoc()

ThisBuild / testFrameworks += new TestFramework("utest.runner.Framework")

// ===========================================================================

