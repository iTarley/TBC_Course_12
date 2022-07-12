package com.example.tbc_course_12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_course_12.databinding.GridLayoutBinding
import com.example.tbc_course_12.diffUtil.MyDiffUtil
import com.example.tbc_course_12.models.ClothesContent

class RecyclerAdapterContent(private var content: List<ClothesContent>) :
    RecyclerView.Adapter<RecyclerAdapterContent.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterContent.ViewHolder =
        ViewHolder(
            GridLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: RecyclerAdapterContent.ViewHolder, position: Int) {
        holder.bind()

    }

    override fun getItemCount(): Int {
        return content.size
    }

    fun setData(newPersonList: List<ClothesContent>) {
        val diffUtil = MyDiffUtil(oldList = content, newList = newPersonList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        content = newPersonList
        diffResults.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: GridLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentItem: ClothesContent
        fun bind() {
            currentItem = content[adapterPosition]
            binding.apply {
                appCompatImageView.setImageResource(currentItem.image)
                priceTextView.text = currentItem.price
                titleTextView.text = currentItem.title
            }
        }
    }

}