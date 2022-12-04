import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xemic.composeplayground.ui.home.Section
import com.xemic.composeplayground.ui.home.SectionScreen

@Composable
fun HomeSuccess(
    modifier: Modifier = Modifier,
    currentSection: Section,
    onSectionChanged: (Int) -> Unit,
    sectionList: List<Section>
) {
    Column {
        TopSectionBar(
            allSections = sectionList,
            onTabSelected = { index ->
                onSectionChanged(index)
            },
            currentScreen = currentSection
        )

        SectionScreen(
            modifier = modifier,
            currentSection = currentSection
        )
    }
}

@Composable
fun TopSectionBar(
    modifier: Modifier = Modifier,
    allSections: List<Section>,
    onTabSelected: (Int) -> Unit,
    currentScreen: Section
) {
    LazyRow(modifier) {
        allSections.forEachIndexed { index, section ->
            item {
                TopBarItem(
                    text = section.route,
                    selected = section == currentScreen
                ) {
                    onTabSelected(index)
                }
            }
        }
    }
}

@Composable
fun TopBarItem(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .padding(16.dp)
            .wrapContentHeight()
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.Tab
            ),
        text = text,
        color = if(selected) Color.Black else Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarItemPreview() {
    TopBarItem(
        text = "섹션 이름",
        selected = true,
        onClick = { }
    )
}