package ai.minjae.analytics.network.service

import ai.minjae.analytics.network.model.request.AnalyticsRequest
import ai.minjae.analytics.network.model.response.AnalyticsResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AnalyticsService {

    @POST("performance/impression")
    suspend fun postImpression(
        @Body analyticsRequest: AnalyticsRequest,
    ): AnalyticsResponse

    @POST("performance/click")
    suspend fun postClick(
        @Body analyticsRequest: AnalyticsRequest,
    ): AnalyticsResponse

    @POST("performance/purchase")
    suspend fun postPurchase(
        @Body analyticsRequest: AnalyticsRequest,
    ): AnalyticsResponse
}
