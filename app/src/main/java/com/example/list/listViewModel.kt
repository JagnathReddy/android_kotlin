package com.example.list

import androidx.lifecycle.ViewModel
import com.example.list.data.OrderUiState
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.util.*

open class listViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setList(toadd:List<student>){
        _uiState.update { currentState ->
            currentState.copy(
                outList=toadd
            )
        }
    }
    fun getList(): List<student> {
        return _uiState.value.outList
    }
    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // add current date and the following 3 dates.
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
    fun addstudent(name:String){
        studentnames.add(name)
    }


}
var studentnames = mutableListOf<String>(
    "a","b","c","d"
)