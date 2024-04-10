import java.util.ArrayList;

public class Buffer {
    private int N = 2;
    private ArrayList<Double> arrayList = new ArrayList<Double>();

    public int getSize()
    {
        return arrayList.size();
    }
    public int getN() {
        return N;
    }

    public void addElement(double element)
    {
        arrayList.add(element);
    }
    public double removeElement()
    {
        double returnElement = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        return returnElement;
    }
}
