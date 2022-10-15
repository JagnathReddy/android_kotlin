package com.example.list

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*


var list2= listOf(
    "Student A",
    "Student b",
    "Student q",
    "Student w",
    "Student e",
    "Student r",
    "Student t",
    "Student y",
    "Student u",
    "Student i",
    "Student o",
    "Student s",
    "Student d",
    "Student f",
    "Student g",
    "Student h",
    "Student j",
    "Student k",
    "Student l",
    "Student m",
    "Student n",
    "Student v",
    "Student c",
    "Student x",

    )

@Composable

fun showdetails(
    navController: NavController,
    listViewModel: ListViewModel = viewModel(),

    onSendButtonClicked: (String, String) -> Unit,
){
    val Uistate by listViewModel.uiState.collectAsState()

    val context = LocalContext.current
    val sdf = SimpleDateFormat("'Date\n': dd-MM-yyyy ")
    Log.d(TAG, "showdetails: FINE TILL 2")

    val currentDateAndTime = sdf.format(Date()).toString()
    Log.d(TAG,"####################################################################################"+listViewModel.get_data().toString())
    var pre_Stu=listViewModel.get_data().split("&")
    Log.d(TAG,pre_Stu[0]+"aur--------------------------------"+pre_Stu[1])
    var out="Students Present \n"
    pre_Stu[0].split("|").forEach() {
        out += it + "\n"
    }
    out+="Students Absent \n"
    Log.d(TAG,pre_Stu[0]+"\n"+pre_Stu[1])
    pre_Stu[1].split("|").forEach(){
        out+=it+"\n"
    }
        Log.d(TAG, "showdetails: FINE TILL 3")
        out += currentDateAndTime
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .verticalScroll(enabled = true, state = ScrollState(0)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Surface(
                shape = RoundedCornerShape(percent = 5),
                border = BorderStroke(1.dp, Color.Gray),
                elevation = 5.dp
            ) {
                Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {}
                Text(
                    text = "Students Present", modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(top = 3.dp), textAlign = TextAlign.Center, fontSize = 30.sp
                )

            }
            pre_Stu[0].split("|").forEach(
            ) {
                Text(
                    text = it,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(400),
                    fontSize = 18.sp
                )
            }
            Surface(
                shape = RoundedCornerShape(percent = 5),
                border = BorderStroke(1.dp, Color.Gray),
                elevation = 5.dp
            ) {
                Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {}
                Text(
                    text = "Students Absent", modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(top = 3.dp), textAlign = TextAlign.Center, fontSize = 30.sp
                )

            }
        pre_Stu[1].split("|").forEach(){
            Text(text = it, fontFamily = FontFamily.Default, fontWeight = FontWeight(400), fontSize = 18.sp)

        }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        OutlinedButton(
                            modifier = Modifier.weight(1f),
                            onClick = { popback(navController) }) {
                            Text(text = "cancel")
                        }
                        Button(
                            modifier = Modifier.weight(1f),
                            // the button is enabled when the user makes a selection
                            enabled = true,
                            onClick = {
                                onSendButtonClicked("markTOgo", out)


                            }
                        ) {
                            Text(text = "Share")
                        }

                    }
                }

        }
    }

    




