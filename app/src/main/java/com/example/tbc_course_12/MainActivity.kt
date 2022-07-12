package com.example.tbc_course_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import com.example.tbc_course_12.adapter.RecyclerAdapterCategory
import com.example.tbc_course_12.adapter.RecyclerAdapterContent
import com.example.tbc_course_12.databinding.ActivityMainBinding
import com.example.tbc_course_12.models.Category
import com.example.tbc_course_12.models.ClothesContent
import com.example.tbc_course_12.models.Content
import java.util.Locale.filter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val categoryAdapter by lazy {
        RecyclerAdapterCategory()
    }
    private val contentAdapter by lazy {
        RecyclerAdapterContent(Content.clothesContent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.categoryRecycler.adapter = categoryAdapter
        binding.contentRecycler.adapter = contentAdapter

        categoryAdapter.onClick = {
            setUpCategory(it)
        }

    }

    private fun setUpCategory(categoryType: Category) {
        when (categoryType) {
            Category.ALL -> contentAdapter.setData(Content.clothesContent)
            Category.PARTY -> contentAdapter.setData(Content.clothesContent.filter { it.categoryType == categoryType })
            Category.CAMPING -> contentAdapter.setData(Content.clothesContent.filter { it.categoryType == categoryType })
            Category.SPORT -> contentAdapter.setData(Content.clothesContent.filter { it.categoryType == categoryType })
            Category.CASUAL -> contentAdapter.setData(Content.clothesContent.filter { it.categoryType == categoryType })
            Category.KIDS -> contentAdapter.setData(Content.clothesContent.filter { it.categoryType == categoryType })
        }
    }
}