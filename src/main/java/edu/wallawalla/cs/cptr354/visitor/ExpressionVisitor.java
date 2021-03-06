package edu.wallawalla.cs.cptr354.visitor;

import java.util.HashMap;
import java.util.LinkedList;

public class ExpressionVisitor implements ExpressionParserVisitor {

	private LinkedList<Object> stack = new LinkedList<Object>();
	private HashMap<Object, Object> symbolTable = new HashMap<Object, Object>();

	public Object visit(SimpleNode node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}

	public Object visit(ASTstart node, Object data) {
		node.childrenAccept(this, data);
		return symbolTable;
	}


	public Object visit(ASTDebugExpr node, Object data) {
		node.childrenAccept(this, data);
		System.out.println(symbolTable);
		return null;
	}

	public Object visit(ASTPrintExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		System.out.println(arg1);
		return null;
	}

	public Object visit(ASTAddExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() + arg1.doubleValue()));
		return null;
	}
    public Object visit(ASTSubtraction node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() - arg1.doubleValue()));
		return null;
	}

    public Object visit(ASTTimesExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() * arg1.doubleValue()));
		return null;
	}
    public Object visit(ASTDivideExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() / arg1.doubleValue()));
		return null;
	}
	public Object visit(ASTNegateExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		stack.addFirst(Double.valueOf(arg1.doubleValue() * -1));
		return null;
	}
	public Object visit(ASTsqrtExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		stack.addFirst(Double.valueOf(Math.sqrt(arg1.doubleValue())));
		return null;
	}

	public Object visit(ASTNumber node, Object data) {
		node.childrenAccept(this, data);
		stack.addFirst(node.data.get("value"));
		return null;
	}

	public Object visit(ASTStatement node, Object data) {
		node.childrenAccept(this, data);
		Double value = (Double) stack.removeFirst();
		String var = (String) stack.removeFirst();
		symbolTable.put(var, value);
		return null;
	}

	public Object visit(ASTVariable node, Object data) {
		node.childrenAccept(this, data);
		String var = (String) node.data.get("name");
		stack.addFirst(var);
		return null;
	}

	public Object visit(ASTVariableValue node, Object data) {
		node.childrenAccept(this, data);
		String var = (String) node.data.get("name");
		stack.addFirst(symbolTable.get(var));
		return null;
	}

	private Double pop() {
		return (Double) stack.removeFirst();
	}

}