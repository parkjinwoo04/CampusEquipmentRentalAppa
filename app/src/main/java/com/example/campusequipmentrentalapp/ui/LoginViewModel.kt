package com.example.campusequipmentrentalapp.ui

import androidx.lifecycle.ViewModel
import com.example.campusequipmentrentalapp.data.UserRepository
import com.example.campusequipmentrentalapp.data.UserSession
import com.example.campusequipmentrentalapp.model.User

/** 로그인 시도 결과 */
sealed interface LoginResult {
    /** 입력값이 비어 있음 */
    data object EmptyId : LoginResult

    /** 등록되지 않은 사용자 */
    data object NotFound : LoginResult

    /** 로그인 성공 */
    data class Success(val user: User) : LoginResult
}

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    /**
     * 입력된 ID로 로그인을 시도한다.
     * 성공하면 UserSession에 사용자를 저장하고 결과를 돌려준다.
     */
    fun login(inputId: String): LoginResult {
        val loginId = inputId.trim()

        if (loginId.isEmpty()) {
            return LoginResult.EmptyId
        }

        val user = userRepository.findByLoginId(loginId)
            ?: return LoginResult.NotFound

        UserSession.login(user)
        return LoginResult.Success(user)
    }
}
