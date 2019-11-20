/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculathor;

import java.util.HashMap;

/**
 *
 * @author angel
 */
public class VariableDictionary {

    private HashMap<Character, Integer> variables = new HashMap<Character, Integer>();

    public VariableDictionary(String newExpression) {
        Input input = new Input();
        for (Character key : newExpression.toCharArray()) {
            if (key.toString().matches("[A-Za-z]+") && !variables.containsKey(key)) {
                Integer value = input.readInteger("Set value of " + key + ": ");
                variables.put(key, value);
            }
        }
        input.close();
    }

    public Integer getVariableValue(Character key) {
        return variables.get(key);
    }

}
