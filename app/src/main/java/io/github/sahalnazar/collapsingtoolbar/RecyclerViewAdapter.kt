package io.github.sahalnazar.collapsingtoolbar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.sahalnazar.collapsingtoolbar.databinding.ItemListBinding

class RecyclerViewAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolder {

        val binding = ItemListBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {


        val item = differ.currentList[position]

        with(holder) {
            binding.ivGraphic.setImageResource(item.image)
            binding.tvHeading.text = item.helloString
            binding.tvSubHeading.text = ":-)"

            binding.itemContainer.setOnClickListener {
                onItemClickListener?.let {
                    it(position)
                }
            }
        }
    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun onClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class RecyclerViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}



