package com.example.quizapp.fragments.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.TestResult
import kotlinx.android.synthetic.main.test_list.view.*

class TestResultAdapter: RecyclerView.Adapter<TestResultAdapter.ViewHolder>() {

    private var testResultList = emptyList<TestResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.test_list,
            parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = testResultList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = testResultList[position]
        holder.date.text = currentItem.date
        holder.username.text = currentItem.username
        holder.score.text = currentItem.score.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val date: TextView = itemView.date_text_view
        val username: TextView = itemView.username_textView
        val score: TextView = itemView.score_textView
    }

    fun setData(testResult: List<TestResult>){
        this.testResultList = testResult
        notifyDataSetChanged()
    }
}