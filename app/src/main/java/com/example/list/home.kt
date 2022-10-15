package com.example.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

var show="class"
@Composable
fun home(
    navController: NavController
){
    val icon= painterResource(R.drawable.icon)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

    }
    Row( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = icon, contentDescription = "icon")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp)

        ) {


            Button(
                modifier=Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(route = Screen.Atten.route)
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)


            ) {
                Text(text = "ISE CLASS")


            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier=Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(route = Screen.option.route)
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text(text = "CSE CLASS")


            }
        }
        
    }
}
@Composable
@Preview(showBackground = true)
fun prehome(){
    home(
        navController = rememberNavController()
    )
}
