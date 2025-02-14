import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable

interface MainUIInterface {
    @Composable
    fun mainBar(activity: Activity)
    @Composable
    fun mainRowActivities(activities:Array<String>,currentActivity: String)
}