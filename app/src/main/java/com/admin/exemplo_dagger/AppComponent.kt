package com.admin.exemplo_dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * O componente principal da aplicação que inicializa todos os módulos dependentes
 * */

@Singleton
@Component(modules = [AndroidInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(ExemploDaggerApplication : ExemploDaggerApplication)
}