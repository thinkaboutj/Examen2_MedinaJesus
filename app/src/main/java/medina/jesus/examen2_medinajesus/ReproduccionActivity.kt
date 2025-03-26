package medina.jesus.examen2_medinajesus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReproduccionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproduccion)

        val cancion = intent.getSerializableExtra("cancion") as Cancion

        val tvNombreReproduccion = findViewById<TextView>(R.id.tvNombreReproduccion)
        tvNombreReproduccion.text = "Reproduciendo: ${cancion.nombre}"

        val btnStop = findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener {
            val intent = Intent(this, DetalleCancionActivity::class.java)
            intent.putExtra("cancion", cancion)
            startActivity(intent)
            finish()
        }
    }
}
