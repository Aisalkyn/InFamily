package com.example.nestana.infamily.ui.check_document_list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Document
import kotlinx.android.synthetic.main.item_document.view.*

/**
 * Created by admin on 24.03.2018.
 */
class DocumentAdapter(var mDocumentList: List<Document>,
                      val mListener: OnItemClickListener) : RecyclerView.Adapter<DocumentAdapter.ViewHolder>(){


    interface OnItemClickListener {
        fun onItemClick(document: Document)
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindGood(mDocumentList[position], mListener)
    }

    fun setList(list: List<Document>) {
        mDocumentList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent!!.context).inflate(R.layout.item_document, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mDocumentList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindGood(document: Document, listener: OnItemClickListener) {
            itemView.tvDocumentTitle.text = document.title

            itemView.setOnClickListener {
                listener.onItemClick(document)
            }
        }
    }
}