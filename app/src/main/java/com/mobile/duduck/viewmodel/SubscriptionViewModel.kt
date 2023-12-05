package com.mobile.duduck.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.duduck.model.Subscription
import com.mobile.duduck.service.ApiService
import kotlinx.coroutines.launch
import java.net.ConnectException

class SubscriptionViewModel(private val apiService: ApiService) : ViewModel() {
    private val _subscriptions = MutableLiveData<List<Subscription>>(emptyList())
    val subscriptions: LiveData<List<Subscription>> get() = _subscriptions

    init {
        viewModelScope.launch {
            try {
                _subscriptions.value = apiService.getAllSubscriptions()
            } catch (e: ConnectException) {
                Log.e("SubscriptionViewModel", e.message.toString())
                e.printStackTrace()
            }
        }
    }
}