package ai.minjae.analytics.repository

import ai.minjae.analytics.mapper.mapToAnalyticsRequest
import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.network.model.response.AnalyticsResponse
import ai.minjae.analytics.network.retrofit.RetrofitClient

class FakeAnalyticsRepositoryImpl : AnalyticsRepository {

    val service = RetrofitClient.analyticsService

    override suspend fun impressionLogEvent(logOption: LogOption): Result<AnalyticsResponse> = kotlin.runCatching {
        service.postImpression(logOption.mapToAnalyticsRequest())
    }

    override suspend fun clickLogEvent(logOption: LogOption): Result<AnalyticsResponse> = kotlin.runCatching {
        service.postClick(logOption.mapToAnalyticsRequest())
    }

    override suspend fun purchaseLogEvent(logOption: LogOption): Result<AnalyticsResponse> = kotlin.runCatching {
        service.postPurchase(logOption.mapToAnalyticsRequest())
    }
}
