package br.edu.fateczl.proj_salarioprofessor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.edu.fateczl.proj_salarioprofessor.model.Professor;
import br.edu.fateczl.proj_salarioprofessor.model.ProfessorHorista;
import br.edu.fateczl.proj_salarioprofessor.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbTit;
    private RadioButton rbHor;
    private EditText etHoras;
    private EditText etAnos;
    private Button btnCalc;
    private TextView tvSalario;

    private Professor prof;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rbTit = findViewById(R.id.rbTit);
        rbTit.setChecked(true);
        rbHor = findViewById(R.id.rbHor);
        rbHor.setChecked(false);
        etHoras = findViewById(R.id.etHoras);
        etAnos = findViewById(R.id.etAnos);
        btnCalc = findViewById(R.id.btnCalc);
        tvSalario = findViewById(R.id.tvSalario);

        Button btnCalcular = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calcSalario());
    }

    private void calcSalario()
    {
        int horas = Integer.parseInt(etHoras.getText().toString());
        int anos = Integer.parseInt((etAnos.getText().toString()));
        double salario = 0;

        Professor prof;
        if (rbHor.isChecked())
        {
            prof = new ProfessorHorista();
            salario = prof.calcSalario(horas);
        }
        if (rbTit.isChecked())
        {
            prof = new ProfessorTitular();
            salario = prof.calcSalario(anos);
        }
        BigDecimal sal = BigDecimal.valueOf(salario).setScale(2, RoundingMode.HALF_UP);

        tvSalario.setText(getString(R.string.salario) + sal);
    }
}