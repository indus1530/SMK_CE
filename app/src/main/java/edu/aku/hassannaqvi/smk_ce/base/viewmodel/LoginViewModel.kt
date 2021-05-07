package edu.aku.hassannaqvi.smk_ce.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.smk_ce.base.repository.GeneralDataSource
import edu.aku.hassannaqvi.smk_ce.base.repository.ResponseStatusCallbacks
import edu.aku.hassannaqvi.smk_ce.models.Users
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: GeneralDataSource) : ViewModel() {

    private val _loginResponse: MutableLiveData<ResponseStatusCallbacks<Users>> = MutableLiveData()

    val loginResponse: MutableLiveData<ResponseStatusCallbacks<Users>>
        get() = _loginResponse

    fun getLoginInfoFromDB(username: String, password: String) {
        _loginResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                val loginData = repository.getLoginInformation(username, password)
                _loginResponse.value = loginData?.let {
                    ResponseStatusCallbacks.success(data = it, "User exist")
                } ?: ResponseStatusCallbacks.error(null, "User not exist")
            } catch (e: Exception) {
                _loginResponse.value = ResponseStatusCallbacks.error(null, e.message.toString())
            }
        }
    }

}