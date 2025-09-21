package com.losingtime.eventhoy

import com.losingtime.eventhoy.di.appModule
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module { includes(appModule) }
