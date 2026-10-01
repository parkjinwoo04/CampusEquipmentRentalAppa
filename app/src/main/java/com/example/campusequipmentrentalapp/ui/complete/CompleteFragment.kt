package com.example.campusequipmentrentalapp.ui.complete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.campusequipmentrentalapp.R
import com.example.campusequipmentrentalapp.databinding.FragmentCompleteBinding
import com.example.campusequipmentrentalapp.model.Equipment

class CompleteFragment : Fragment(R.layout.fragment_complete) {

    private var _binding: FragmentCompleteBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        _binding = FragmentCompleteBinding.bind(view)
        
        val equipment = arguments?.getSerializable("equipment") as? Equipment
        val applicantName = arguments?.getString("applicantName") ?: ""
        val studentId = arguments?.getString("studentId") ?: ""
        val rentalDays = arguments?.getInt("rentalDays") ?: 1
        val purpose = arguments?.getString("purpose") ?: ""
        
        equipment?.let { equip ->
            binding.tvCompleteEquipment.text = "📦 기자재: ${equip.name}"
            binding.tvCompleteApplicant.text = "👤 신청인: $applicantName"
            binding.tvCompleteStudentId.text = "🎓 학번: $studentId"
            binding.tvCompletePeriod.text = "📅 대여 기간: ${rentalDays}일"
            binding.tvCompletePurpose.text = "📝 목적: $purpose"
        }
        
        binding.btnGoList.setOnClickListener {
            findNavController().navigate(R.id.action_completeFragment_to_equipmentListFragment)
        }
        
        binding.btnGoHome.setOnClickListener {
            findNavController().navigate(R.id.action_completeFragment_to_homeFragment)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
