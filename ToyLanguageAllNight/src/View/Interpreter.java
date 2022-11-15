package View;

import Controller.Controller;
import Model.ADT.Dictionary.FileDictionary;
import Model.ADT.Dictionary.MyDictionary;
import Model.ADT.Dictionary.MyIDictionary;
import Model.ADT.List.MyIList;
import Model.ADT.List.MyList;
import Model.ADT.Stack.MyIStack;
import Model.ADT.Stack.MyStack;
import Model.Expression.ValueExp;
import Model.PrgState.PrgState;
import Model.Statement.*;
import Model.Type.IntType;
import Model.Value.StringValue;
import Model.Value.Value;
import Repository.IRepository;
import Repository.Repository;

import java.io.BufferedReader;

class Interpreter {
    public static void main(String[] args) {
        IStmt ex1 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new OpenRFileStmt(new ValueExp(new StringValue("log.txt"))), new ReadFileStmt(new ValueExp(new StringValue("log.txt")), "a")));
                        // new ReadFileStmt(new ValueExp(new StringValue("log.txt")), "a")));

        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl = new MyDictionary<String, Value>();
        MyIList<Value> ot = new MyList<Value>();
        FileDictionary<String, BufferedReader> fileTable = new FileDictionary<String, BufferedReader>();

        PrgState prg1 = new PrgState(stk, symtbl, ot, fileTable, ex1);
        IRepository repo1 = new Repository(prg1, "log1.txt");
        Controller ctr1 = new Controller(repo1);
        //IStmt ex2=new ....;
     //   PrgState prg2 = new PrgState(stk, symtbl, ot, fileTable, ex1);
      //  IRepository repo2 = new Repository(prg2, "log2.txt");
       // Controller ctr2 = new Controller(repo2);

       // PrgState prg3 = new PrgState(stk, symtbl, ot, fileTable, ex1);
       // IRepository repo3 = new Repository(prg3, "log3.txt");
       // Controller ctr3 = new Controller(repo3);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), ctr1));
        //menu.addCommand(new RunExample("2", ex1.toString(), ctr2));
        //menu.addCommand(new RunExample("3", ex1.toString(), ctr3));
        menu.show();
    }

}