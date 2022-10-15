package com.example.list
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun mainscreen(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
    navController: NavController,
){
        var items by remember {
            mutableStateOf(
                (0..60).map {
                    student(
                        name = names[it],
                        present = false
                    )
                }
            )

        }

        var totalPresent=items.filter { it.present }
    var totalabsent=items.filter { !it.present }
    var strname=""
    var strabsent=""
    totalPresent.forEach(){
            strname+=it.name+"|"

    }
    strname+="&"
    totalabsent.forEach(){
        strname+=it.name+"|"
    }
    strabsent=strname
    Log.d(TAG,"thisis final"+strabsent)
    Log.d(TAG, "mainscreen: ${strabsent}===========================")

    Column(
        modifier=Modifier.fillMaxSize()
    ) {

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            OutlinedButton(modifier = Modifier.weight(1f), onClick = { popback(navController) }) {
                Text(text = "cancel")
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                enabled = true,
                onClick = { navController.navigate(route = Screen.ShowList.route+"$strabsent")}
            ) {
                Text(text = "Next")
            }

}
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(items.size) { i ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            items = items.mapIndexed { j, item ->
                                if (i == j) {
                                    item.copy(present = !item.present)
                                } else item
                            }
                        }
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = names[i])
                    if (items[i].present) {
                        Text(text = "Marked Present")
                    }
                }
            }
        }
    
    }
    }
fun popback(navController: NavController){
    navController.popBackStack()

}



