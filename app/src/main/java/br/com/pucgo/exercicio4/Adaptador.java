package br.com.pucgo.exercicio4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptador extends ArrayAdapter<Produto> {

    private Context context;
    private int resourceList;


    public Adaptador(@NonNull Context context, int resource, @NonNull List<Produto> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceList = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nome = getItem(position).getNome();
        int codigo = getItem(position).getCodigo();
        double valor = getItem(position).getValor();


        Produto produtos = new Produto(nome, codigo, valor);
        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(resourceList, parent, false);
        TextView textViewNome =  convertView.findViewById(R.id.texto);
        TextView textViewCodigo =
                convertView.findViewById(R.id.texto2);
        TextView textViewValor =
                convertView.findViewById(R.id.texto3);


        textViewNome.setText(nome);
        textViewCodigo.setText("Código: " + codigo);
        textViewValor.setText("Valor: " + valor);

        return convertView;
    }
}
