package com.example.taskmanager2.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager2.databinding.ItemOnboardBinding
import com.example.taskmanager2.loadImage
import com.example.taskmanager2.models.OnBoard

class OnBoardAdapter(private val onSkip: () -> Unit) : Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    private val arrayList = arrayListOf<OnBoard>(
        OnBoard(
            "Title",
            "Desctiption",
            "https://www.chanty.com/blog/wp-content/uploads/2020/10/Task-manager-apps-scaled.jpg"
        ),
        OnBoard(
            "Title",
            "Desctiption",
            "https://www.chanty.com/blog/wp-content/uploads/2020/10/Task-manager-apps-scaled.jpg"
        ),
        OnBoard(
            "Title",
            "Desctiption",
            "https://www.chanty.com/blog/wp-content/uploads/2020/10/Task-manager-apps-scaled.jpg"
        ),

        )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardAdapter.OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardAdapter.OnBoardViewHolder, position: Int) {
        holder.OnBind()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun OnBind() {
            with(binding) {
                tvTitleOnboard.text = arrayList[position].title
                tvDescriptionOnboard.text = arrayList[position].desc
                iOnboard.loadImage(arrayList[position].image)

                btnSkip.isVisible = adapterPosition != 2
                btnStart.isVisible = adapterPosition == 2

                btnSkip.setOnClickListener {
                    onSkip()
                }
                btnStart.setOnClickListener {
                    onSkip()
                }
            }
        }

    }
}