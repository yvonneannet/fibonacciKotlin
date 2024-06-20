


package com.akirachix.fibonacci

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.fibonacci.databinding.ActivityMainBinding
import com.example.fibbonacci.FibonacciRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fibonacciGenerator = FibonacciGenerator()
        val fibonacciNumbers = fibonacciGenerator.getFibonacciseries(100)
        binding.rvFibonacci.layoutManager = LinearLayoutManager(this)
        val fibonacciAdapter = FibonacciRecyclerViewAdapter(fibonacciNumbers)
        binding.rvFibonacci.adapter = fibonacciAdapter
    }
}

class FibonacciGenerator {
    fun getFibonacciseries(x: Int): List<Int> {
        var sequenceFib = mutableListOf(0, 1)
        var initialNum = 0
        var newNum = 1
        while (sequenceFib.size < x) {
            val sum = initialNum + newNum
            if (sum < 0) {
                break
            }
                sequenceFib.add(sum)
            initialNum = newNum
            newNum = sum
        }
        return sequenceFib
    }
}



