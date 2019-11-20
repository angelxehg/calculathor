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
public class Expression {

    private ArrayList<Term> terms = new ArrayList<Term>();

    private VariableDictionary dictionary;

    public Expression(String newExpression, VariableDictionary dictionary) {
        this.dictionary = dictionary;
        // TODO: Create from String
        terms.add(new Term("2x"));
        terms.add(new Term("5y", false));
    }

    public Integer solve() {
        Integer result = 0;
        for (Term term : terms) {
            Integer value = term.solve(this.dictionary);
            result += value;
        }
        return result;
    }

}
