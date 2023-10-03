package com.example.temperatureconverter

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.temperatureconverter.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rootView: View = findViewById(android.R.id.content)

        binding.celsiusSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                binding.celsiusValueTextView.text = (seekBar.progress/100.00).toString()
                binding.fahrenheitSeekbar.progress = (Converter().convertToFahrenheit(seekBar.progress.toDouble()/100.0) *100).toInt()
                if(seekBar.progress <= 2000)
                    Snackbar.make(rootView, R.string.warmSnackbar, Snackbar.LENGTH_SHORT).show()
                else
                    Snackbar.make(rootView, R.string.coldSnackbar, Snackbar.LENGTH_SHORT).show()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.fahrenheitSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if(seekBar.progress<3200)
                    seekBar.progress = 3200
                binding.fahrenheitValueTextView.text = (seekBar.progress/100.00).toString()
                binding.celsiusSeekbar.progress = (Converter().convertToCelsius(seekBar.progress.toDouble()/100.0)*100).toInt()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }
}

