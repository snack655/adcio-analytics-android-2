package ai.minjae.analytics.feature

import ai.minjae.analytics.di.RepositoryModule
import ai.minjae.analytics.exception.EmptyEnvFileException
import ai.minjae.analytics.exception.NotInitializedException
import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.repository.AnalyticsRepository
import ai.minjae.analytics.util.Constants
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.lang.Exception

private const val DEFAULT_BASE_URL = "https://receiver-dev.adcio.ai/api/"
private const val BASE_URL_KEY = "ai.minjae.analytics.BASE_URL"

object AdcioAnalytics {

    private var analyticsRepository: AnalyticsRepository = RepositoryModule.provideAnalyticsRepository()
    private var isInitialized: Boolean = false

    private lateinit var sessionId: String

    fun init(context: Context) {
        // SessionId 발급
        sessionId = Build.ID

        try {
            // SDK 버전에 맞춘 Application 정보 객체 받아오기
            val applicationInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.packageManager.getApplicationInfo(context.packageName, PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong()))
            } else {
                context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            }

            // Metedata가 든 bundle 객체 받아오기
            val bundle = applicationInfo.metaData
            // bundle 객체가 비었다면 Env 세팅이 되어있지 않은 것.
            if (bundle != null)
                changeBaseUrl(bundle.getString(BASE_URL_KEY))
            else throw EmptyEnvFileException()

        } catch (e: Exception) {
            throw e
        }
        isInitialized = true
    }

    fun impressionLogEvent(
        requestId: String,
        cost: Int,
        memberId: String,
        campaignId: String,
        productId: String,
        price: Int,
        fromAgent: Boolean,
    ) {
        if (!isInitialized) throw NotInitializedException()
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
            ).onFailure {
                throw it
            }
        }
    }

    fun clickLogEvent(
        requestId: String,
        cost: Int,
        memberId: String,
        campaignId: String,
        productId: String,
        price: Int,
        fromAgent: Boolean,
    ) {
        if (!isInitialized) throw NotInitializedException()
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
            ).onFailure {
                throw it
            }
        }
    }

    fun purchaseLogEvent(
        requestId: String,
        cost: Int,
        memberId: String,
        campaignId: String,
        productId: String,
        price: Int,
        fromAgent: Boolean,
    ) {
        if (!isInitialized) throw NotInitializedException()
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
            ).onFailure {
                throw it
            }
        }
    }

    fun getSessionId(): String = if (isInitialized)
        sessionId
    else
        throw NotInitializedException()

    private fun changeBaseUrl(baseUrl: String?) {
        if (baseUrl.isNullOrBlank()) Constants.baseUrl = DEFAULT_BASE_URL
        else Constants.baseUrl = baseUrl
    }
}
