package medina.jesus.examen2_medinajesus

import CancionAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var btnAgregar: Button

    private val listaCanciones = mutableListOf(
        // Canciones de Twice
        Cancion("Basics", "Twice", "3:20", "Between 1&2"),
        Cancion("Fancy", "Twice", "3:30", "Fancy You"),
        Cancion("Moonlight", "Twice", "3:30", "Formula of love"),
        Cancion("Feel Special", "Twice", "3:30", "Feel Special"),
        Cancion("Dive", "Twice", "3:30", "Dive"),
        Cancion("I Got You", "Twice", "3:30", "With YOU-th"),

        // Canciones de TXT
        Cancion("Ghosting", "TXT", "3:00", "Minisode1: Blue Hour"),
        Cancion("Heaven", "TXT", "3:20", "The Star Chapter: SANCTUARY"),
        Cancion("Run Away", "TXT", "3:45", "The Dream Chapter: MAGIC"),
        Cancion("Miracle", "TXT", "3:30", "Minisode 3: TOMORROW"),
        Cancion("quarter life crisis", "TXT", "3:40", "Minisode 3: TOMORROW"),
        Cancion("Sugar Rush Ride", "TXT", "3:50", "The Name Chapter: TEMPTATION"),

        // Canciones de Wave to Earth
        Cancion("Wave", "Wave to Earth", "4:00", "0.1 Flaws and all"),
        Cancion("Light", "Wave to Earth", "3:50", "0.1 Flaws and all"),
        Cancion("Seasons", "Wave to Earth", "4:10", "0.1 Flaws and all"),
        Cancion("Surf.", "Wave to Earth", "4:00", "Summer Flows 0.02"),
        Cancion("Ride", "Wave to Earth", "3:30", "Summer Flows 0.02"),
        Cancion("Annie.", "Wave to Earth", "3:50", "Play with Earth! 0.03")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridViewCanciones)
        btnAgregar = findViewById(R.id.btnAgregar)

        gridView.setOnItemClickListener { parent, view, position, id ->
            val cancionSeleccionada = listaCanciones[position]

            val intent = Intent(this, DetalleCancionActivity::class.java)
            intent.putExtra("cancion", cancionSeleccionada)

            startActivity(intent)
        }

        val adapter = CancionAdapter(this, listaCanciones)  // Pasamos solo las canciones
        gridView.adapter = adapter

        btnAgregar.setOnClickListener {
            val intent = Intent(this, AgregarCancionActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val nuevaCancion = data?.getSerializableExtra("nuevaCancion") as? Cancion
            if (nuevaCancion != null) {
                listaCanciones.add(nuevaCancion)
                (gridView.adapter as CancionAdapter).notifyDataSetChanged()
            }
        }
    }
}
