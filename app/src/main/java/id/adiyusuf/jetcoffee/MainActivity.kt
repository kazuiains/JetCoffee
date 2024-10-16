package id.adiyusuf.jetcoffee

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.adiyusuf.jetcoffee.model.BottomBarItem
import id.adiyusuf.jetcoffee.model.Menu
import id.adiyusuf.jetcoffee.model.dummyBestSellerMenu
import id.adiyusuf.jetcoffee.model.dummyCategory
import id.adiyusuf.jetcoffee.model.dummyMenu
import id.adiyusuf.jetcoffee.ui.components.CategoryItem
import id.adiyusuf.jetcoffee.ui.components.HomeSection
import id.adiyusuf.jetcoffee.ui.components.MenuItem
import id.adiyusuf.jetcoffee.ui.components.Search
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
    Scaffold(bottomBar = { BottomBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
        ) {
            Banner()
            HomeSection(title = stringResource(R.string.section_category),
                content = { CategoryRow() })
            HomeSection(stringResource(R.string.section_best_seller_menu), Modifier, {
                MenuRow(dummyMenu)
            })
            HomeSection(stringResource(R.string.section_best_seller_menu)) {
                MenuRow(dummyBestSellerMenu)
            }
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(
                category
            )
        }
    }
}

@Composable
fun MenuRow(listMenu: List<Menu>, modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu)
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.background, modifier = modifier) {
        val navigationItems = listOf(
            BottomBarItem(
                title = stringResource(R.string.menu_home), icon = Icons.Default.Home
            ), BottomBarItem(
                title = stringResource(R.string.menu_favorite), icon = Icons.Default.Favorite
            ), BottomBarItem(
                title = stringResource(R.string.menu_profile), icon = Icons.Default.AccountCircle
            )
        )
        navigationItems.map {
            NavigationBarItem(icon = {
                Icon(imageVector = it.icon, contentDescription = it.title)
            }, label = {
                Text(it.title)
            }, selected = it.title == navigationItems[0].title, onClick = { })
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    name = "app",
    group = "app"
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "app",
    group = "app"
)
@Composable
private fun JetCoffeePreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}

@Preview(
    showBackground = true, name = "banner component", group = "banner"
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

@Preview(
    showBackground = true, name = "category row component", group = "category row"
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

@Preview(
    showBackground = true, name = "menu row component", group = "menu row"
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    name = "menu row",
    group = "menu row"
)
@Composable
private fun MenuRowPreview() {
    JetCoffeeTheme {
        MenuRow(dummyMenu)
    }
}

@Preview(
    showBackground = true,
    name = "bottom bar component",
    group = "bottom bar"
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    name = "bottom bar",
    group = "bottom bar"
)
@Composable
private fun BottomBarPreview() {
    JetCoffeeTheme {
        BottomBar()
    }
}