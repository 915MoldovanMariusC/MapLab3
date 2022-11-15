package Model.PrgState;

import Model.ADT.Dictionary.FileDictionary;
import Model.ADT.Dictionary.MyIDictionary;
import Model.ADT.List.MyIList;
import Model.ADT.Stack.MyIStack;
import Model.Statement.IStmt;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;

public class PrgState{
    MyIStack<IStmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    IStmt   originalProgram;

    public FileDictionary<String, BufferedReader> getFileTable() {
        return fileTable;
    }

    public void setFileTable(FileDictionary<String, BufferedReader> fileTable) {
        this.fileTable = fileTable;
    }

    FileDictionary<String, BufferedReader> fileTable;

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }


    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIList<Value> ot, FileDictionary<String, BufferedReader> fileTable, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        this.fileTable = fileTable;
        //TODO: ceva
       // originalProgram=deepCopy(prg);
        stk.push(prg);
    }
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("EXE STACK:\n");
        string.append(exeStack.toString()).append("\n");
        string.append("SYM TABLE\n");
        string.append(symTable.toString()).append("\n");
        string.append("OUT:\n");
        string.append(out.toString()).append("\n");
        string.append("FILE TABLE\n");
        string.append(fileTable.toString()).append("\n");
        return string.toString();
    }
}