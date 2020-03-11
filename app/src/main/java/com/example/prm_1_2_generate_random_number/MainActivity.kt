package com.example.prm_1_2_generate_random_number

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validateAndDrawRandomNumber(view: View) {
        val inputText: TextView = findViewById(R.id.enter_number_field)
        if (inputText.text.isNullOrEmpty()) {
            showToastOnInvalidInput()
            return
        }

        val inputNumber = Integer.parseInt(inputText.text.toString())
        if (inputNumber !in 1..100) {
            showToastOnInvalidInput()
            return
        }

        val randomNumber: Int = Random.nextInt(1, 100)
        if (randomNumber == inputNumber) {
            showWinText(randomNumber)
        } else {
            showLoseText(randomNumber)
        }
    }

    private fun showToastOnInvalidInput() {
        Toast.makeText(
            applicationContext,
            "Please enter number in range 1 - 100 and click button again",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showWinText(randomNumber: Int) {
        val bigWinLoseText: TextView = findViewById(R.id.win_lose_text)
        val smallWinLoseText: TextView = findViewById(R.id.under_win_lose_text)

        bigWinLoseText.text = getString(R.string.big_congrats)
        smallWinLoseText.text = String.format(getString(R.string.small_congrats), randomNumber)
    }

    private fun showLoseText(randomNumber: Int) {
        val bigWinLoseText: TextView = findViewById(R.id.win_lose_text)
        val smallWinLoseText: TextView = findViewById(R.id.under_win_lose_text)

        bigWinLoseText.text = getString(R.string.big_OhNo)
        smallWinLoseText.text = String.format(getString(R.string.small_OhNo), randomNumber)
    }
}
