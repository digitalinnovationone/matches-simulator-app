package me.dio.simulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("descricao")
    val description: String,
    @SerializedName("local")
    val location: Place,
    @SerializedName("mandante")
    val hostTeam: Team,
    @SerializedName("visitante")
    val visitorTeam: Team
) : Parcelable