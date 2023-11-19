package com.example.task10views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task10views.data.UserOptions
import com.example.task10views.databinding.UserOptionItemLogoutBinding
import com.example.task10views.databinding.UserOptionItemNormalBinding
import com.example.task10views.databinding.UserOptionItemSelectorBinding
import com.example.task10views.databinding.UserOptionItemToggleBinding

class UserOptionsAdapter(var optionsList: List<UserOptions>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_NORMAL = 1
    private val VIEW_TYPE_LOGOUT = 2
    private val VIEW_TYPE_TOGGLE = 3
    private val VIEW_TYPE_SELECTOR = 4

    inner class UserOptionNormalViewHolder(val binding: UserOptionItemNormalBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class UserOptionLogoutViewHolder(val binding: UserOptionItemLogoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class UserOptionToggleViewHolder(val binding: UserOptionItemToggleBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class UserOptionSelectorViewHolder(val binding: UserOptionItemSelectorBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val binding = UserOptionItemNormalBinding.inflate(inflater, parent, false)
                UserOptionNormalViewHolder(binding)
            }

            VIEW_TYPE_LOGOUT -> {
                val binding = UserOptionItemLogoutBinding.inflate(inflater, parent, false)
                UserOptionLogoutViewHolder(binding)
            }

            VIEW_TYPE_TOGGLE -> {
                val binding = UserOptionItemToggleBinding.inflate(inflater, parent, false)
                UserOptionToggleViewHolder(binding)
            }

            VIEW_TYPE_SELECTOR -> {
                val binding = UserOptionItemSelectorBinding.inflate(inflater, parent, false)
                UserOptionSelectorViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentOption = optionsList[position]

        when (getItemViewType(position)) {
            VIEW_TYPE_NORMAL -> {
                val normalViewHolder = holder as UserOptionNormalViewHolder
                normalViewHolder.binding.ivOptionIcon.setImageResource(currentOption.optionIcon)
                normalViewHolder.binding.tvOptionTitle.text = currentOption.optionTitle
            }

            VIEW_TYPE_TOGGLE -> {
                val toggleViewHolder = holder as UserOptionToggleViewHolder
                toggleViewHolder.binding.ivOptionIcon.setImageResource(currentOption.optionIcon)
                toggleViewHolder.binding.tvOptionTitle.text = currentOption.optionTitle
            }

            VIEW_TYPE_SELECTOR -> {
                val selectorViewHolder = holder as UserOptionSelectorViewHolder
                selectorViewHolder.binding.ivOptionIcon.setImageResource(currentOption.optionIcon)
                selectorViewHolder.binding.tvOptionTitle.text = currentOption.optionTitle
                selectorViewHolder.binding.tvSelectedValue.text = currentOption.optionSelector
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return optionsList[position].viewType.ordinal + 1
    }

    override fun getItemCount(): Int {
        return optionsList.size
    }
}