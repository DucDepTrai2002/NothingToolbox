package dev.nothing.toolbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NothingToolboxApp() }
    }
}

private data class ToolboxFeature(val title: String, val description: String, val icon: ImageVector)

@Composable
private fun NothingToolboxApp() {
    val features = listOf(
        ToolboxFeature("Patch Workspace", "Import and inspect DEX / JAR files", Icons.Default.Build),
        ToolboxFeature("Module Manager", "View module and script workflow", Icons.Default.Extension),
        ToolboxFeature("Device Properties", "Review device properties tools", Icons.Default.Settings),
        ToolboxFeature("Performance", "Game and performance utilities", Icons.Default.Speed),
        ToolboxFeature("Logs", "Operation history and diagnostics", Icons.Default.List),
        ToolboxFeature("Settings", "App preferences", Icons.Default.Tune)
    )
    MaterialTheme(colorScheme = darkColorScheme()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("NOTHING TOOLBOX") },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Device overview", style = MaterialTheme.typography.titleLarge)
                        Text("Root status: Not checked", style = MaterialTheme.typography.bodyLarge)
                        Text("This starter UI does not run privileged commands yet.", style = MaterialTheme.typography.bodyMedium)
                    }
                }
                Text("TOOLS", style = MaterialTheme.typography.labelLarge)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(features) { feature ->
                        FeatureCard(feature)
                    }
                }
            }
        }
    }
}

@Composable
private fun FeatureCard(feature: ToolboxFeature) {
    Card(
        modifier = Modifier.height(142.dp).fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        onClick = { /* Feature screen will be implemented in next milestone. */ }
    ) {
        Column(
            Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Icon(feature.icon, contentDescription = feature.title, tint = MaterialTheme.colorScheme.primary)
            Text(feature.title, style = MaterialTheme.typography.titleMedium)
            Text(feature.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}
