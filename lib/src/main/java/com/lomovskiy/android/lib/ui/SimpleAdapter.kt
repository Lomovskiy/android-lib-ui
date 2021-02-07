package com.lomovskiy.android.lib.ui

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    abstract val differ: AsyncListDiffer<T>

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(items: List<T>) {
        differ.submitList(items)
    }

}
