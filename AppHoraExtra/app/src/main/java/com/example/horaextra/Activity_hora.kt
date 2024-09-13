package com.example.horaextra

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.horaextra.databinding.ActivityHoraBinding
import kotlin.math.round

class ActivityHora : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoraBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calcular) {
            calcularHoraExtra()
        }
    }

    private fun calcularHoraExtra() {

        val horasExtrasText = binding.editEscolha.text.toString()
        val valorHoraText = binding.editValorHora.text.toString()


        if (horasExtrasText.isEmpty() || valorHoraText.isEmpty()) {
            Toast.makeText(this, "Por favor, insira todos os valores.", Toast.LENGTH_SHORT).show()
            return
        }

        val horasExtras = horasExtrasText.toFloat()
        val valorHora = valorHoraText.toFloat()


        var totalPagamento = 0.0f

        if (horasExtras <= 2) {
            totalPagamento = horasExtras * (valorHora * 1.5f)
        } else {
            totalPagamento = 2 * (valorHora * 1.5f)
            val horasExcedentes = horasExtras - 2
            totalPagamento += horasExcedentes * (valorHora * 1.6f)
        }

        totalPagamento = round(totalPagamento * 100) / 100


        binding.textResultado.text = "Total a receber: R$ $totalPagamento"
    }
}
