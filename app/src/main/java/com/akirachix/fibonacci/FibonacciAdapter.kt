
package com.example.fibbonacci

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.fibonacci.R

class FibonacciRecyclerViewAdapter(private val fibonacciNumbers: List<Int>) :
    RecyclerView.Adapter<FibonacciRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.number_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fibonacciNumbers[position])
    }

    override fun getItemCount(): Int {
        return fibonacciNumbers.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.fibonacci_text_view)

        fun bind(fibonacciNumber: Int) {
            textView.text = fibonacciNumber.toString()
        }
    }
}