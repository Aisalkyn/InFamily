package com.example.nestana.infamily.categories.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Category
import kotlinx.android.synthetic.main.item_category.view.*

/**
 * Created by admin on 24.03.2018.
 */

class CategoryAdapter(var mCategoryList: List<Category>,
                      val mListener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){


    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindGood(mCategoryList[position], mListener!!)
    }

    fun setList(list: List<Category>) {
        mCategoryList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent!!.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mCategoryList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindGood(category: Category, listener: OnItemClickListener) {
            itemView.tvCategoryTitle.text = category.title

            itemView.setOnClickListener {
                listener.onItemClick(category)
            }
        }
    }
}