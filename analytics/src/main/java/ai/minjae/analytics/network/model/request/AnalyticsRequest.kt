package ai.minjae.analytics.network.model.request

import com.google.gson.annotations.SerializedName

data class AnalyticsRequest(
    @field:SerializedName("requestId") val requestId: String,
    @field:SerializedName("cost") val cost: Int,
    @field:SerializedName("sessionId") val sessionId: String,
    @field:SerializedName("memberId") val memberId: String,
    @field:SerializedName("campaignId") val campaignId: String,
    @field:SerializedName("productId") val productId: String,
    @field:SerializedName("price") val price: Int,
    @field:SerializedName("fromAgent") val fromAgent: Boolean,
)
