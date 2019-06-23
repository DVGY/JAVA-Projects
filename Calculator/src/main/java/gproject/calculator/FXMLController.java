package gproject.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    @FXML
    private TextField textView;

    Model modelObj = new Model();

    private float numberOne;
    private float numberTwo;
    private float result;
    boolean flag = true;
    boolean sucessiveOperation = false;
    boolean afterOperatorPressed = false;
    boolean inFunctionModule = false;
    int inFucntionState;
    String numericalValue = "";
    String operator = "";
    @FXML
    private void handleNumberButtonAction(ActionEvent event) {
        if ("0".equals(textView.getText())) {
            textView.setText("");
            numericalValue = ((Button) event.getSource()).getText();
            textView.setText(numericalValue);
        } else if (afterOperatorPressed) {
            textView.setText("");
            numericalValue = ((Button) event.getSource()).getText();
            textView.setText(numericalValue);
            afterOperatorPressed = false;

        } else if (inFunctionModule) {
            textView.setText("");
            numericalValue = ((Button) event.getSource()).getText();
            textView.setText(numericalValue);
            inFunctionModule = false;
        } else {
            numericalValue = ((Button) event.getSource()).getText();
            numericalValue = textView.getText() + numericalValue;
            textView.setText(numericalValue);

        }
    }

    @FXML
    private void handleOperatorButtonAction(ActionEvent event) {

        if (sucessiveOperation) {
            numberOne = result;
            flag = false;
        }

        if (flag) {
            numberOne = Float.parseFloat(numericalValue);
            numericalValue = "";
            flag = false;
        }
        operator = ((Button) event.getSource()).getText();

        textView.setText(operator);
        afterOperatorPressed = true;

    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        if ("cancel".equals(((Button) event.getSource()).getId())) {
            if ("0".equals(textView.getText())) {
                textView.setText("");
            } /**/ else if (flag == true && (!sucessiveOperation)) {
                int len = numericalValue.length();
                numericalValue = numericalValue.substring(0, len - 1);
                textView.setText(numericalValue);
            } else if (flag == false && (afterOperatorPressed == true) && (!sucessiveOperation)) {
                operator = "";
                textView.setText("");
            } else if ((flag == false) && (afterOperatorPressed == false) && (!sucessiveOperation)) {
                int len = numericalValue.length();
                numericalValue = numericalValue.substring(0, len - 1);
                textView.setText(numericalValue);
            } else if (sucessiveOperation) {
                String dispResultHandleClearButtonAction = textView.getText();
                int len = dispResultHandleClearButtonAction.length();
                dispResultHandleClearButtonAction = dispResultHandleClearButtonAction.substring(0, len - 1);
                textView.setText(dispResultHandleClearButtonAction);
                result = Float.valueOf(dispResultHandleClearButtonAction);
            }

        } else {
            textView.setText("0");
            numericalValue="";
            numberOne = 0;
            operator = "";
            numberTwo = 0;
            result = 0;
            flag = true;
            sucessiveOperation = false;
            afterOperatorPressed = false;
            inFunctionModule = false;
            inFucntionState =0;
        }
    }

    @FXML
    private void handleFunctionButtonAction(ActionEvent event) {
        String buttonId;
        inFunctionModule = true;
        inFucntionState = 1;

        buttonId = ((Button) event.getSource()).getId();
        switch (buttonId) {
            case "squareRoot":
                if (sucessiveOperation) {
                    numberOne = result;
                    textView.setText("sqrt(" + result + ")");
                    operator = buttonId;
                } else {
                    textView.setText("sqrt(");
                    operator = buttonId;
                }
                break;
            case "sin":
                textView.setText("sin(");
                operator = buttonId;
                break;
            case "cos":
                textView.setText("cos(");
                operator = buttonId;
                break;
            case "tan":
                textView.setText("tan(");
                operator = buttonId;
                break;
            case "xInverse":
                textView.setText("x INV(");
                operator = buttonId;
                break;
            case "xSquare":
                textView.setText("square(");
                operator = buttonId;
                break;
            default:
                break;
        }

    }

    @FXML
    private void handlerResultAction(ActionEvent event) {

        if (!flag) {
            if (numericalValue.isEmpty()) {
                numberTwo = 0;
            } else {
                numberTwo = Float.parseFloat(numericalValue);
                numericalValue = "";
                flag = true;
            }
        }

        if ((!inFunctionModule) && (inFucntionState == 1)) {
            numberTwo = 0;
            if (numericalValue.isEmpty()) {
                numberOne = 0;
            } else {
                numberOne = Float.parseFloat(numericalValue);

            }
        }
        result = modelObj.compute(numberOne, numberTwo, operator);
        String dispResult = Float.toString(result);
        textView.setText(dispResult);
        sucessiveOperation = true;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
