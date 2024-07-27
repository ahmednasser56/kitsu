package com.abc.kitsu.presentation.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel : ViewModel() {

    protected val errorFlow = MutableSharedFlow<String>()
    val error = errorFlow.asSharedFlow()

    protected val errorStringIdFlow = MutableSharedFlow<Int>()
    val errorStringId = errorStringIdFlow.asSharedFlow()
}