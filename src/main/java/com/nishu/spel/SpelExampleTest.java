package com.nishu.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.nishu.spel.bean.SampleBean;

public class SpelExampleTest {

	public static void main(String[] args) {

		ExpressionParser expressionParser = new SpelExpressionParser();
		// 1. Literal expression
		Expression expression = expressionParser.parseExpression("'Hello SpEL'");
		String strVal = expression.getValue(String.class);
		System.out.println("1. Literal expression value:\n" + strVal);
		// 2. Method invocation
		expression = expressionParser.parseExpression("'Hello SpEL'.concat('!')");
		strVal = expression.getValue(String.class);
		System.out.println("2. Method invocation value:\n" + strVal);
		// 3. Mathematical operator
		expression = expressionParser.parseExpression("16 * 5");
		Integer intVal = expression.getValue(Integer.class);
		System.out.println("3. Mathematical operator value:\n" + intVal);
		// 4. Relational operator
		expression = expressionParser.parseExpression("5 < 9");
		boolean boolVal = expression.getValue(Boolean.class);
		System.out.println("4. Mathematical operator value:\n" + boolVal);
		// 5. Logical operator
		expression = expressionParser.parseExpression("400 > 200 && 200 < 500");
		boolVal = expression.getValue(Boolean.class);
		System.out.println("5. Logical operator value:\n" + boolVal);
		// 6. Ternary operator
		expression = expressionParser.parseExpression("'some value' != null ? 'some value' : 'default'");
		strVal = expression.getValue(String.class);
		System.out.println("6. Ternary operator value:\n" + strVal);
		// 7. Elvis operator
		expression = expressionParser.parseExpression("'some value' ?: 'default'");
		strVal = expression.getValue(String.class);
		System.out.println("7. Elvis operator value:\n" + strVal);
		// 8. Regex/matches operator
		expression = expressionParser.parseExpression("'UPPERCASE STRING' matches '[A-Z\\s]+'");
		boolVal = expression.getValue(Boolean.class);
		System.out.println("8. Regex/matches operator value:\n" + boolVal);










		System.out.println("=============================");
		System.out.println("=============================");
		System.out.println("=============================");
		System.out.println("=============================");
		System.out.println("=============================");
		// create EvaluationContext from bean
		SampleBean contextBean = new SampleBean();
		StandardEvaluationContext testContext = new StandardEvaluationContext(contextBean);
		// 9. Property value
		expression = expressionParser.parseExpression("property");
		strVal = expression.getValue(testContext, String.class);
		System.out.println("9. Property value:\n" + strVal);
		// 10. Compare property
		expression = expressionParser.parseExpression("property == 'String property'");
		boolVal = expression.getValue(testContext, Boolean.class);
		System.out.println("10. Compare property:\n" + boolVal);
		// 11. List value
		expression = expressionParser.parseExpression("arrayList[0]");
		strVal = expression.getValue(testContext, String.class);
		System.out.println("11. List value:\n" + strVal);
		// 12. Map value
		expression = expressionParser.parseExpression("hashMap['key 1']");
		strVal = expression.getValue(testContext, String.class);
		System.out.println("12. Map value:\n" + strVal);
	}
}
