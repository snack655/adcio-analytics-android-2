package ai.minjae.adcio_analytics

import ai.minjae.adcio_analytics.ui.theme.AdcioAnalyticsTheme
import ai.minjae.analytics.feature.AdcioAnalytics
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AdcioAnalytics.init(this)

        setContent {

            AdcioAnalyticsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Row {
                        Text(
                            text = "ADCIO Analytics Playground",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    PlayItem(title = "Impression", desc = "Log event for impression", text = "send impression log") {
                        try {
                            AdcioAnalytics.impressionLogEvent(
                                requestId = "requestId",
                                cost = 1230,
                                memberId = "memberId",
                                campaignId = "campaignId",
                                productId = "productId",
                                price = 1230,
                                fromAgent = true,
                            )
                        } catch (e: Exception) {
                            Log.e("AnalyticsTest", e.stackTraceToString())
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    PlayItem(title = "Click", desc = "Log event for click", text = "send click log") {
                        AdcioAnalytics.clickLogEvent(
                            requestId = "requestId",
                            cost = 1230,
                            memberId = "memberId",
                            campaignId = "campaignId",
                            productId = "productId",
                            price = 1230,
                            fromAgent = true,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    PlayItem(title = "Purchase", desc = "Log event for purchase", text = "send purchase log") {
                        AdcioAnalytics.purchaseLogEvent(
                            requestId = "requestId",
                            cost = 1230,
                            memberId = "memberId",
                            campaignId = "campaignId",
                            productId = "productId",
                            price = 1230,
                            fromAgent = true,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PlayItem(
    title: String,
    desc: String,
    text: String,
    color: Color = Color.LightGray,
    action: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = 5.dp),
        )
        Text(
            text = desc,
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 5.dp),
        )
        Button(
            onClick = { action() },
            colors = ButtonDefaults.buttonColors(containerColor = color),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = text)
        }
    }
}
