package com.example.quizapp.history

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.R
import com.example.quizapp.data.AppDatabase
import com.example.quizapp.databinding.FragmentHistoryBinding
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    private lateinit var testResultViewModel: TestResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHistoryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_history, container, false)
        setHasOptionsMenu(true)
        val adapter = TestResultAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        testResultViewModel = ViewModelProvider(this).get(TestResultViewModel::class.java)
        testResultViewModel.getAllData.observe(viewLifecycleOwner, Observer { testResult -> adapter.setData(testResult) })
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var exampleList: ArrayList<TestResult>? = null
        if (exampleList == null) {
            empty_view.visibility = View.VISIBLE
        }
        setView()
        empty_view.visibility = View.GONE
    }

    private fun  setView(){
        val adapter = TestResultAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        testResultViewModel = ViewModelProvider(this).get(TestResultViewModel::class.java)
        testResultViewModel.getAllData.observe(viewLifecycleOwner, Observer { testResult -> adapter.setData(testResult) })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete_option){
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes"){_, _ ->
                testResultViewModel.deleteAllItems()
                Toast.makeText(requireContext(), "All records deleted", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){_, _ ->

            }
            builder.setTitle("Delete all records?")
            builder.setMessage("Are you sure you want to delete all records? You will loose them forever")
            builder.create().show()
        }
        return super.onOptionsItemSelected(item)
    }
}