package Model.Expression;

import Model.ADT.Dictionary.MyIDictionary;
import Model.Value.Value;

public interface Exp {
    public Value eval(MyIDictionary<String,Value> tbl) throws Exception;
    public String toString();
}