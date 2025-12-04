package com.example.a086_roomdatabase.view.uicontroller

import android.R.attr.type
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a086_roomdatabase.view.DetailSiswaScreen
import com.example.a086_roomdatabase.view.EditSiswaScreen
import com.example.a086_roomdatabase.view.EntrySiswaScreen
import com.example.a086_roomdatabase.view.HomeScreen
import com.example.a086_roomdatabase.view.route.DestinasiDetailSiswa
import com.example.a086_roomdatabase.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.a086_roomdatabase.view.route.DestinasiEditSiswa
import com.example.a086_roomdatabase.view.route.DestinasiEntry
import com.example.a086_roomdatabase.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEditItem = {
                    navController.navigate("${DestinasiEditSiswa.route}/${it}")
                }
            )
        }
        composable(
            route = DestinasiEditSiswa.routeWithIdArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}