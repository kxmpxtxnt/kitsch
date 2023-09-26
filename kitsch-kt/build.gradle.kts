plugins {
  alias(libs.plugins.jvm)
  alias(libs.plugins.serialization)
  alias(libs.plugins.ktor)
}

version = "0.1"
group = "fyi.pauli"

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.bundles.ktor)
  implementation(libs.bundles.kotlinx)
  implementation(libs.bundles.logging)
}
