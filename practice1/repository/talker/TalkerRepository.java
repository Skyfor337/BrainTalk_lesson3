package lesson2.practice1.repository.talker;

public class TalkerRepository {

    String[] registeredTalkers = new String[3];

    public void addTalker(String talkerToAdd) {
        if (isFull()) {
            registeredTalkers = grow(registeredTalkers);
        }

        for (int i = 0; i < registeredTalkers.length; i++) {
            String user = registeredTalkers[i];
            if (user == null) {
                registeredTalkers[i] = talkerToAdd;
                return;
            }
        }
    }

    private String findByName(String talkersName) {
        for (String registeredTalker : registeredTalkers) {
            if (talkersName.equals(registeredTalker)) {
                return registeredTalker;
            }
        }
        return null;
    }

    public String[] findAll() {
        if (isEmpty()) {
            return new String[0];
        }

        String [] result = new String[currentSize()];
        int i = 0;
        for (String registeredTalker : registeredTalkers) {
            if (registeredTalker != null) {
                result[i++] = registeredTalker;
            }
        }
        return result;
    }

    public boolean isRegistered(String talkersName) {
        return null != findByName(talkersName);
    }

    public boolean isEmpty() {
        for (String talker : registeredTalkers) {
            if (talker != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isFull() {
        for (String talker : registeredTalkers) {
            if (talker == null) {
                return false;
            }
        }
        return true;
    }

    private int currentSize() {
        int size = 0;
        for (String registeredTalker : registeredTalkers) {
            if (registeredTalker != null) {
                size++;
            }
        }
        return size;
    }

    @SuppressWarnings("ManualArrayCopy")
    private String[] grow(String [] originArray) {
        int newSize = originArray.length * 2;
        String[] newArray = new String[newSize];
        for (int i = 0; i < originArray.length; i++) {
            newArray[i] = originArray[i];
        }
        return newArray;
    }
}
