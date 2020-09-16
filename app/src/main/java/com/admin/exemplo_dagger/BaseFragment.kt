package com.admin.exemplo_dagger

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import java.util.zip.Inflater
import javax.inject.Inject
import javax.inject.Named

/**

 */

public abstract class BaseFragment<V : ViewModel> : Fragment() {

    @Inject
    @Named("viewModelFactory")
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: V

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun getViewModel(): Class<V>
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory!!).get(getViewModel())
        sharedPref = requireActivity().getSharedPreferences("App", 0)

    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

}
