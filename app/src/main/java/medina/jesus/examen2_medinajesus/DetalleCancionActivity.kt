package medina.jesus.examen2_medinajesus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleCancionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_cancion)

        // Recuperar la cancion desde el Intent
        val cancion = intent.getSerializableExtra("cancion") as Cancion

        val tvNombre = findViewById<TextView>(R.id.tvNombreCancion)
        val tvArtista = findViewById<TextView>(R.id.tvArtista)
        val tvDuracion = findViewById<TextView>(R.id.tvDuracion)
        val tvAlbum = findViewById<TextView>(R.id.tvAlbum)

        tvNombre.text = cancion.nombre
        tvArtista.text = cancion.artista
        tvDuracion.text = cancion.duracion
        tvAlbum.text = cancion.album

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        btnPlay.text = "Play ${cancion.nombre}"

        btnPlay.setOnClickListener {
            val intentReproduccion = Intent(this, ReproduccionActivity::class.java)
            intentReproduccion.putExtra("cancion", cancion)
            startActivity(intentReproduccion)
        }

        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
