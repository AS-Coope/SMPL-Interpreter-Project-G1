import java.util.ArrayList;

public class SMPLList extends SMPLObject {

    ArrayList<SMPLObject> elements;

    public SMPLList(ArrayList<SMPLObject> elements) {
        this.elements = elements;
    }

    public ArrayList<SMPLObject> getElements() {
        return elements;
    }

    @Override
    public SMPLObject isPair() throws SMPLException {
        return new SMPLBoolean(false);
    }

    @Override
    public SMPLObject car() throws SMPLException {
        throw new SMPLException("Error: Attempted to get the car of a non-pair object.");
    }

    @Override
    public SMPLObject cdr() throws SMPLException {
        throw new SMPLException("Error: Attempted to get the cdr of a non-pair object.");
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < elements.size(); i++) {
            result += elements.get(i);
            if (i < elements.size() - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public SMPLPair constructListOfPairs() {
        SMPLPair current = new SMPLPair(elements.get(0), new SMPLPair());
        SMPLPair result = current;
        for (int i = 1; i < elements.size(); i++) {
            current.setSecond(new SMPLPair(elements.get(i), new SMPLPair()));
            current = (SMPLPair) current.getSecond();
        }
        return result;
    }
}