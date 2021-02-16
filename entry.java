/**
 * ABSTRACT class
 * per implementare una entry gli elementi devono ereditare la classe
 * ed implementare le classi astratte
 */
abstract class entry{
    public abstract String entryName();
	public abstract boolean isFile();
    public abstract boolean isDirectory();
    public abstract int size();
    public abstract String location();
}