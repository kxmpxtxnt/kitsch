package fyi.pauli.kitsch

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlin.time.Duration.Companion.seconds

internal val json: Json = Json {
  prettyPrint = false
  encodeDefaults = true

  serializersModule = SerializersModule {

  }
}

internal class Kitsch(
  private val oAuthToken: String,
  var httpClient: HttpClient = HttpClient(CIO) {

    engine {
      requestTimeout = 10.seconds.inWholeMilliseconds
      maxConnectionsCount = 1000
    }

    install(ContentNegotiation) {
      json
    }


  }
) {

  suspend fun test() {

  }
}
