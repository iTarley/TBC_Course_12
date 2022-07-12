package com.example.tbc_course_12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_course_12.databinding.CardLayoutBinding
import com.example.tbc_course_12.models.Category

typealias onClick = (category: Category) -> Unit

class RecyclerAdapterCategory : RecyclerView.Adapter<RecyclerAdapterCategory.ViewHolder>() {


    lateinit var onClick: onClick

    private val content = Category.values().toList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterCategory.ViewHolder = ViewHolder(
        CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: RecyclerAdapterCategory.ViewHolder, position: Int) {


        holder.bind()

    }

    override fun getItemCount(): Int {
        return content.size
    }


    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentItem: Category
        fun bind() {
            currentItem = content[adapterPosition]
            binding.apply {
                categoryView.text = currentItem.categoryName
                root.setOnClickListener {
                    onClick(
                        currentItem
                    )
                }
            }

        }
    }

}