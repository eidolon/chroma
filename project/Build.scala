/**
 * This file is part of the "eidolon/chroma" project.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import com.typesafe.sbt.packager.archetypes.{JavaAppPackaging, JavaServerAppPackaging}
import sbt.Keys._
import sbt.{Build => BaseBuild, _}

/**
 * Main build file
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
object Build extends BaseBuild {

  import Dependencies._

  val `project-version` = taskKey[Unit]("Print the current version")
  val projectVersion = "1.0.0"

  lazy val commonSettings = Seq(
    organization := "eidolon",
    publishMavenStyle := true,
    publishTo := Some(Resolver.file("release", new File("./release"))),
    scalaVersion := "2.11.7",
    version := projectVersion,
    testOptions in Test += Tests.Argument("-oD")
  )

  lazy val chroma = (project in file("."))
    .enablePlugins(JavaAppPackaging)
    .enablePlugins(JavaServerAppPackaging)
    .settings(commonSettings: _*)
    .settings(name := "chroma")
    .settings(`project-version` := {
      println(projectVersion)
    })
    .settings(libraryDependencies ++=
      test(mockito, scalaTest)
    )
}

