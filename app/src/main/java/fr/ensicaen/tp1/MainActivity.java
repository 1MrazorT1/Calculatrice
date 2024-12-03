package fr.ensicaen.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    double value1 = 0;
    double value2;
    char currentOperator;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonPlus, buttonMinus, buttonTimes, buttonSlash, buttonEqual;
    Button buttonClear, buttonClearInput, buttonRemove, buttonPoint, buttonSign;
    Button buttonSin, buttonCos, buttonTan, buttonLog, buttonLn, buttonSquare, buttonCube;
    Button buttonToTheFourth, buttonToTheY, buttonSqrt, buttonNiemeSqrt, buttonExp;
    Button buttonAbs, buttonMod, buttonFactorial, buttonArrengement, buttonCombinaison;
    Button buttonPi, buttonE, buttonToDEG, buttonToRAD, button10ToTheX;
    Button buttonParentheseFerme, buttonParentheseOuvert, buttonInverse;

    TextView textView;
    private boolean isResultDisplayed = false;
    private void setupElements(){
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonTimes = findViewById(R.id.buttonTimes);
        buttonSlash = findViewById(R.id.buttonSlash);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonClear = findViewById(R.id.buttonClear);
        buttonClearInput = findViewById(R.id.buttonClearInput);
        buttonRemove = findViewById(R.id.buttonRemove);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonSign = findViewById(R.id.buttonSign);
        buttonSin = findViewById(R.id.buttonSin);
        buttonCos = findViewById(R.id.buttonCos);
        buttonTan = findViewById(R.id.buttonTan);
        buttonLog = findViewById(R.id.buttonLog);
        buttonLn = findViewById(R.id.buttonLn);
        buttonSquare = findViewById(R.id.buttonSquare);
        buttonCube = findViewById(R.id.buttonCube);
        buttonToTheFourth = findViewById(R.id.buttonToTheFourth);
        buttonToTheY = findViewById(R.id.buttonToTheY);
        buttonSqrt = findViewById(R.id.buttonsqrt);
        buttonNiemeSqrt = findViewById(R.id.buttonNiemeSqrt);
        buttonExp = findViewById(R.id.buttonExp);
        buttonAbs = findViewById(R.id.buttonAbs);
        buttonMod = findViewById(R.id.buttonMod);
        buttonFactorial = findViewById(R.id.buttonFactoriel);
        buttonArrengement = findViewById(R.id.buttonArrengement);
        buttonCombinaison = findViewById(R.id.buttonCombinaison);
        buttonPi = findViewById(R.id.buttonPi);
        buttonE = findViewById(R.id.buttonE);
        buttonToDEG = findViewById(R.id.buttonToDEG);
        buttonToRAD = findViewById(R.id.buttonToRAD);
        button10ToTheX = findViewById(R.id.button10ToTheX);
        buttonInverse = findViewById(R.id.buttonInverse);
        buttonParentheseFerme = findViewById(R.id.buttonParentheseFerme);
        buttonParentheseOuvert = findViewById(R.id.buttonParentheseOuvert);
        textView = findViewById(R.id.textView);
    }

    public boolean containsNonNumeric(String input) {
        return !input.matches("\\d*\\.?\\d*");
    }

    private void setupListeners(){
        View.OnClickListener numberListener = v -> {
            if (isResultDisplayed) {
                textView.setText("");
                isResultDisplayed = false;
            }

            Button b = (Button) v;
            textView.append(b.getText().toString());
        };


        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);

        /*if(buttonPlus != null){
            buttonPlus.setOnClickListener(v -> operation('+'));
        }
        if(buttonMinus != null){
            buttonMinus.setOnClickListener(v -> operation('-'));
        }

        if(buttonTimes != null){
            buttonTimes.setOnClickListener(v -> operation('*'));
        }

        if(buttonSlash != null){
            buttonSlash.setOnClickListener(v -> operation('/'));
        }*/

        if (buttonEqual != null) {
            buttonEqual.setOnClickListener(v -> {
                String input = textView.getText().toString().trim();
                if (!input.isEmpty()) {
                    Expression exp = new Expression(input);
                    double result = exp.calculate();
                    if (Double.isNaN(result) || Double.isInfinite(result)) {
                        textView.setText("Error");
                    } else {
                        textView.setText(String.valueOf(result));
                    }
                } else {
                    textView.setText("Error");
                }
            });
        }

        if(buttonClear != null){
            buttonClear.setOnClickListener(v -> {
                textView.setText("");
                value1 = 0;
                value2 = 0;
            });
        }

        if(buttonClearInput != null){
            buttonClearInput.setOnClickListener(v -> textView.setText(""));
        }

        if(buttonRemove != null){
            buttonRemove.setOnClickListener(v -> {
                String currentText = textView.getText().toString();
                if (currentText.length() > 0) {
                    textView.setText(currentText.substring(0, currentText.length() - 1));
                }
            });
        }

        if(buttonPoint != null) {
            buttonPoint.setOnClickListener(v -> textView.append("."));
        }

        if (buttonSign != null) {
            buttonSign.setOnClickListener(v -> {
                String input = textView.getText().toString().trim();
                if (input.isEmpty()) {
                    textView.setText("Error");
                    return;
                }

                try {
                    Expression exp = new Expression("-(" + input + ")");
                    double result = exp.calculate();
                    if (Double.isNaN(result) || Double.isInfinite(result)) {
                        textView.setText("Error");
                    } else {
                        textView.setText(String.valueOf(result));
                    }
                } catch (Exception e) {
                    textView.setText("Error");
                }
            });
        }

        if(buttonSin != null){
            buttonSin.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonCos != null){
            buttonCos.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonTan != null){
            buttonTan.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonLog != null){
            buttonLog.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonLn != null){
            buttonLn.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonSquare != null){
            buttonSquare.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonCube != null){
            buttonCube.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonToTheFourth != null){
            buttonToTheFourth.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonToTheY != null){
            buttonToTheY.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonSqrt != null){
            buttonSqrt.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonNiemeSqrt != null){
            buttonNiemeSqrt.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonFactorial != null){
            buttonFactorial.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonAbs != null){
            buttonAbs.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonPi != null){
            buttonPi.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonE != null){
            buttonE.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonLog != null){
            buttonLog.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonCombinaison != null){
            buttonCombinaison.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonArrengement != null){
            buttonArrengement.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonParentheseFerme != null){
            buttonParentheseFerme.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonParentheseOuvert != null){
            buttonParentheseOuvert.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonMod != null){
            buttonMod.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(button10ToTheX != null){
            button10ToTheX.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonInverse != null){
            buttonInverse.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonExp != null){
            buttonExp.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonToDEG != null){
            buttonToDEG.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

        if(buttonToRAD != null){
            buttonToRAD.setOnClickListener(v -> {
                textView.setText("NOT IMPLEMENTED YET...");
            });
        }

    }

    private void operation(char operator) {
        String input = textView.getText().toString().trim();
        if (input.isEmpty()) {
            return;
        }

        try {
            if (value1 != 0) {
                value2 = Double.parseDouble(input);
                calculResultat();
                textView.setText(String.valueOf(value1));
            } else {
                value1 = Double.parseDouble(input);
            }
            currentOperator = operator;
            textView.setText("");
        } catch (NumberFormatException e) {
            return;
        }
    }


    private void calculResultat() {
        try {
            String expression = textView.getText().toString().trim();
            Expression exp = new Expression(expression);
            double result = exp.calculate();

            if (Double.isNaN(result) || Double.isInfinite(result)) {
                textView.setText("Error");
                value1 = 0;
            } else {
                value1 = result;
                textView.setText(String.valueOf(value1));
            }
        } catch (Exception e) {
            textView.setText("Error");
            value1 = 0;
        }
    }

    private void setupOperatorListeners() {
        View.OnClickListener operatorListener = v -> {
            Button b = (Button) v;
            textView.append(" " + b.getText().toString() + " ");
        };

        buttonPlus.setOnClickListener(operatorListener);
        buttonMinus.setOnClickListener(operatorListener);
        buttonTimes.setOnClickListener(operatorListener);
        buttonSlash.setOnClickListener(operatorListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupElements();
        setupOperatorListeners();
        setupListeners();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}