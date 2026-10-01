package com.example.campusequipmentrentalapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.campusequipmentrentalapp.R
import com.example.campusequipmentrentalapp.databinding.FragmentEquipmentDetailBinding
import com.example.campusequipmentrentalapp.model.Equipment
import com.example.campusequipmentrentalapp.model.RentalStatus

class EquipmentDetailFragment : Fragment(R.layout.fragment_equipment_detail) {
    
    private var _binding: FragmentEquipmentDetailBinding? = null
    private val binding get() = _binding!!
    private var equipment: Equipment? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        _binding = FragmentEquipmentDetailBinding.bind(view)
        equipment = arguments?.getSerializable("equipment") as? Equipment
        
        equipment?.let { equip ->
            binding.tvDetailIcon.text = equip.icon
            binding.tvDetailName.text = equip.name
            binding.tvDetailCategory.text = equip.category
            
            binding.tvDetailStatus.apply {
                text = equip.status.label
                when (equip.status) {
                    RentalStatus.AVAILABLE -> {
                        setBackgroundResource(R.drawable.bg_status_available)
                        setTextColor(resources.getColor(R.color.white, null))
                    }
                    RentalStatus.RENTED -> {
                        setBackgroundResource(R.drawable.bg_status_unavailable)
                        setTextColor(resources.getColor(R.color.white, null))
                    }
                    RentalStatus.MAINTENANCE -> {
                        setBackgroundResource(R.drawable.bg_status_maintenance)
                        setTextColor(resources.getColor(R.color.white, null))
                    }
                }
            }
            
            binding.tvDetailDescription.text = equip.description
            binding.tvDetailLocation.text = "📍 위치: ${equip.location}"
            binding.tvDetailMaxDays.text = "🗓️ 최대 대여 기간: ${equip.maxRentalDays}일"
            
            binding.btnRentEquipment.apply {
                isEnabled = equip.status.isAvailable
                if (!equip.status.isAvailable) {
                    text = "대여 불가능"
                }
            }
        }
        
        binding.btnBackDetail.setOnClickListener {
            findNavController().popBackStack()
        }
        
        binding.btnRentEquipment.setOnClickListener {
            equipment?.let { equip ->
                val bundle = Bundle().apply {
                    putSerializable("equipment", equip)
                }
                findNavController().navigate(
                    R.id.action_equipmentDetailFragment_to_rentalFragment,
                    bundle
                )
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}