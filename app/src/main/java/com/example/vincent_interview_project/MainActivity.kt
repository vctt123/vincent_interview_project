package com.example.vincent_interview_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.vincent_interview_project.ui.theme.Vincent_interview_projectTheme
import com.example.vincent_interview_project.viewmodel.MartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vincent_interview_projectTheme {
                val viewModel: MartViewModel = hiltViewModel()
                val navController = rememberNavController()
                AppNav(navController = navController, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun AppNav(navController: NavHostController, viewModel: MartViewModel) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            MartListScreen(navController, viewModel)
        }
        composable("detail/{martId}") { backStackEntry ->
            val martId = backStackEntry.arguments?.getString("martId") ?: ""
            MartDetailScreen(martId)
        }
    }
}

@Composable
fun MartListScreen(navController: NavController, viewModel: MartViewModel) {
    val list by viewModel.martList.collectAsState()
    var query by remember { mutableStateOf("") }
    val filtered = list.filter { it.martName.contains(query, ignoreCase = true) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("賣場列表", fontSize = 20.sp)
        }

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("搜尋賣場名稱") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(filtered) { item ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("detail/${item.martId}")
                        },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = item.imageUrl,
                            contentDescription = null,
                            modifier = Modifier.size(56.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.martName, style = MaterialTheme.typography.titleMedium)
                            Text("ID: ${item.martId}", style = MaterialTheme.typography.bodySmall)
                        }
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "最愛")
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Default.ShoppingCart, contentDescription = "購物車")
                    }
                }
            }
        }
    }
}

@Composable
fun MartDetailScreen(martId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("賣場細節頁", fontSize = 20.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("賣場商品編號:", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(12.dp))
            Text(martId, style = MaterialTheme.typography.bodyLarge)
        }
    }
}