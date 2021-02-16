import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        fileSystem F = new fileSystem();
        String currentDir = ":";
        while (s.hasNext()){
            String line = s.nextLine();
            String[] input = line.split(" ");
            switch (input[0]){
                case "ls":
                    F.ls(currentDir);
                break;
                case "mkdir":
                F.mkdir(input[1], currentDir);
                break;
                case "mkfile":
                if (input.length > 2){
                    F.mkfile(input[1], Integer.parseInt(input[2]),currentDir);
                }else{
                }
                break;
                case "size":
                        F.size(currentDir);
                    
                break;
                case "cd":
                if (input.length > 1){
                    if (currentDir.equals(":")){
                        currentDir = ":" + input[1];
                    }else{
                        currentDir = currentDir + ':'+ input[1];
                    }
                }else{
                    currentDir = ":";
                }
                break;
                case "pwd":
                if (currentDir.equals(":")){
                    continue;
                }
                System.out.println(currentDir);
                break;
            }
        }
        s.close();
        //System.out.println(F.toString());
    }    
}
