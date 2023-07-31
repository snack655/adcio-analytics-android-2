package ai.minjae.analytics

import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.repository.AnalyticsRepositoryImpl
import ai.minjae.analytics.repository.FakeAnalyticsRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.system.measureTimeMillis

class PerformUnitTest {

    // Set
    private val fakeAnalyticsRepository = FakeAnalyticsRepositoryImpl()
    private val analyticsRepository = AnalyticsRepositoryImpl()

    // Result
    @Test
    fun `baseUrl을 변경하지 않는 상황`() {
        val elapsed: Long = measureTimeMillis {
            runBlocking {
                fakeAnalyticsRepository.impressionLogEvent(
                    LogOption(
                        requestId = "",
                        cost = 1234,
                        sessionId = "",
                        memberId = "",
                        campaignId = "",
                        productId = "",
                        price = 1234,
                        fromAgent = true,
                    )
                )
            }
        }
        println("fake : $elapsed")
    }

    @Test
    fun `baseUrl을 변경하는 상황`() {
        val elapsed: Long = measureTimeMillis {
            runBlocking {
                analyticsRepository.impressionLogEvent(
                    LogOption(
                        requestId = "",
                        cost = 1234,
                        sessionId = "",
                        memberId = "",
                        campaignId = "",
                        productId = "",
                        price = 1234,
                        fromAgent = true,
                    )
                )
            }
        }
        println("real : $elapsed")
    }
}
