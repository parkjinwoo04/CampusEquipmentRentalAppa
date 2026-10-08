package com.example.campusequipmentrentalapp.data

import com.example.campusequipmentrentalapp.model.User
import com.example.campusequipmentrentalapp.model.UserRole

class UserRepository {

    // loginId를 키로 하는 맵으로 보관해서 ID 조회를 바로 찾을 수 있게 함
    private val usersByLoginId: Map<String, User> = listOf(
        User(1, "20260001", "김민수", "컴퓨터소프트웨어학과", UserRole.STUDENT),
        User(2, "prof01", "박교수", "컴퓨터소프트웨어학과", UserRole.PROFESSOR),
        User(3, "assistant01", "이조교", "컴퓨터소프트웨어학과", UserRole.ASSISTANT)
    ).associateBy { it.loginId }

    fun findByLoginId(id: String): User? = usersByLoginId[id]
}
