package com.example.prm_1_2_generate_random_number

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomNumber = Random.nextInt(1, 100)
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

        if (randomNumber == inputNumber) {
            showWinText()
        } else {
            showLoseText(inputNumber)
        }
    }

    private fun showToastOnInvalidInput() {
        Toast.makeText(
            applicationContext,
            "Please enter number in range 1 - 100 and click button again",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showWinText() {
        val bigWinLoseText: TextView = findViewById(R.id.win_lose_text)
        val smallWinLoseText: TextView = findViewById(R.id.under_win_lose_text)

        bigWinLoseText.text = getString(R.string.big_congrats)
        smallWinLoseText.text = String.format(getString(R.string.small_congrats), randomNumber)
    }

    private fun showLoseText(inputNumber: Int) {
        val bigWinLoseText: TextView = findViewById(R.id.win_lose_text)
        val smallWinLoseText: TextView = findViewById(R.id.under_win_lose_text)
        bigWinLoseText.text = getString(R.string.big_OhNo)

        if (randomNumber > inputNumber) {
            smallWinLoseText.text =
                String.format(getString(R.string.small_OhNoItsBigger), inputNumber)
        } else {
            smallWinLoseText.text =
                String.format(getString(R.string.small_OhNoItsSmaller), inputNumber)
        }
    }
}
