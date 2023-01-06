public class ExpPow extends ExpBinOp{

    public ExpPow(Exp e1, Exp e2) {
        super("^", e1, e2);
        }

        public <S, T> T visit(Visitor<S,T> v, S arg) throws VisitException {
            return v.visitExpPow(this, arg);
        }
    
        /*public int eval() {
        Exp exp1 = getSubTree(0);
        Exp exp2 = getSubTree(1);
        return raise(exp1.eval(), exp2.eval()); // raise func will be passed here with exp1 and exp2 as arguments
        }
    
        public String toString() {
        Exp exp1 = getSubTree(0);
        Exp exp2 = getSubTree(1);
        return exp1.toString() + " ^ " + exp2.toString();
        }

        public int raise(int root1, int root2){
            // power is done by right to left
            // whatever is in the right subtree is raised to that in the left subtree
            int ans = 1;
            for (int i = 0; i < root1; i++){
                ans = root2 * ans;
            }
            return ans;
        }*/
}