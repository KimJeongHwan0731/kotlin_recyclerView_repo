package com.example.recyclerviewproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.databinding.ItemViewBinding

// 3. customAdapter를 설계한다.
class CustomAdapter(val dataList: MutableList<DataList>): RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    //lateinit var context: Context
    // 6. 아이템뷰를 객체화시킨다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemViewBinding: ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //context = parent.context
        return CustomViewHolder(itemViewBinding)
    }

    // 5. 사이즈 설정
    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewBinding = holder.itemViewBinding
        itemViewBinding.tvName.text = dataList.get(position).tvName
        itemViewBinding.tvAge.text = dataList.get(position).tvAge
        itemViewBinding.tvEmail.text = dataList.get(position).tvEmail
        itemViewBinding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        itemViewBinding.root.setOnClickListener {
            Log.e("CustomAdapter", "${itemViewBinding.tvName.text}")
            Toast.makeText(itemViewBinding.root.context, "${itemViewBinding.tvName.text}", Toast.LENGTH_SHORT).show()
        }
    }

    // 4. viewHolder집기 위해 내부클래스를 만든다.
    class CustomViewHolder(val itemViewBinding: ItemViewBinding): RecyclerView.ViewHolder(itemViewBinding.root)
}
