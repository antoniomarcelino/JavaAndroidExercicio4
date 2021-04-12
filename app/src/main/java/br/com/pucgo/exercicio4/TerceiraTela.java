package br.com.pucgo.exercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TerceiraTela extends AppCompatActivity {
    Button btn;
    TextView t1, t2, t3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceira_tela);
        btn = findViewById(R.id.botaoVoltar2);
        t1 = findViewById(R.id.textoPrincipal);
        t2 = findViewById(R.id.textoSecundario);
        t3 = findViewById(R.id.textoTerciario);
        Intent telaAnterior = getIntent();
        String nome = telaAnterior.getStringExtra("nome");
        int texto1 = telaAnterior.getIntExtra("codigo",0);
        double texto2 = telaAnterior.getDoubleExtra("valor",0.00);
        String nomeUltimo = telaAnterior.getStringExtra("nome2");
        int codigoUltimo = telaAnterior.getIntExtra("codigo2",0);
        double valorUltimo = telaAnterior.getDoubleExtra("valor2",0.00);
        t1.setText(nome);
        t2.setText(String.valueOf(texto1));
        t3.setText(String.valueOf(texto2));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TerceiraTela.this, SegundaTela.class);
                String nome = t1.getText().toString();
                int codigo = Integer.parseInt(t2.getText().toString());
                double valor = Double.parseDouble(t3.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("nomeProduto", nomeUltimo);
                bundle.putInt("codigoProduto", codigoUltimo);
                bundle.putDouble("valorProduto", valorUltimo);
                i.putExtras(bundle);
                startActivity(i);
                finish();

            }
        });
    }
}
