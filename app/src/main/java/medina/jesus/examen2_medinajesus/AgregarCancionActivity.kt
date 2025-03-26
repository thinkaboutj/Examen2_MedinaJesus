package medina.jesus.examen2_medinajesus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AgregarCancionActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etArtista: EditText
    private lateinit var etDuracion: EditText
    private lateinit var etAlbum: EditText
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cancion)

        etNombre = findViewById(R.id.etNombre)
        etArtista = findViewById(R.id.etArtista)
        etDuracion = findViewById(R.id.etDuracion)
        etAlbum = findViewById(R.id.etAlbum)
        btnGuardar = findViewById(R.id.btnGuardar)

        btnGuardar.setOnClickListener {

            val nombre = etNombre.text.toString()
            val artista = etArtista.text.toString()
            val duracion = etDuracion.text.toString()
            val album = etAlbum.text.toString()

            // Crear un nuevo objeto Cancion
            val nuevaCancion = Cancion(nombre, artista, duracion, album)

            // Enviar la nueva canción a la MainActivity
            val intent = Intent()
            intent.putExtra("nuevaCancion", nuevaCancion)
            setResult(RESULT_OK, intent)

            finish()
        }
    }
}
