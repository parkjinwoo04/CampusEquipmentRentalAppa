package com.example.campusequipmentrentalapp.ui.rental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.campusequipmentrentalapp.R
import com.example.campusequipmentrentalapp.databinding.FragmentRentalBinding
import com.example.campusequipmentrentalapp.model.Equipment

class RentalFragment : Fragment(R.layout.fragment_rental) {
    
    private var _binding: FragmentRentalBinding? = null
    private val binding get() = _binding!!
    private var equipment: Equipment? = null
    private var selectedRentalDays: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        _binding = FragmentRentalBinding.bind(view)
        equipment = arguments?.getSerializable("equipment") as? Equipment
        
        if (equipment != null) {
            setupUI(equipment!!)
        } else {
            Toast.makeText(requireContext(), "기자재 정보를 받지 못했습니다.", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
            return
        }
        
        binding.btnBackRental.setOnClickListener {
            findNavController().popBackStack()
        }
        
        binding.btnSubmitRental.setOnClickListener {
            val applicantName = binding.etApplicantName.text.toString().trim()
            val studentId = binding.etStudentId.text.toString().trim()
            val purpose = binding.etPurpose.text.toString().trim()
            
            if (applicantName.isEmpty()) {
                Toast.makeText(requireContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (studentId.isEmpty()) {
                Toast.makeText(requireContext(), "학번을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (purpose.isEmpty()) {
                Toast.makeText(requireContext(), "대여 목적을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            val bundle = Bundle().apply {
                putSerializable("equipment", equipment)
                putString("applicantName", applicantName)
                putString("studentId", studentId)
                putInt("rentalDays", selectedRentalDays)
                putString("purpose", purpose)
            }
            findNavController().navigate(
                R.id.action_rentalFragment_to_completeFragment,
                bundle
            )
        }
    }
    
    private fun setupUI(equip: Equipment) {
        val maxDays = equip.maxRentalDays
        binding.tvSelectedEquipment.text = "📦 ${equip.name}"
        binding.tvRentalRule.text = "최대 ${maxDays}일까지 대여할 수 있습니다."
        setupRentalPeriodSpinner(maxDays)
    }
    
    private fun setupRentalPeriodSpinner(maxDays: Int) {
        try {
            val periodOptions = mutableListOf<String>()
            for (day in 1..maxDays) {
                periodOptions.add("${day}일")
            }
            
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                periodOptions
            )
            
            binding.spinnerPeriod.adapter = adapter
            binding.spinnerPeriod.onItemSelectedListener = 
                object : android.widget.AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: android.widget.AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedRentalDays = position + 1
                    }
                    
                    override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
                }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "스피너 설정 오류: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
