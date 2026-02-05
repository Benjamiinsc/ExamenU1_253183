package mx.itson.edu.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etC = findViewById<EditText>(R.id.etC)
        val etF = findViewById<EditText>(R.id.etF)
        val etK = findViewById<EditText>(R.id.etK)

        val btnGC = findViewById<Button>(R.id.btnGC)
        val btnGF = findViewById<Button>(R.id.btnGF)
        val btnGK = findViewById<Button>(R.id.btnGK)

        btnGC.setOnClickListener {
            if (etC.text.toString().isEmpty()) {
                Toast.makeText(this, "Escribe el valor en celsius", Toast.LENGTH_SHORT).show()
            } else {
                var c = etC.text.toString().toDouble()

                var f = (c * 1.8) + 32
                var k = c + 273.15

                etF.setText(f.toString())
                etK.setText(k.toString())
            }
        }

        btnGF.setOnClickListener {
            if (etF.text.toString().isEmpty()) {
                Toast.makeText(this, "Escribe el valor en fahrenheit", Toast.LENGTH_SHORT).show()
            } else {
                var f = etF.text.toString().toDouble()

                var c = (f - 32) / 1.8
                var k = c + 273.15

                etC.setText(c.toString())
                etK.setText(k.toString())
            }
        }

        btnGK.setOnClickListener {
            if (etK.text.toString().isEmpty()) {
                Toast.makeText(this, "Escribe el valor en kelvin", Toast.LENGTH_SHORT).show()
            } else {
                var k = etK.text.toString().toDouble()

                var c = k - 273.15
                var f = (c * 1.8) + 32

                etC.setText(c.toString())
                etF.setText(f.toString())
            }
        }
    }
}