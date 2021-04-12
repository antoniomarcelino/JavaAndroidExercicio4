package br.com.pucgo.exercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundaTela extends AppCompatActivity {

    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);
        listView = findViewById(R.id.listView);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Monitor", 1, 500));
        produtos.add(new Produto("Escrivaninha", 2, 400));
        produtos.add(new Produto("Cadeira", 3, 800));
        produtos.add(new Produto("Teclado Gamer", 4, 200));
        produtos.add(new Produto("Mouse", 5, 100));
        Intent dados = getIntent();
        if(dados.hasExtra("nomeProduto") && dados.hasExtra("codigoProduto") && dados.hasExtra("valorProduto") ){
            String nomeProduto = dados.getStringExtra("nomeProduto");
            int codigoProduto = dados.getIntExtra("codigoProduto", 0);
            double valorProduto = dados.getDoubleExtra("valorProduto", 0.00);
            produtos.add(new Produto(nomeProduto, codigoProduto, valorProduto));
        }


        Adaptador adaptador = new Adaptador(this, R.layout.layout_lista, produtos);
        listView.setAdapter(adaptador);

        button = findViewById(R.id.botaoVoltar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SegundaTela.this, TerceiraTela.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", adaptador.getItem(position).getNome());
                bundle.putInt("codigo", adaptador.getItem(position).getCodigo());
                bundle.putDouble("valor", adaptador.getItem(position).getValor());
                bundle.putString("nome2", adaptador.getItem(produtos.size()-1).getNome());
                bundle.putInt("codigo2", adaptador.getItem(produtos.size()-1).getCodigo());
                bundle.putDouble("valor2", adaptador.getItem(produtos.size()-1).getValor());
                i.putExtras(bundle);
                startActivity(i);
                finish();
            }
        });

    }
}
