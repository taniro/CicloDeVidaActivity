package tads.eaj.ufrn.ciclodevidaactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MY_REQUEST_CODE = 99
    val TAG:String = "AULATADS"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        confirmaButton.setOnClickListener {
            var i = Intent(this, Main2Activity::class.java)

            var param = Bundle()
            param.putString("TEXTO", editText.text.toString())
            param.putDouble("VALOR", 20.0)
            param.putString("AULA", "PDM")

            i.putExtras(param)


            //i.putExtra("TEXTO", editText.text.toString())

            startActivity(i)
        }
        */


        /*
        confirmaButton.setOnClickListener {
            var i = Intent(this, Main2Activity::class.java)
            var mensagem = editText.text.toString()

            var b = Bundle()
            b.putString("TEXTO", mensagem)

            i.putExtras(b)

            startActivity(i)
        }
        */



        confirmaButton.setOnClickListener {

            var i = Intent(this, Main2Activity::class.java)
            var mensagem = editText.text.toString()

            var b = Bundle()
            b.putString("TEXTO", mensagem)

            i.putExtras(b)

            startActivityForResult(i, MY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i(TAG, "Resquest code = $requestCode, result code = $resultCode")
        when(requestCode){
            MY_REQUEST_CODE->{
                when (resultCode){
                    Activity.RESULT_OK->{
                        val param = data?.extras
                        val textoResultado = param?.getString("DADOS_RESPOSTA")
                        Toast.makeText(this, "A resposta é $textoResultado", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onStart() {
        Log.i(TAG, "onStart()")
        super.onStart()
    }

    override fun onStop() {
        Log.i(TAG, "onStop()")
        super.onStop()
    }

    override fun onPause() {
        Log.i(TAG, "onPause()")
        super.onPause()
    }

    override fun onResume() {
        Log.i(TAG, "onResume()")
        super.onResume()
    }

    override fun onRestart() {
        Log.i(TAG, "onRestart()")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy()")
        super.onDestroy()
    }


}
