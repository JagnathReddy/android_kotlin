package com.example.list

import androidx.lifecycle.ViewModel
import com.example.list.data.OrderUiState
import kotlinx.coroutines.flow.*

open class ListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

   fun set_data(new_data:String){
       _uiState.update { currentState ->
           currentState.copy(
               student_data = new_data
           )
       }
   }
    fun get_data():String{
        return _uiState.value.student_data.toString()
    }
}