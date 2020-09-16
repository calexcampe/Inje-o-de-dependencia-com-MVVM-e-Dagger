package com.admin.exemplo_dagger.di.module

import androidx.lifecycle.ViewModel
import com.admin.exemplo_dagger.HistoryPayServicesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(HistoryPayServicesViewModel::class)
    abstract fun hstoryPayServicesViewModel(hstoryPayServicesViewModel: HistoryPayServicesViewModel): ViewModel

}