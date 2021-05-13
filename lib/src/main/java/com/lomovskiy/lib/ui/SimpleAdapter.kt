package com.lomovskiy.lib.ui

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

@Deprecated("Use [androidx.recyclerview.widget.ListAdapter] instead")
abstract class SimpleAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    abstract val differ: AsyncListDiffer<T>

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(items: List<T>) {
        differ.submitList(items)
    }

}
