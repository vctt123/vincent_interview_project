package com.example.vincent_interview_project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vincent_interview_project.usecase.LoadMartListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MartViewModel @Inject constructor(
    private val useCase: LoadMartListUseCase
) : ViewModel() {
    val martList = useCase().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        viewModelScope.launch { useCase.refresh() }
    }
}