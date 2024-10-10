package id.adiyusuf.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.adiyusuf.jetcoffee.model.dummyCategory
import id.adiyusuf.jetcoffee.ui.components.CategoryItem
import id.adiyusuf.jetcoffee.ui.components.Search
import id.adiyusuf.jetcoffee.ui.components.SectionText
import id.adiyusuf.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Banner()
        SectionText(stringResource(R.string.section_category))
        CategoryRow()
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    name = "app",
    group = "app"
)
@Composable
private fun JetCoffeePreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop, modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Preview(
    showBackground = true,
    name = "banner component",
    group = "banner"
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    name = "banner",
    group = "banner"
)
@Composable
private fun BannerPreview() {
    JetCoffeeTheme {
        Banner()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(
                category
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "category row component",
    group = "category row"
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    name = "category row",
    group = "category row"
)
@Composable
private fun CategoryRowPreview() {
    JetCoffeeTheme {
        CategoryRow()
    }
}