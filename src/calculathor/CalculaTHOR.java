/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculathor;

/**
 *
 * @author angel
 */
public class CalculaTHOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Input input = new Input();
        String newExpression = input.readString("Write expression: ").trim();
        VariableDictionary dictionary = new VariableDictionary(newExpression);
        Expression expression = new Expression(newExpression, dictionary);
        Integer result = expression.solve();
        System.out.println("Result: " + result);
    }

}
