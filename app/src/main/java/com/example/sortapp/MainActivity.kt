package com.example.sortapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.buttonSort)
        val groupSort = findViewById<RadioGroup>(R.id.groupSort)
        val groupSize = findViewById<RadioGroup>(R.id.groupSize)

        button.setOnClickListener{
            var size = 0
            when(groupSize.checkedRadioButtonId) {
                R.id.radioButtonXS -> {
                    val elapsedTime = measureTimeMillis {
                        size = 10
                    }
                }
                R.id.radioButtonS -> {
                    val elapsedTime = measureTimeMillis {
                        size = 100
                    }
                }
                R.id.radioButtonM -> {
                    val elapsedTime = measureTimeMillis {
                        size = 1000
                    }
                }
                R.id.radioButtonL -> {
                    val elapsedTime = measureTimeMillis {
                        size = 10000
                    }
                }
                R.id.radioButtonXL -> {
                    val elapsedTime = measureTimeMillis {
                        size = 100000
                    }
                }
                R.id.radioButtonXXL -> {
                    val elapsedTime = measureTimeMillis {
                        size = 1000000
                    }
                }
            }
            val array = Array<Int>(size) { i -> Random.nextInt(0, 10000) }
            var elapsedTime: Long? = 0
            when(groupSort.checkedRadioButtonId) {
                R.id.radioButtonBubble -> {
                    elapsedTime = measureTimeMillis {
                        Sort().bubbleSort(array)
                    }
                }
                R.id.radioButtonShaker -> {
                    elapsedTime = measureTimeMillis {
                        Sort().shakerSort(array)
                    }
                }
                R.id.radioButtonComb -> {
                    elapsedTime = measureTimeMillis {
                        Sort().combSort(array)
                    }
                }
                R.id.radioButtonInsertion -> {
                    elapsedTime = measureTimeMillis {
                        Sort().insertionSort(array)
                    }
                }
                R.id.radioButtonGnome -> {
                    elapsedTime = measureTimeMillis {
                        Sort().gnomeSort(array)
                    }
                }
                R.id.radioButtonQuick -> {
                    elapsedTime = measureTimeMillis {
                        Sort().quickSort(array)
                    }
                }
                R.id.radioButtonBogo -> {
                    elapsedTime = measureTimeMillis {
                        Sort().bogoSort(array)
                    }
                }
                R.id.radioButtonStd -> {
                    elapsedTime = measureTimeMillis {
                        array.sort()
                    }
                }
            }
            text.text = "Time: $elapsedTime ms"
        }


    }
}