package com.example.quizapp.fragments.history

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.R
import com.example.quizapp.viewModel.TestResultViewModel
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_history.view.*

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
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        setHasOptionsMenu(true)
        val adapter = TestResultAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        testResultViewModel = ViewModelProvider(this).get(TestResultViewModel::class.java)
        testResultViewModel.getAllData.observe(viewLifecycleOwner, Observer { testResult -> adapter.setData(testResult) })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setView()
    }

    private fun  setView(){
        val adapter = TestResultAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        testResultViewModel = ViewModelProvider(this).get(TestResultViewModel::class.java)
        testResultViewModel.getAllData.observe(viewLifecycleOwner, Observer { testResult -> adapter.setData(testResult) })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete_option) {
            deleteAllTestResults()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllTestResults(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete all records?")
        builder.setMessage("Are you sure you want to delete all records? You will loose them forever")
        builder.setPositiveButton("Yes"){_, _ ->
            testResultViewModel.deleteAllItems()
            Toast.makeText(requireContext(), "All records deleted", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_, _ ->

        }
        builder.create().show()
    }
}