package src.main.java;

public interface ITruck<T> extends ICar, IPlatform<T> {

    public void setPlatform(IPlatform<T> platform);



}
