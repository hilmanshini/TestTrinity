package my.trinity.application.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import my.trinity.test.app.R
import my.trinity.test.app.databinding.RootBinding


@AndroidEntryPoint
class RootActivity : AppCompatActivity() {
    private lateinit var rootBinding: RootBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootBinding = DataBindingUtil.setContentView(this, R.layout.root)
    }
}