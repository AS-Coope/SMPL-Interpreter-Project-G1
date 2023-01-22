import java.util.*;

public class Evaluator implements Visitor<Environment<SMPLObject>, SMPLObject> {
	/*
	 * For this visitor, the argument passed to all visit
	 * methods will be the environment object that used to
	 * be passed to the eval method in the first style of
	 * implementation.
	 */

	// allocate state here
	protected SMPLObject result; // result of evaluation
	private SMPLObject defaultValue;
	private Class<SMPLObject> myClass;

	protected Evaluator() {
		this(new SMPLDouble(Double.NaN));
	}

	public Evaluator(SMPLObject defaultVal) {
		// perform initialisations here
		this.defaultValue = defaultVal;
		myClass = SMPLObject.class;
		result = defaultValue;
	}

	public Environment<SMPLObject> getDefaultState() {
		return Environment.makeGlobalEnv(myClass);
	}

	public SMPLObject visitArithProgram(ArithProgram p, Environment<SMPLObject> env)
			throws VisitException {
		result = p.getSeq().visit(this, env);
		return result;
	}

	public SMPLObject visitStatement(Statement s, Environment<SMPLObject> env)
			throws VisitException {
		return s.getExp().visit(this, env);
	}

	public SMPLObject visitStmtSequence(StmtSequence sseq, Environment<SMPLObject> env)
			throws VisitException {
		// remember that env is the environment
		Statement s;
		ArrayList seq = sseq.getSeq();
		Iterator iter = seq.iterator();
		SMPLObject result = defaultValue;
		while (iter.hasNext()) {
			s = (Statement) iter.next();
			result = s.visit(this, env);
		}
		// return last value evaluated
		return result;
	}

	public SMPLObject visitStmtDefinition(StmtDefinition sd,
			Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject result;
		result = sd.getExp().visit(this, env);
		env.put(sd.getVar(), result);
		return result;
	}

	public SMPLObject visitStmtFunDefn(StmtFunDefn fd, Environment<SMPLObject> env)
			throws VisitException {
		Environment<SMPLObject> closingEnv = env;
		Closure<SMPLObject> c = new Closure<SMPLObject>(fd, closingEnv);
		env.putClosure(fd.getfunName(), c);
		return defaultValue;
	}

	public SMPLObject visitExpFunCall(ExpFunCall fc, Environment<SMPLObject> env)
			throws VisitException {
		// TODO to be implemented
		// Make child environment
		// Retrieve function definition from env if not found then throw exception
		// iterate over parameter list and evaluate arguements. If plist not equal alist
		// then throw excep
		// assign binding to new frame and evaluate

		Environment<SMPLObject> child = new Environment<SMPLObject>();

		Closure<SMPLObject> funDef = env.getClosure(fc.funName);

		if (funDef == null) {
			throw new RuntimeException("Function not defined or defined after Call");
		}

		for (int i = 0; i < fc.args.size(); i++) {
			SMPLObject answer = fc.args.get(i).visit(this, env);
			child.put(funDef.getFunction().paramList.get(i), answer);
		}
		child.parent = funDef.getClosingEnv();
		return funDef.getFunction().body.visit(this, child);

	}

	public SMPLObject visitExpAdd(ExpAdd exp, Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject val1, val2;
		val1 = exp.getExpL().visit(this, env);
		val2 = exp.getExpR().visit(this, env);
		return val1.add(val2);
	}

	public SMPLObject visitExpSub(ExpSub exp, Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject val1, val2;
		val1 = exp.getExpL().visit(this, env);
		val2 = exp.getExpR().visit(this, env);
		return val1.sub(val2);
	}

	public SMPLObject visitExpMul(ExpMul exp, Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject val1, val2;
		val1 = exp.getExpL().visit(this, env);
		val2 = exp.getExpR().visit(this, env);
		return val1.mult(val2);
	}

	public SMPLObject visitExpDiv(ExpDiv exp, Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject val1, val2;
		val1 = exp.getExpL().visit(this, env);
		val2 = exp.getExpR().visit(this, env);
		return val1.div(val2);
	}

	public SMPLObject visitExpMod(ExpMod exp, Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject val1, val2;
		val1 = exp.getExpL().visit(this, env);
		val2 = exp.getExpR().visit(this, env);
		return val1.mod(val2);
	}

	public SMPLObject visitExpSubstr(ExpSubstr exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject stringObj = exp.getStringExpr().visit(this, env);
		SMPLObject startIndexObj = exp.getStartIndexExpr().visit(this, env);
		SMPLObject endIndexObj = exp.getEndIndexExpr().visit(this, env);
		if (stringObj instanceof SMPLString && startIndexObj instanceof SMPLInt && endIndexObj instanceof SMPLInt) {
			return ((SMPLString) stringObj).substr(startIndexObj, endIndexObj);
		} else {
			throw new SMPLException("Invalid arguments for substr function");
		}
	}

	public SMPLObject visitExpEqv(ExpEqv exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject obj1 = exp.getExp1().visit(this, env);
		SMPLObject obj2 = exp.getExp2().visit(this, env);
		return obj1.iseqv(obj2);
	}

	public SMPLObject visitExpEqual(ExpEqual exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject obj1 = exp.getExp1().visit(this, env);
		SMPLObject obj2 = exp.getExp2().visit(this, env);
		return obj1.isequal(obj2);
	}

	public SMPLObject visitExpPair(ExpPair exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject first = exp.getFirst().visit(this, env);
		SMPLObject second = exp.getSecond().visit(this, env);
		return new SMPLPair(first, second);
	}

	public SMPLObject visitExpCar(ExpCar exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject obj = exp.getPair().visit(this, env);
		return obj.car();
	}

	public SMPLObject visitExpCdr(ExpCdr exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject obj = exp.getPair().visit(this, env);
		return obj.cdr();
	}

	public SMPLObject visitExpisPair(ExpisPair exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject obj = exp.getExp().visit(this, env);
		return obj.isPair();
	}

	public SMPLObject visitExpList(ExpList exp, Environment<SMPLObject> env) throws VisitException {
		ArrayList<SMPLObject> evaledElements = new ArrayList<SMPLObject>();
		for (Exp element : exp.getElements()) {
			evaledElements.add(element.visit(this, env));
		}
		SMPLList list = new SMPLList(evaledElements);
		return list.constructListOfPairs();
	}

	/*
	 * public SMPLObject visitExpDef(ExpDef exp, Environment<SMPLObject> env) throws
	 * VisitException {
	 * SMPLObject obj = exp.getExp().visit(this, env);
	 * //return obj.isPair();
	 * return new SMPLDouble(2.0);
	 * }
	 */

	public SMPLObject visitExpPow(ExpPow exp, Environment<SMPLObject> env)
			throws VisitException {
		SMPLObject val1, val2;
		val1 = exp.getExpL().visit(this, env);
		val2 = exp.getExpR().visit(this, env);
		return val2.raise(val1); // one specific to SMPLInt and one to SMPLDouble will be implemented
	}

	// print visit methods

	// logic methods
	public SMPLObject visitExpLogic(ExpLogic exp, Environment<SMPLObject> env)
			throws VisitException {
		// placeholder intialization
		SMPLObject val1 = new SMPLDouble(1.0);
		return val1;
	}

	public SMPLObject visitExpSize(ExpSize exp, Environment<SMPLObject> env)
			throws VisitException {
		// placeholder intialization
		SMPLObject val1 = new SMPLDouble(1.0);
		return val1;
	}

	public SMPLObject visitExpIf(ExpIf ei, Environment<SMPLObject> env) throws VisitException {
		SMPLObject conditionResult = ei.getPredicate().visit(this, env);
		SMPLObject isTrueResult = conditionResult.isTrue();
		if (isTrueResult instanceof SMPLBoolean && ((SMPLBoolean) isTrueResult).getValue()) {
			return ei.getConsequent().visit(this, env);
		} else if (ei.hasAlternate()) {
			return ei.getAlternate().visit(this, env);
		} else {
			return new SMPLInt(0);
		}
	}

	public SMPLObject visitExpSeq(ExpSeq exp, Environment<SMPLObject> env) throws VisitException {
		List<Exp> expressions = exp.getExpressions();
		SMPLObject result = new SMPLInt(0); // default value for an empty sequence
		for (Exp e : expressions) {
			result = e.visit(this, env);
		}
		return result;
	}

	public SMPLObject visitExpLet(ExpLet exp, Environment<SMPLObject> env) throws VisitException {
		ArrayList<Binding> binding = exp.getBindings();
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<SMPLObject> objs = new ArrayList<SMPLObject>();
		Exp body = exp.getBodyExp();

		// create a new environment extended by the bindings
		for (Binding b : binding) {
			String id = b.getId();
			Exp value = b.getValueExp();
			SMPLObject evalValue = value.visit(this, env);
			ids.add(id);
			objs.add(evalValue);
			// env.put(id, evalValue);
		}
		Environment<SMPLObject> letFrame = new Environment<SMPLObject>(env, ids, objs);
		// evaluate the body in the extended environment
		SMPLObject result = body.visit(this, letFrame);
		return result;
	}

	public SMPLObject visitExpBind(Binding binding, Environment<SMPLObject> env) throws VisitException {
		// create a new binding
		Exp exp = binding.getValueExp();
		SMPLObject bind = exp.visit(this, env);
		env.put(binding.getId(), bind);
		return defaultValue;
	}

	public SMPLObject visitExpPrint(ExpPrint exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject result = exp.getExp().visit(this, env);
		System.out.print(result.toString());
		return result;
	}

	public SMPLObject visitExpPrintln(ExpPrintln exp, Environment<SMPLObject> env) throws VisitException {
		SMPLObject result = exp.getExp().visit(this, env);
		System.out.println(result.toString());
		return result;
	}
	/*
	 * public SMPLObject raise(SMPLObject root1, SMPLDouble root2) {
	 * // power is done by right to left
	 * // whatever is in the right subtree is raised to that in the left subtree
	 * // SMPLObject ans = 1.0;
	 * SMPLObject ans = new SMPLDouble(1.0);
	 * for (int i = 0; i < root1; i++) {
	 * ans = root2.mult(ans);
	 * }
	 * return ans;
	 * } // create a raise method then implement it in
	 */

	public SMPLObject visitExpLit(ExpLit exp, Environment<SMPLObject> env)
			throws VisitException {
		return exp.getVal();
	}

	public SMPLObject visitExpVar(ExpVar exp, Environment<SMPLObject> env)
			throws VisitException {
		return env.get(exp.getVar());
	}

	/*
	 * public SMPLObject visitExpLogic(ExpLogic exp, Environment<SMPLObject> env)
	 * throws VisitException {
	 * boolean b = exp.operator.apply(exp.left.visit(this, env),
	 * exp.right.visit(this, env));
	 * //SMPLBoolean x = new SMPLBoolean(b);
	 * return b ? 1.0 : 0;
	 * }
	 * 
	 * // IMPLEMENT THE VARIOUS visit methods for all the necessary operations
	 * 
	 * public SMPLObject visitExpIf(ExpIf exp, Environment<SMPLObject> env)
	 * throws VisitException {
	 * double res = exp.predicate.visit(this, env);
	 * if (res == 1.0) {
	 * return exp.consequent.visit(this, env);
	 * } else {
	 * if (exp.alternative != null) {
	 * return exp.alternative.visit(this, env);
	 * } else {
	 * return 0.0;
	 * }
	 * }
	 * }
	 */

}
