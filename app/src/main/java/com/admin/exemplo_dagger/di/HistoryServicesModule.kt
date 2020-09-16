package com.admin.exemplo_dagger.di
import com.admin.exemplo_dagger.HistoryServicesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class HistoryServicesModule {

    @ContributesAndroidInjector
    abstract fun historyServicesFragment(): HistoryServicesFragment



}