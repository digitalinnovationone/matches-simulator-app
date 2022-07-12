package me.dio.simulator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import me.dio.simulator.databinding.ActivityDetailBinding
import me.dio.simulator.domain.Match

class DetailActivity : AppCompatActivity() {

    object Extras {
        const val MATCH = "PARTIDA"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra() {
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.location.image).into(binding.ivPlace)
            supportActionBar?.title = it.location.name

            binding.tvDescription.text = it.description

            Glide.with(this).load(it.hostTeam.image).into(binding.ivHomeTeam)
            binding.tvHomeTeamName.text = it.hostTeam.name
            binding.rbHomeTeamStars.rating = it.hostTeam.power.toFloat()
            if (it.hostTeam.score != null) {
                binding.tvHomeTeamScore.text = it.hostTeam.score.toString()
            }

            Glide.with(this).load(it.visitorTeam.image).into(binding.ivAwayTeam)
            binding.tvAwayTeamName.text = it.visitorTeam.name
            binding.rbAwayTeamStars.rating = it.visitorTeam.power.toFloat()
            if (it.visitorTeam.score != null) {
                binding.tvAwayTeamScore.text = it.visitorTeam.score.toString()
            }
        }
    }
}