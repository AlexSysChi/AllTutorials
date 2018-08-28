package serialization.binary.template;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableTemplate implements Externalizable {
    private static final long serialVersionUID = -1411356158592057189L;

    // own serialization protocol, standard serialization workflow don't implements
    // (no all metadata etc), works only logic from these methods
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
