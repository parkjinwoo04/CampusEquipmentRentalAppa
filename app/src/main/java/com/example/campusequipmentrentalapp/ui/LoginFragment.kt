package com.example.campusequipmentrentalapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.campusequipmentrentalapp.R
import com.example.campusequipmentrentalapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            val input = binding.etLoginId.text.toString()
            handleLoginResult(viewModel.login(input))
        }
    }

    private fun handleLoginResult(result: LoginResult) {
        when (result) {
            LoginResult.EmptyId -> {
                binding.etLoginId.error = "사용자 ID를 입력하세요."
                binding.etLoginId.requestFocus()
            }

            LoginResult.NotFound -> {
                showToast("등록되지 않은 사용자입니다.")
            }

            is LoginResult.Success -> {
                showToast("${result.user.name}님 로그인 성공")

                // Home으로 이동
                findNavController().navigate(
                    R.id.action_loginFragment_to_homeFragment
                )
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
