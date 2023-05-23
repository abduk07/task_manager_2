package com.example.taskmanager2.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager2.databinding.ItemTaskBinding
import com.example.taskmanager2.models.Task

class TaskAdapter() : Adapter<TaskAdapter.TaskViewHolder>() {
    private val arrayList = ArrayList<Task>()
    fun addData(task: Task) {
        arrayList.add(0, task)
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        ViewHolder(binding.root) {
        fun onBind() {
            with(binding) {
                etTitle.text = arrayList[adapterPosition].title
                etDesc.text = arrayList[adapterPosition].desc
            }
        }

    }
}
