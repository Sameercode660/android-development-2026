import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = TodoDatabase.getDatabase(this)
        val repository = TodoRepository(database.todoDao())
        val factory = TodoViewModelFactory(repository)

        setContent {
            val viewModel: TodoViewModel = viewModel(factory = factory)
            TodoScreen(viewModel = viewModel)
        }
    }
}