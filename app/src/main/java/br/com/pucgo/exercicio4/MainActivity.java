package br.com.pucgo.exercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText textNome, textCodigo, textValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnCadastrar);
        textNome = findViewById(R.id.nomeProduto);
        textCodigo = findViewById(R.id.codigoProduto);
        textValor = findViewById(R.id.valorProduto);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SegundaTela.class);
                Bundle bundle = new Bundle();
                if(!textNome.getText().toString().isEmpty()
                && !textCodigo.getText().toString().isEmpty()
                && !textValor.getText().toString().isEmpty()){
                    String nome = textNome.getText().toString();
                    int codigo = Integer.parseInt(textCodigo.getText().toString());
                    double valor = Double.parseDouble(textValor.getText().toString());
                    Produto produto = new Produto(nome, codigo, valor);
                    bundle.putString("nomeProduto", produto.getNome());
                    bundle.putInt("codigoProduto", produto.getCodigo());
                    bundle.putDouble("valorProduto", produto.getValor());
                }
                i.putExtras(bundle);
                startActivity(i);
                finish();
            }
        });
    }
}