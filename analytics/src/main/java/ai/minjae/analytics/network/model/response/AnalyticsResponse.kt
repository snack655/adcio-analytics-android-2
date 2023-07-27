package ai.minjae.analytics.network.model.response

import com.google.gson.annotations.SerializedName

data class AnalyticsResponse(
    @field:SerializedName("success") val success: Boolean,
    @field:SerializedName("statusCode") val statusCode: Int,
    @field:SerializedName("message") val message: String,
    @field:SerializedName("error") val error: String,
)
