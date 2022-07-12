package com.example.tbc_course_12.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.tbc_course_12.models.ClothesContent

class MyDiffUtil(
    private val oldList: List<ClothesContent>,
    private val newList: List<ClothesContent>
):DiffUtil.Callback(

) {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].image == newList[newItemPosition].image
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].image != newList[newItemPosition].image -> {
                false
            }
            oldList[oldItemPosition].title != newList[newItemPosition].title -> {
                false
            }
            oldList[oldItemPosition].price != newList[newItemPosition].price -> {
                false
            }
            oldList[oldItemPosition].categoryType != newList[newItemPosition].categoryType -> {
                false
            }
            else -> true


        }
    }
}