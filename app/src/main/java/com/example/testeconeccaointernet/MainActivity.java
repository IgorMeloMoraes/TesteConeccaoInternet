package com.example.testeconeccaointernet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnChecarConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChecarConexao = findViewById(R.id.btnChecarConexao);

        // Evento de Click no botão para checar a conexão
        btnChecarConexao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se estiver conectado emite um alerta sobre que está OK, caso contrario, emite um alerta para conectar a internet
                if(isConnected())
                    Toast.makeText(getApplicationContext(),"INTERNET FUNCIONADO!",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"INTERNET QUEBRADA - ERROR!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Metodo Booleano para checar a Conexão
    boolean isConnected(){

        /*
            I - ConectivityManager: Essa classe responde a consultas sobre o estado da conectividade da rede - Ele também notifica os aplicativos quando a conectividade da rede muda.
            II - NetworkInfo: Pega informações sobre a conexão indo na Manifest
        *  */

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validação de estado da internet
        // Caso a intenet não esteja nula, retorne se ela esta conectada, caso sim retornar verdadeiro, caso não, retornar falso
        if(networkInfo!=null){
            if(networkInfo.isConnected())
                return true;
            else
                return false;
        }else
            return false;

    }
}