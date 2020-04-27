import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class parse {
    private List<String> data;
    private List<String> data2;
    private String[] stats;
    private String[] type;
    private String[] move;

    public void parse(String id) {

        Scanner sc = null;
        try {
            sc = new Scanner(new File("stats.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String current = "";
        while (sc.hasNextLine()) {
            current = sc.nextLine();
            if (current.contains(id)) {
                break;
            }
        }
        String[] a = current.split(" ");
        List<String> list = Arrays.asList(a);
        System.out.println(list);
        this.data = data;

        //again
        try {
            sc = new Scanner(new File("moves.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> l2 = new ArrayList<String>();
        boolean save = false;
        boolean strike = false;

        while (sc.hasNextLine()) {
            current = sc.nextLine();
            if (current.contains(id)) {
                save = true;
            }
            if (save == true){
                if (current.trim().length() == 0){
                    if (strike == false){
                        strike = true;
                    }
                    else if (strike = true){
                        save = false;
                    }
                }
                else {
                    l2.add(current);
                }
            }
        }
        l2.remove(0);
        String[] move = l2.toArray(new String[0]);
        for (int i = 0; i < move.length; i++){
            String keep = move[i];
            keep.trim();
            move[i] = keep;
            System.out.println(move[i]);
        }
        this.move = move;


    }
    public void setStats() {
        stats = new String[5];
        stats[0] = data.get(1);
        stats[1] = data.get(2);
        stats[2] = data.get(3);
        stats[3] = data.get(4);
        stats[4] = data.get(5);
    }
    public void setType() {
        type = new String[2];
        stats[0] = data.get(6);
        stats[0] = data.get(7);
    }
    public String[] getStats(){
        return stats;
    }
    public String[] getType(){
        return type;
    }
    public String[] getMoves(){
        return move;
    }
}

