package medina.jesus.examen2_medinajesus

import java.io.Serializable

data class Cancion(
    val nombre: String,
    val artista: String,
    val duracion: String,
    val album: String
) : Serializable
