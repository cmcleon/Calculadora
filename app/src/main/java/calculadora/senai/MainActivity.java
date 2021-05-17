package calculadora.senai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String primeiroNumero = "";
    private String segundoNumero = "";
    private String operacao = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle ("Minha Calculadora");
        display = findViewById(R.id.tv_display);
    }

    public void onClickBotaoPonto(View v){
        if (primeiroNumero.isEmpty()){
            atualizarNumeroDigitado("0.");
            atualizarDisplay( "0.");
        }else if (!operacao.isEmpty() && segundoNumero.isEmpty()){
            atualizarNumeroDigitado("0.");
            atualizarDisplay( "0.");
        } else{
            atualizarNumeroDigitado(".");
            atualizarDisplay( ".");
        }
    }
    public void onClickBotao0(View v){
        atualizarNumeroDigitado("0");
        atualizarDisplay( "0");
    }
    public void onClickBotao1(View v){
       atualizarNumeroDigitado("1");
       atualizarDisplay( "1");
    }
    public void onClickBotao2(View v){
        atualizarNumeroDigitado("2");
        atualizarDisplay( "2");
    }
    public void onClickBotao3(View v){
        atualizarNumeroDigitado("3");
        atualizarDisplay( "3");
    }
    public void onClickBotao4(View v){
        atualizarNumeroDigitado("4");
        atualizarDisplay( "4");
    }
    public void onClickBotao5(View v){
        atualizarNumeroDigitado("5");
        atualizarDisplay( "5");
    }
    public void onClickBotao6(View v){
        atualizarNumeroDigitado("6");
        atualizarDisplay( "6");
    }
    public void onClickBotao7(View v){
        atualizarNumeroDigitado("7");
        atualizarDisplay( "7");
    }
    public void onClickBotao8(View v){
        atualizarNumeroDigitado("8");
        atualizarDisplay( "8");
    }
    public void onClickBotao9(View v){
        atualizarNumeroDigitado("9");
        atualizarDisplay( "9");
    }
    public void onClickBotaoAdicao(View v){
        verificarOperacao("+");
    }
    public void onClickBotaoSubtracao(View v){
        verificarOperacao("-");
    }
    public void onClickBotaoDivisao(View v){
        verificarOperacao("/");
    }
    public void onClickBotaoMultiplicacao(View v){
        verificarOperacao("*");
    }
    public void onClickBotaoIgual(View v) {
        if (operacao.isEmpty()){
            Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada.", Toast.LENGTH_LONG).show();
        }
        if (!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()) {
            double numero1 = Double.parseDouble(primeiroNumero);
            double numero2 = Double.parseDouble(segundoNumero);

            if (operacao.equals("+")) {
                double resultado = numero1 + numero2;
                display.setText(String.valueOf(resultado));
            } else if (operacao.equals("-")) {
                double resultado = numero1 - numero2;
                display.setText(String.valueOf(resultado));
            } else if (operacao.equals("/")) {
                double resultado = numero1 / numero2;
                display.setText(String.valueOf(resultado));
            } else if (operacao.equals("*")) {
                double resultado = numero1 * numero2;
                display.setText(String.valueOf(resultado));
            }
        }
    }

    public void onClickBackspace(View v){
        if (!segundoNumero.isEmpty()){
            segundoNumero = segundoNumero.substring(0, segundoNumero.length()-1);
        }else if(!operacao.isEmpty()) {
            operacao = operacao.substring(0, operacao.length() - 1);
        }
        else if(!primeiroNumero.isEmpty()){
            primeiroNumero = primeiroNumero.substring(0, primeiroNumero.length()-1);}
        display.setText("");
        atualizarDisplay(primeiroNumero+""+ operacao+""+ segundoNumero);


    }

    public void onClickBtnC(View v){
        display.setText("");
        primeiroNumero = "";
        segundoNumero = "";
        operacao = "";
    }

    private void atualizarDisplay(String texto){
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }

    private void atualizarNumeroDigitado(String numero){
        if (operacao.isEmpty()){
            primeiroNumero = primeiroNumero + numero;
        } else{
            segundoNumero = segundoNumero + numero;
        }
    }

    private void verificarOperacao(String operacao){
         if(!primeiroNumero.isEmpty()){
             if (this.operacao.isEmpty()){
                 this.operacao = operacao;
                 atualizarDisplay( this.operacao);
             }
         }else{
            Toast.makeText(MainActivity.this, "Informe um número antes de solicitar uma operação.", Toast.LENGTH_LONG).show();
        }
    }



}