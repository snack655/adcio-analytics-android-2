package ai.minjae.analytics.mapper

import ai.minjae.analytics.model.LogOption
import ai.minjae.analytics.network.model.request.AnalyticsRequest

fun LogOption.mapToAnalyticsRequest(): AnalyticsRequest = AnalyticsRequest(
    requestId = requestId,
    cost = cost,
    sessionId = sessionId,
    memberId = memberId,
    campaignId = campaignId,
    productId = productId,
    price = price,
    fromAgent = fromAgent,
)
