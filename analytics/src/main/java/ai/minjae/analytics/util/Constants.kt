package ai.minjae.analytics.util

object Constants {
    var baseUrl = "https://receiver-dev.adcio.ai/api/"

    fun changeBaseUrl(url: String) {
        baseUrl = url
    }
}
