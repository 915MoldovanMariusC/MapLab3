package Model.Expression;

import Model.ADT.Dictionary.MyIDictionary;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;

class LogicExp implements Exp{
    Exp e1;
    Exp e2;
    int op;
    //...

    public LogicExp(int op, Exp e1, Exp e2){
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    public Value eval(MyIDictionary<String,Value> tbl) throws Exception{
        Value v1, v2;
        v1 = e1.eval(tbl);
        if(v1.getType().equals(new BoolType())){
            v2 = e2.eval(tbl);
            if(v2.getType().equals(new BoolType())){
                BoolValue b1 = (BoolValue) v1;
                BoolValue b2 = (BoolValue) v2;
                boolean bool1, bool2;
                bool1 = b1.getVal();
                bool2 = b2.getVal();
                if(op == 1){ // op == 1 AND
                    return new BoolValue(bool1 && bool2);
                }
                return new BoolValue(bool1 || bool2);

            }
            throw new Exception("OP2 IS NOT A BOOL");
        }
        throw new Exception("OP1 IS NOT A BOOL");

    }
    //....
}