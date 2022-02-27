package com.tareadavid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.tareadavid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se establece el enlacce en la vista xml mediante el objeto binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //Con esto se presenta en pantalla la aplicacion
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth  //se asigna el objeto para la autenticacion

        //Se define el metodo para el login
        binding.btLogin.setOnClickListener {
            haceLogin();
        }

        //Se define el metodo para el regisro
        binding.btRegister.setOnClickListener {
            haceRegistro();
        }
    }

    private fun haceRegistro() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        //Se hace el registro
        auth.createUserWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Creando usuario", "Registrado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Creando usuario", "Error")
                    Toast.makeText(baseContext,getString(R.string.msg_fallo_registro), Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }

            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    //Esto hara que una vez logueado no lo vuelva a pedir que se loguee a menos que cierre la sesion
    public override fun onStart() {
        super.onStart()
        val usuario=auth.currentUser
        actualiza(usuario)
    }

    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        //Se hace login
        auth.signInWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Autenticando", "Autenticado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Autenticando", "Error")
                    Toast.makeText(baseContext, getString(R.string.msg_fallo_login), Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }
}