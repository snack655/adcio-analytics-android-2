package ai.minjae.analytics.feature

import ai.minjae.analytics.di.RepositoryModule
import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.repository.AnalyticsRepository
import ai.minjae.analytics.util.Constants
import android.os.Build
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

private const val SUCCESS_LOG_EVENT_MESSAGE = "로깅에 성공했습니다."

class AdcioAnalytics {

    private var analyticsRepository: AnalyticsRepository
    private val sessionId: String = Build.ID

    constructor(
        analyticsRepository: AnalyticsRepository = RepositoryModule.provideAnalyticsRepository(),
    ) {
        this.analyticsRepository = analyticsRepository
    }
    constructor(
        analyticsRepository: AnalyticsRepository = RepositoryModule.provideAnalyticsRepository(),
        baseUrl: String
    ): this(analyticsRepository) {
        Constants.baseUrl = baseUrl
    }

    fun impressionLogEvent(
        requestId: String,
        cost: Int,
        memberId: String,
        campaignId: String,
        productId: String,
        price: Int,
        fromAgent: Boolean,
    ): String {
        var message = ""
        runBlocking(Dispatchers.IO) {
            analyticsRepository.impressionLogEvent(
                LogOption(
                    requestId = requestId,
                    cost = cost,
                    sessionId = sessionId,
                    memberId = memberId,
                    campaignId = campaignId,
                    productId = productId,
                    price = price,
                    fromAgent = fromAgent,
                )
            ).onSuccess {
                if (it.success == true)
                    message = SUCCESS_LOG_EVENT_MESSAGE
            }.onFailure {
                throw it
            }
        }
        return message
    }

    fun clickLogEvent(
        requestId: String,
        cost: Int,
        memberId: String,
        campaignId: String,
        productId: String,
        price: Int,
        fromAgent: Boolean,
    ): String {
        var message = ""
        runBlocking(Dispatchers.IO) {
            analyticsRepository.clickLogEvent(
                LogOption(
                    requestId = requestId,
                    cost = cost,
                    sessionId = sessionId,
                    memberId = memberId,
                    campaignId = campaignId,
                    productId = productId,
                    price = price,
                    fromAgent = fromAgent,
                )
            ).onSuccess {
                if (it.success == true)
                    message = SUCCESS_LOG_EVENT_MESSAGE
            }.onFailure {
                throw it
            }
        }
        return message
    }

    fun purchaseLogEvent(
        requestId: String,
        cost: Int,
        memberId: String,
        campaignId: String,
        productId: String,
        price: Int,
        fromAgent: Boolean,
    ): String {
        var message = ""
        runBlocking(Dispatchers.IO) {
            analyticsRepository.purchaseLogEvent(
                LogOption(
                    requestId = requestId,
                    cost = cost,
                    sessionId = sessionId,
                    memberId = memberId,
                    campaignId = campaignId,
                    productId = productId,
                    price = price,
                    fromAgent = fromAgent,
                )
            ).onSuccess {
                if (it.success == true)
                    message = SUCCESS_LOG_EVENT_MESSAGE
            }.onFailure {
                throw it
            }
        }
        return message
    }
}