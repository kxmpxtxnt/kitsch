plugins {

}

rootProject.name = "kitsch"

include(
  "kitsch-kt",
)

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

      library("ktor.client.cio", "io.ktor", "ktor-client-cio").withoutVersion()
      library("ktor.client.core", "io.ktor", "ktor-client-core").withoutVersion()
      library("ktor.client.resources", "io.ktor", "ktor-client-resources").withoutVersion()
      library("ktor.client.negotiation", "io.ktor", "ktor-client-content-negotiation").withoutVersion()
      library("ktor.client.auth", "io.ktor", "ktor-client-auth").withoutVersion()

      bundle(
        "ktor",
        listOf(
          "ktor.client.core",
          "ktor.client.cio",
          "ktor.client.resources",
          "ktor.client.negotiation",
          "ktor.client.auth",
        )
      )

      version("logback", "1.4.11")
      version("kotlin-logging", "5.1.0")

      library("logging.logback", "ch.qos.logback", "logback-classic").versionRef("logback")
      library("logging.kotlin", "io.github.oshai", "kotlin-logging-jvm").versionRef("kotlin-logging")

      bundle("logging", listOf("logging.logback", "logging.kotlin"))
    }
  }
}
