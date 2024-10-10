package id.adiyusuf.jetcoffee.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.adiyusuf.jetcoffee.ui.theme.JetCoffeeTheme

@Composable
fun Counter(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        var count by rememberSaveable { mutableStateOf(0) }
        Text("Button clicked $count times:")
        Button(onClick = { count++ }) {
            Text("Click me!")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(
        count = count,
        onClick = { count++ },
        modifier = modifier,
    )
}

@Composable
fun StatelessCounter(
    count: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Text("Button clicked $count times:")
        Button(onClick = { onClick() }) {
            Text("Click Me!")
        }
    }
}

@Preview(
    name = "basic",
    group = "basic",
    showBackground = true
)
@Composable
fun CounterPreview() {
    JetCoffeeTheme {
        Counter()
    }
}

@Preview(
    name = "stateful",
    group = "stateful",
    showBackground = true
)
@Composable
fun StatefulCounterPreview() {
    JetCoffeeTheme {
        StatefulCounter()
    }
}

