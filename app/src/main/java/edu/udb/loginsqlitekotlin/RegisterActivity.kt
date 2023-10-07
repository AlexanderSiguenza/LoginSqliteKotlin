package edu.udb.loginsqlitekotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)
        dbHelper = DatabaseHelper(this)

        btnRegister.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                if (registerUser(username, password)) {
                    Toast.makeText(this@RegisterActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    // Puedes realizar alguna acción adicional después del registro exitoso.
                    finish() // Cierra la actividad de registro y vuelve a la pantalla de inicio de sesión.
                } else {
                    Toast.makeText(this@RegisterActivity, "El registro falló", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun registerUser(username: String, password: String): Boolean {
        // Implementa la lógica para insertar un nuevo usuario en la base de datos SQLite.
        // Utiliza el dbHelper para realizar la inserción y devuelve true si el registro es exitoso.
        // De lo contrario, devuelve false.
        val userId = dbHelper.insertUser(username, password)
        return userId != -1L // Si el ID es -1, la inserción falló.
    }
}
