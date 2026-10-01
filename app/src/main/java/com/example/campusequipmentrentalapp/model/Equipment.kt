package com.example.campusequipmentrentalapp.model

import java.io.Serializable

data class Equipment(
    val id: Int,
    val name: String,
    val category: String,
    val icon: String,
    val status: RentalStatus,
    val maxRentalDays: Int,
    val location: String,
    val description: String
) : Serializable

enum class RentalStatus(
    val label: String,
    val isAvailable: Boolean
) : Serializable {
    AVAILABLE("대여 가능", true),
    RENTED("대여 중", false),
    MAINTENANCE("점검 중", false)
}

