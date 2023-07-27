package ai.minjae.analytics.di

import ai.minjae.analytics.repository.AnalyticsRepository
import ai.minjae.analytics.repository.AnalyticsRepositoryImpl

object RepositoryModule {

    private lateinit var analyticsRepository: AnalyticsRepository

    fun provideAnalyticsRepository(): AnalyticsRepository {
        analyticsRepository = AnalyticsRepositoryImpl()
        return analyticsRepository
    }

    /*
    fun provideTestAnalyticsRepository(): AnalyticsRepository {
        analyticsRepository = TestAnalyticsRepositoryImpl()
        return analyticsRepository
    }
     */
}
