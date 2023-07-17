package my.trinity.view.list_user_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import my.trinity.domain.model.ResultFlowModel
import my.trinity.test.module.view.R
import my.trinity.test.module.view.databinding.ListBinding

@AndroidEntryPoint
class ListUserFragment : Fragment() {
    val vm by viewModels<ListUserViewModel>()
    val adapter = ListUserAdapter {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = ListBinding.inflate(LayoutInflater.from(requireContext()), container, false).apply {
        this.vm = this@ListUserFragment.vm
        this.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.add) {
                findNavController().navigate(ListUserFragmentDirections.actionListUserFragmentToAddUserDataFragment())
            }
            true
        }
        this.lifecycleOwner = viewLifecycleOwner
        this.recycler.adapter = this@ListUserFragment.adapter
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeList()
    }

    private fun observeList() {
        lifecycleScope.launch {
            vm.listResult.collect {
                when (it) {
                    is ResultFlowModel.Error -> {}
                    is ResultFlowModel.None -> {}
                    is ResultFlowModel.Success -> {
                        adapter.submitList(it.result)
                    }
                }
            }
        }
    }


}