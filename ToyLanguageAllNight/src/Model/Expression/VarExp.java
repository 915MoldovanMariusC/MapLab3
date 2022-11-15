package Model.Expression;

import Model.ADT.Dictionary.MyIDictionary;
import Model.Value.Value;

public class VarExp implements Exp{
    String id;
    //....

    public VarExp(String id){
        this.id = id;
    }
    public Value eval(MyIDictionary<String,Value> tbl)  throws Exception {
        return tbl.lookup(id);
    }


}