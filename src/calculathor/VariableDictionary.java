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
        // TODO: Create from String
        variables.put('x', 3);
        variables.put('y', 2);
    }

    public Integer getVariableValue(Character key) {
        return variables.get(key);
    }

}
