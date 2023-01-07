import java.io.Reader;
import java.io.StringReader;
import lib3652.util.Interpreter;
import lib3652.util.ResultType;
import lib3652.util.Result;
import lib3652.util.TokenException;

public class ArithInterpreter extends AssessmentVisitor<Environment<SMPLObject>,
							 SMPLObject> {
    /**
     * Create a new Arithmetic Interpreter with a default global environment.
     */ 
    public ArithInterpreter() {
	super(new Evaluator(new SMPLDouble(0D)));
    }

    public Result toResult(SMPLObject r) {
        if (r instanceof SMPLDouble){
	        return new Result(ResultType.V_REAL, ((SMPLDouble)r).getValue());
        } else if (r instanceof SMPLInt){
            return new Result(ResultType.V_INT, ((SMPLInt) r).getValue());
        } else {
            return new Result(ResultType.V_STRING, r.toString());
        }
    }
}
