plugins {

}

rootProject.name = "kitsch"

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      version("ktor", "2.3.4")
      version("kotlin", "1.9.10")
      version("coroutines", "1.7.3")
      version("serialization", "1.6.0")

      plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
      plugin("serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
      plugin("ktor", "io.ktor.plugin").versionRef("ktor")

      library(
        "kotlinx.serialization",
        "org.jetbrains.kotlinx",
        "kotlinx-serialization-json"
      ).versionRef("serialization")

      library("kotlinx.coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")

      bundle("kotlinx", listOf("kotlinx.serialization", "kotlinx.coroutines"))

      library("ktor.server.cio", "io.ktor", "ktor-server-cio").withoutVersion()
      library("ktor.server.core", "io.ktor", "ktor-server-core").withoutVersion()
      library("ktor.server.resources", "io.ktor", "ktor-server-resources").withoutVersion()
      library("ktor.server.negotiation", "io.ktor", "ktor-server-content-negotiation").withoutVersion()
      library("ktor.server.logging", "io.ktor", "ktor-server-call-logging").withoutVersion()

      bundle(
        "ktor",
        listOf(
          "ktor.server.core",
          "ktor.server.cio",
          "ktor.server.resources",
          "ktor.server.negotiation",
          "ktor.server.logging",
        )
      )
    }
  }
}
