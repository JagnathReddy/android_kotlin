package com.example.list

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    listViewModel: ListViewModel= viewModel()
){
    NavHost(navController = navController,
    startDestination = Screen.Home.route){
        composable(
            route = Screen.Home.route
        ){
            home(navController=navController)
        }
        composable(
            route = Screen.Atten.route
        ){
            mainscreen(navController = navController, listViewModel = listViewModel)
        }
        composable(
            route=Screen.option.route
        ){
            showoption(navController = navController, listViewModel = listViewModel)
        }
        composable(
            route=Screen.ShowList.route
        ){
            val context = LocalContext.current
            showdetails(navController = navController, listViewModel = listViewModel,

                onSendButtonClicked = { subject: String, summary: String ->
                    shareOrder(context, subject = subject, summary = summary)

                }
                )

        }
    }

}

private fun shareOrder(context: Context, subject: String, summary: String) {
    // Create an ACTION_SEND implicit intent with order details in the intent extras
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.app_name)
        )
    )
}
