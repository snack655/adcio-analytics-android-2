package ai.minjae.analytics.repository

import ai.minjae.analytics.mapper.mapToAnalyticsRequest
import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.network.model.response.AnalyticsResponse
import ai.minjae.analytics.network.retrofit.RetrofitClient
import ai.minjae.analytics.network.service.AnalyticsService

class AnalyticsRepositoryImpl : AnalyticsRepository {

    private lateinit var analyticsService: AnalyticsService

    override suspend fun impressionLogEvent(logOption: LogOption): Result<AnalyticsResponse> = kotlin.runCatching {
        analyticsService = RetrofitClient.analyticsService
        analyticsService.postImpression(logOption.mapToAnalyticsRequest())
    }

    override suspend fun clickLogEvent(logOption: LogOption): Result<AnalyticsResponse> = kotlin.runCatching {
        analyticsService = RetrofitClient.analyticsService
        analyticsService.postClick(logOption.mapToAnalyticsRequest())
    }

    override suspend fun purchaseLogEvent(logOption: LogOption): Result<AnalyticsResponse> = kotlin.runCatching {
        analyticsService = RetrofitClient.analyticsService
        analyticsService.postPurchase(logOption.mapToAnalyticsRequest())
    }
}
