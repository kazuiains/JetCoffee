package id.adiyusuf.jetcoffee.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.adiyusuf.jetcoffee.ui.theme.JetCoffeeTheme

@Composable
fun HomeSection(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier) {
        SectionText(title, modifier)
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeSectionPreview() {
    JetCoffeeTheme {
        HomeSection("The Best") {
        }
    }
}