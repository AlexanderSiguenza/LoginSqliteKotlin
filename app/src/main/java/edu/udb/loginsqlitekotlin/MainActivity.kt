package edu.udb.loginsqlitekotlin


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        dbHelper = DatabaseHelper(this)
        Toast.makeText(this@MainActivity, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
    }

}
