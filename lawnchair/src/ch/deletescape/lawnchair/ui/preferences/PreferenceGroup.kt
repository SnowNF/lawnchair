package ch.deletescape.lawnchair.ui.preferences

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ch.deletescape.lawnchair.util.smartBorder

@Composable
fun PreferenceGroup(heading: String? = null, useTopPadding: Boolean = false, content: @Composable () -> Unit) {
    if (useTopPadding) Spacer(modifier = Modifier.requiredHeight(16.dp))
    Column {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .smartBorder(
                    1.dp,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.12F),
                    shape = MaterialTheme.shapes.large
                )
                .clip(shape = MaterialTheme.shapes.large)
        ) {
            heading?.let {
                Column(
                    modifier = Modifier
                        .height(48.dp)
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.medium,
                        LocalContentColor provides MaterialTheme.colors.onBackground
                    ) {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.subtitle2,
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
            content()
        }
    }
}