package my.trinity.view.save_user_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import my.trinity.domain.model.ResultFlowModel
import my.trinity.test.module.view.databinding.AddBinding
import my.trinity.view.list_user_data.ListUserViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class AddUserDataFragment @Inject constructor(

) : Fragment() {

    val vm by viewModels<AddUserDataViewModel>()
    val parentVm by activityViewModels<ListUserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = AddBinding.inflate(LayoutInflater.from(requireContext()), container, false).apply {
        this.vm = this@AddUserDataFragment.vm
        this.onDataClick = {
            val dateRangePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select dates")
                    .build()

            dateRangePicker.apply {
                addOnPositiveButtonClickListener {
                    date.setText(SimpleDateFormat("yyyy/MM/dd").format(Date(it)))
                    this@AddUserDataFragment.vm.dob.value = it.toString()
                }
            }.show(childFragmentManager, "")
        }
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            vm.result.collect {
                if (it is ResultFlowModel.Success) {
                    parentVm.refresh()
                    findNavController().popBackStack()
                }
            }
        }
        lifecycleScope.launch {
            vm.validation.collect {
                if (it.isNotEmpty()) {

                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                    vm.validation.value = ""
                }
            }
        }
    }
}