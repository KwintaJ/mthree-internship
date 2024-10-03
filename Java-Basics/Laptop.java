public class Laptop
{
    private Camera cam;
    private Storage stg;
    private Processor proc;
    private String logo;

    Laptop(Camera c, Storage s, Processor p, String l)
    {
        cam = c;
        stg = s;
        proc = p;
        logo = l;
    }

    void laptopInfo()
    {
        String info = logo + " ";
        info += cam.getSensorSize() + " ";
        info += cam.getMegapixels() + " ";
        info += stg.getType() + " ";
        info += stg.getSize() + " ";
        info += proc.getCores() + " ";
        info += proc.getGen();

        System.out.println(info);
    }

    public static void main(String[] args)
    {
        Camera aHJ187 = new Camera(2, 32);
        Camera ppp9 = new Camera(4, 6);

        Storage hdd5000 = new Storage("A", 512);
        Storage kingston1000 = new Storage("B", 1024);

        Processor amdRyzen = new Processor(8, "1000");
        Processor intelI5 = new Processor(4, "i5-800");

        Laptop safia = new Laptop(aHJ187, hdd5000, amdRyzen, "LENOVO");
        Laptop jordan = new Laptop(ppp9, kingston1000, intelI5, "LENOVO");

        safia.laptopInfo();
        jordan.laptopInfo();
    }
}

class Camera
{
    private int sensorSize;
    private int megapixels;

    Camera(int ss, int mp)
    {
        sensorSize = ss;
        megapixels = mp;
    }

    int getSensorSize()
    {
        return sensorSize;
    }

    int getMegapixels()
    {
        return megapixels;
    }
}

class Storage
{
    private String type;
    private int size;

    Storage(String t, int s)
    {
        type = t;
        size = s;
    }

    String getType()
    {
        return type;
    }

    int getSize()
    {
        return size;
    }
}

class Processor
{
    private int cores;
    private String gen;

    Processor(int c, String g)
    {
        cores = c;
        gen = g;
    }

    int getCores()
    {
        return cores;
    }

    String getGen()
    {
        return gen;
    }
}