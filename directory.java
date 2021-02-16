import java.util.ArrayList;
import java.util.List;

public class directory extends entry {

    final String name;
    final List<entry> content;
    final String location;

    public directory(final String di_name, final String dir){
        this.name = di_name;
        content = new ArrayList<>();
        this.location = dir;
    }

    public void insert(entry dir_file){
        content.add(dir_file);
    }

    public boolean hasContent(){
        if (content.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public String entryName() {
        return this.name;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public int size() {
        return content.size();
    }

    @Override
    public String location() {
        return this.location;
    }
    
}
