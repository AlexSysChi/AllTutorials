package serialization.binary;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CustomObject implements Externalizable {
    private static final long serialVersionUID = 2122330689795063923L;

    private transient boolean b;

    private boolean getB() {
        return b;
    }

    private void setB(boolean b) {
        this.b = b;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(getB());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setB(in.readBoolean());
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "b=" + b +
                '}';
    }
}
