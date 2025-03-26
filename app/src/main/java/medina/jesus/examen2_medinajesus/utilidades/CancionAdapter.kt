import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import medina.jesus.examen2_medinajesus.Cancion
import medina.jesus.examen2_medinajesus.R
import kotlin.random.Random

class CancionAdapter(private val context: Context, private val canciones: List<Cancion>) : BaseAdapter() {

    private val coloresAsignados = mutableMapOf<Int, Int>() // HashMap para almacenar colores por posición

    private fun obtenerColorAleatorio(): Int {
        val colors = arrayOf(
            ContextCompat.getColor(context, R.color.red),
            ContextCompat.getColor(context, R.color.yellow),
            ContextCompat.getColor(context, R.color.Gray)
        )
        return colors[Random.nextInt(colors.size)]
    }

    override fun getCount(): Int {
        return canciones.size
    }

    override fun getItem(position: Int): Any {
        return canciones[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_cancion, parent, false)
        }

        val tvNombre = view?.findViewById<TextView>(R.id.tvNombre)
        val tvArtista = view?.findViewById<TextView>(R.id.tvArtista)

        val cancion = getItem(position) as Cancion
        tvNombre?.text = cancion.nombre
        tvArtista?.text = cancion.artista

        // Si no se ha asignado un color previamente, asigna uno aleatorio
        if (!coloresAsignados.containsKey(position)) {
            val colorAleatorio = obtenerColorAleatorio()
            coloresAsignados[position] = colorAleatorio
        }

        // Establece el color de fondo de la celda con el color asignado
        view?.setBackgroundColor(coloresAsignados[position] ?: 0)

        return view!!
    }
}
