package curso.androidkotlin.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View){

        //recupera valores digitados
        // val precoAlcool = findViewById<EditText>(R.id.edit_preco_alcool)
        // val textoRecuperado = preco.text.toString

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if(validaCampos){
            calcularMelhorpreco(precoAlcool, precoGasolina)
        }else{
            txt_resultado.setText("Preencha os preços antes de calcular")
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
        

    }

    fun calcularMelhorpreco(precoAlcool: String, precoGasolina: String){

        //Convereter valos string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool/valorGasolina
        if (resultadoPreco>= 0.7 ){
            txt_resultado.setText("melhor utilizar Gasolina!")
        }else{
            txt_resultado.setText("Melhor utilizar Álcool!")
        }
    }
}