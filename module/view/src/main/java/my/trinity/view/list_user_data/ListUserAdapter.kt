package my.trinity.view.list_user_data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import my.trinity.domain.model.UserDataModel
import my.trinity.test.module.view.databinding.ListItemBinding

class ListUserAdapter(val callback: (UserDataModel) -> Unit) :
    ListAdapter<UserDataModel, ListUserVh>(UserDataDiff) {

    object UserDataDiff : DiffUtil.ItemCallback<UserDataModel>() {
        override fun areItemsTheSame(oldItem: UserDataModel, newItem: UserDataModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: UserDataModel, newItem: UserDataModel): Boolean =
            oldItem.id == newItem.id

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserVh =
        ListUserVh(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            callback
        )

    override fun onBindViewHolder(holder: ListUserVh, position: Int) =
        holder.bind(currentList[position])
}

class ListUserVh(private val binding: ListItemBinding, val callback: (UserDataModel) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(userDataModel: UserDataModel) {
        binding.root.setOnClickListener {
            callback(userDataModel)
        }
        binding.data = userDataModel
    }
}