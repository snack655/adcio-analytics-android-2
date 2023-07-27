package ai.minjae.analytics.repository

import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.network.model.response.AnalyticsResponse

interface AnalyticsRepository {

    suspend fun impressionLogEvent(logOption: LogOption): Result<AnalyticsResponse>

    suspend fun clickLogEvent(logOption: LogOption): Result<AnalyticsResponse>

    suspend fun purchaseLogEvent(logOption: LogOption): Result<AnalyticsResponse>
}
