import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.examenrecupcca.R
import com.example.examenrecupcca.ui.theme.AppTheme

object MainUIBarProvider : MainUIInterface {
    private val activitiesId= R.array.menuEntries
    @Composable
    override fun mainBar(activity: Activity) {
            val activities = ContextWrapper(activity).resources.getStringArray(activitiesId)
            mainBarColumn(activities, activity.javaClass.simpleName)

    }

    @Composable
    override fun mainBarColumn(activities: Array<String>,currentActivity: String) {
        AppTheme {
            Surface(color = MaterialTheme.colorScheme.primary,) {
                Box(
                    modifier = Modifier.sizeIn(minWidth = 60.dp, maxWidth = 80.dp).fillMaxHeight()
                        .padding(top = 20.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        activities.forEach {
                            var color = MaterialTheme.colorScheme.tertiary
                            if (currentActivity == it) {
                                color = MaterialTheme.colorScheme.secondary
                            }
                            Box(modifier = Modifier.padding(vertical = 10.dp),) {
                                Surface(color = color) {
                                    Text(
                                        modifier = Modifier.padding(start = 3.dp),
                                        text = it,
                                        fontSize = TextUnit(20f, type = TextUnitType.Sp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
@Composable
@Preview
fun mainBarPreview() {

    val activities= arrayOf("Hola","adios","buenas","hasta luego")
    MainUIBarProvider.mainBarColumn(activities,"buenas")
}





