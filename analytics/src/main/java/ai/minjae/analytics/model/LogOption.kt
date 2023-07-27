package ai.minjae.analytics.model

data class LogOption(
    val requestId: String,
    val cost: Int,
    val sessionId: String,
    val memberId: String,
    val campaignId: String,
    val productId: String,
    val price: Int,
    val fromAgent: Boolean,
)
