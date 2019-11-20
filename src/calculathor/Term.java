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
        // TODO: Create from String
    }

    public Integer solve(VariableDictionary dictionary) {
        Integer result = coefficient;
        for (Character variable : variables) {
            Integer value = dictionary.getVariableValue(variable);
            if (value > 0) {
                result *= value;
            }
        }
        return result;
    }

}
