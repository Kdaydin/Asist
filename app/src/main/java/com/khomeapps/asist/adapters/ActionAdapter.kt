package com.khomeapps.asist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khomeapps.asist.R
import com.khomeapps.asist.databinding.ItemActionBinding
import com.khomeapps.asist.entity.Actions

/**
 * Created by kubilaay on 2019-09-07.
 */
class ActionAdapter(val actionList: List<Actions>) :
    RecyclerView.Adapter<ActionAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Actions)
    }

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = ItemActionBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = actionList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(actionList[p1])
    }

    inner class ViewHolder(val binding: ItemActionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Actions) {
            item.drawableId?.let { binding.actionIcon.setImageResource(it) }
            item.title?.let { binding.actionTitle.text = it }
            item.price?.let {
                binding.actionFooterAmount.text =
                    binding.actionFooterAmount.context.getString(R.string.tl_currency, it)
            }
            binding.actionFooter.text =
                binding.actionFooter.context.getString(R.string.starting_from)
            binding.root.setOnClickListener {
                listener?.onItemClick(item)
            }
        }

    }
}