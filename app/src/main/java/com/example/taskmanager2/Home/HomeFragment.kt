package com.example.taskmanager2.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.R
import com.example.taskmanager2.Task.TaskFragment
import com.example.taskmanager2.Adapters.TaskAdapter
import com.example.taskmanager2.databinding.FragmentHomeBinding
import com.example.taskmanager2.models.Task


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabClick()
        initAdapter()
        dataAccept()
    }

    private fun fabClick() {
        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
            println("click on")
        }
    }

    private fun initAdapter() {
        binding.recyclerViewTasks.adapter = adapter
    }

    private fun dataAccept() {
        setFragmentResultListener(TaskFragment.RESULT_REQUEST) { _, bundle ->
            val data = bundle.getSerializable(TaskFragment.RESULT_KEY) as Task
            adapter.addData(data)
        }
    }
}
