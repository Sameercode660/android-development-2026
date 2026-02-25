#!/usr/bin/env kotlin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoScreen(viewModel: TodoViewModel) {

    val todos by viewModel.todos.collectAsState()
    var inputText by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {

        Text(
            text = "My To-Do List",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Row
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Add a task") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (inputText.isNotBlank()) {
                    viewModel.addTodo(inputText)
                    inputText = ""
                }
            }) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Todo List
        LazyColumn {
            items(todos) { todo ->
                TodoItem(
                    todo = todo,
                    onDelete = { viewModel.deleteTodo(todo) },
                    onToggle = { viewModel.toggleComplete(todo) }
                )
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo, onDelete: () -> Unit, onToggle: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = todo.isCompleted,
                onCheckedChange = { onToggle() }
            )
            Text(
                text = todo.title,
                modifier = Modifier.weight(1f),
                style = if (todo.isCompleted)
                    MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = androidx.compose.ui.text.style.TextDecoration.LineThrough
                    )
                else MaterialTheme.typography.bodyLarge
            )
            TextButton(onClick = onDelete) {
                Text("Delete", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}