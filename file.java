public class file extends entry{
    //Campi
    final String name;
    final int size;
    final String location;

    public file(final String fileName, final int size,String dir){
        this.name = fileName;
        this.size = size;
        this.location = dir;
    }



	@Override
    public String entryName() {
        return this.name;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
    
    public int size(){
        return this.size;
    }

    @Override
    public String location() {
        return this.location;
    }
}
