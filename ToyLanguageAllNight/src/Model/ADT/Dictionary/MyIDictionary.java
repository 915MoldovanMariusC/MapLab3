package Model.ADT.Dictionary;

import Model.Value.Value;

public interface MyIDictionary<Key, Value> {
    void add(Key key, Value value);

    boolean isDefined(Key id);

    Value lookup(Key id);

    void update(Key id, Value val);
}
