package ai.minjae.analytics.util

object Constants {
    var baseUrl = "https://receiver-dev.adcio.ai/api/test/"

    fun changeBaseUrl(url: String) {
        baseUrl = url
    }
}
