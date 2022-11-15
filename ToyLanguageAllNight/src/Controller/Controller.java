package Controller;

import Model.ADT.Stack.MyIStack;
import Model.PrgState.PrgState;
import Model.Statement.IStmt;
import Repository.IRepository;

public class Controller {

    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public PrgState oneStep(PrgState state) throws Exception {
        MyIStack<IStmt> stk = state.getExeStack();
        if (stk.isEmpty()) throw new Exception("prgstate stack is empty");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }


    public void allStep() throws Exception {
        PrgState prg = repo.getCrtPrg(); // repo is the controller field of type MyRepoInterface
        // here you can display the prg state
        System.out.println(prg.toString());
        this.repo.logPrgStateExec();
        while (!prg.getExeStack().isEmpty()) {
            oneStep(prg);
            System.out.println(prg);
            this.repo.logPrgStateExec();
            //here you can display the prg state
        }
    }

    public void addPrg(PrgState prg){
        this.repo.addPrg(prg);
    }
}
