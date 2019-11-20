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
        this.terms = this.splitTerms(newExpression);
    }

    private ArrayList<Term> splitTerms(String newExpression) {
        int nextPlus = newExpression.indexOf("+", 1);
        int nextMinus = newExpression.indexOf("-", 1);
        if (nextPlus < 0 && nextMinus < 0) {
            // Base case
            ArrayList<Term> terms = new ArrayList<Term>();
            Term term = new Term(newExpression);
            terms.add(term);
            return terms;
        } else {
            // Recursive case
            int index = this.nextIndex(nextPlus, nextMinus);
            Term term = new Term(newExpression.substring(0, index));
            String remaining = newExpression.substring(index);
            ArrayList<Term> terms = this.splitTerms(remaining);
            terms.add(0, term);
            return terms;
        }
    }

    private int nextIndex(int nextPlus, int nextMinus) {
        if ((nextPlus < nextMinus && nextPlus > 1) || nextMinus < 1) {
            return nextPlus;
        } else {
            return nextMinus;
        }
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
