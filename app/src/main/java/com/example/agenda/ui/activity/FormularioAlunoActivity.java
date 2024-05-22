package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.DAO.AlunoDAO;
import com.example.agenda.R;
import com.example.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTel;
    private EditText campoEmail;
    AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Cadastro de um novo aluno");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_aluno2);


        inicializaCampos();

        Button botaoSave = findViewById(R.id.activity_formulario_aluno_save_buttom);
        botaoSave.setOnClickListener(v -> {
            Aluno alunoNovo = criaAluno(campoNome, campoTel, campoEmail);
            salvaAluno(dao, alunoNovo);
        });
    }

    private void inicializaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTel = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salvaAluno(AlunoDAO dao, Aluno alunoNovo) {
        dao.salva(alunoNovo);

        finish();
    }

    @NonNull
    private static Aluno criaAluno(EditText campoNome, EditText campoTel, EditText campoEmail) {
        String nome = campoNome.getText().toString();
        String tel = campoTel.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, tel, email);
    }
}