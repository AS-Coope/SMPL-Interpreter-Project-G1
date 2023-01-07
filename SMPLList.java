public class SMPLList extends SMPLObject {
    private SMPLPair head;
    private SMPLList tail;
    private static SMPLList NIL = new SMPLList();

    public SMPLList() {
        super();
        head = null;
        tail = null;
    }

    public SMPLList(SMPLPair head, SMPLList tail) {
        this.head = head;
        this.tail = tail;
    }

    public SMPLPair getHead() {
        return head;
    }

    public SMPLList getTail() {
        return tail;
    }

    public static SMPLList list(SMPLObject... elements) {
        SMPLList list = NIL;
        for (int i = elements.length - 1; i >= 0; i--) {
            list = new SMPLList(new SMPLPair(elements[i], list), null);
        }
        return list;
    }

    @Override
    public SMPLObject iseqv(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLList) {
            SMPLList other = (SMPLList) obj;
            return new SMPLBoolean(this == other);
        } else {
            return new SMPLBoolean(false);
        }
    }

    @Override
    public SMPLObject isequal(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLList) {
            SMPLList other = (SMPLList) obj;
            return new SMPLBoolean(this.equals(other));
        } else {
            return new SMPLBoolean(false);
        }
    }
}