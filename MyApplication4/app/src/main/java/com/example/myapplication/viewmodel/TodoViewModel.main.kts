#!/usr/bin/env kotlin


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    val todos = repository.allTodos.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addTodo(title: String) {
        viewModelScope.launch {
            repository.insertTodo(Todo(title = title))
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
        }
    }

    fun toggleComplete(todo: Todo) {
        viewModelScope.launch {
            repository.updateTodo(todo.copy(isCompleted = !todo.isCompleted))
        }
    }
}