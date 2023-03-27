package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dataList: MutableList<DataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. mutable 데이터 리스트를 만들어서 adapter에 제공
        dataList = mutableListOf<DataList>()
        for (i in 1..30) {
            if(i % 2 == 0) {
                dataList.add(DataList("홍길동${i}", "${20+i}세", "abcd${i}@mmmm.com", R.drawable.man))
            } else {
                dataList.add(DataList("홍길녀${i}", "${20+i}세", "abcd${i}@mmmm.com", R.drawable.woman))
            }
        }

        // 2. CustomAdapter에 DataList 제공
        val customAdapter = CustomAdapter(dataList)

        // 3. RecyclerView에 Adapter 적용
        binding.recyclerView.adapter = customAdapter
        // 4. layoutmanager를 통해서 recyclerView의 방향 설정
        val layoutManager = LinearLayoutManager(this)
        //val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
    }
}