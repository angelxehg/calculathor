/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculathor;

import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Term {

    private Boolean isPositive = true;

    private Integer coefficient = 1;

    private ArrayList<Character> variables = new ArrayList<Character>();

    public Term(String newTerm) {
        this.isPositive = this.getPositive(newTerm);
        this.coefficient = this.getCoeficient(newTerm);
        this.variables = this.getVariables(newTerm);
    }

    private Boolean getPositive(String newTerm) {
        if (this.getOperator(newTerm) == '-') {
            return false;
        } else {
            return true;
        }
    }

    private Character getOperator(String newTerm) {
        Character key = newTerm.charAt(0);
        if (key.toString().matches("[+,\\-,*,/]+")) {
            return key;
        } else {
            return '+';
        }
    }

    private Integer getCoeficient(String newTerm) {
        Integer value = 1;
        String newValue = "";
        for (Character key : newTerm.toCharArray()) {
            if (key.toString().matches("[0-9]+")) {
                newValue += key;
            }
        }
        if (newValue != "") {
            value = Integer.parseInt(newValue);
        }
        return value;
    }

    private ArrayList<Character> getVariables(String newTerm) {
        ArrayList<Character> variables = new ArrayList<Character>();
        for (Character key : newTerm.toCharArray()) {
            if (key.toString().matches("[A-Za-z]+")) {
                variables.add(key);
            }
        }
        return variables;
    }

    public Integer solve(VariableDictionary dictionary) {
        Integer result = coefficient;
        for (Character variable : this.variables) {
            Integer value = dictionary.getVariableValue(variable);
            if (value > 0) {
                result *= value;
            }
        }
        if (isPositive) {
            return result;
        } else {
            return 0 - result;
        }
    }

}
