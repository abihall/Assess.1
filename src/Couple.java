public class Couple {

    final private int MAX = 5;
    private Person[] p1, p2;
    private int total;

    //--------------------------------------------------------------------------------------
    public Couple() {
        p1 = new Person[MAX];
        p2 = new Person[MAX];
        total = 0;
    }

    //--------------------------------------------------------------------------------------
    public void addData(String name1, int age1, String name2, int age2) {
        p1[total] = new Person();
        p2[total] = new Person();
        setData1(p1[total], name1, age1);
        setData1(p2[total], name2, age2);
        total++;
    }

    private void setData1(Person p, String name, int age) {
        p.setName(name);
        p.setAge(age);
    }

    //--------------------------------------------------------------------------------------
    public String test(int current) {
        if (current != -1) {
            if (p1[current].getAge() < p2[current].getAge()) return ("GOOD FOR " + p2[current].getName() + "!");
            else return ("GOOD FOR " + p1[current].getName() + "!");
        }
        return "error";
    }

    public String display(int current) {
        return ("p1: " + p1[current].getName() + "," + p1[current].getAge() + "\np2:" + p2[current].getName() + "," + p2[current].getAge());
    }

    public double average(int current) {
        double Age1 = p1[current].getAge();
        double Age2 = p2[current].getAge();
        return ((Age1 + Age2) / 2);
    }

    public int difference() {
        int diff1 = 0, diff2, pos = 0;
        for (int i = 0; i < total; i++) {
            diff2 = Math.abs(p1[i].getAge() - p2[i].getAge());
            if (diff2 > diff1) {
                pos = i;
                diff1 = diff2;
            }
        }
        return pos;
    }

    public double averagediff() {
        double tot = 0;
        for (int i = 0; i < total; i++) {
            tot = tot + Math.abs(p1[i].getAge() - p2[i].getAge());
        }
        return tot/total;
    }
}


